import requests
import json
from datetime import datetime

def format_bcb_date(date_str):
    return datetime.strptime(date_str, "%Y-%m-%d").strftime("%d/%m/%Y")

def fetch_selic_over(start_date, end_date):
    start_fmt = format_bcb_date(start_date)
    end_fmt = format_bcb_date(end_date)
    url = f"https://api.bcb.gov.br/dados/serie/bcdata.sgs.1178/dados?formato=json&dataInicial={start_fmt}&dataFinal={end_fmt}"
    response = requests.get(url)
    data = json.loads(response.text)
    taxas = {}
    for item in data:
        dt = datetime.strptime(item['data'], "%d/%m/%Y").strftime("%Y-%m-%d")
        taxa = float(item['valor'].replace(",", ".")) / 100
        taxas[dt] = taxa
    return taxas

def calcular_ftms(taxas, data_inicio, data_fim):
    datas = sorted(taxas.keys())
    acumulado = 1.0
    ftms_map = {}
    for dt in datas:
        if dt < data_inicio:
            continue
        if dt > data_fim:
            break
        taxa_diaria = taxas[dt] / 252
        acumulado *= (1 + taxa_diaria)
        ftms_map[dt] = acumulado
    return ftms_map

def obter_ftms(ftms_map, data):
    if data not in ftms_map:
        raise Exception(f"FTMS não encontrado para {data}")
    return ftms_map[data]

def calcular_honra_pronampe():
    # Entradas do usuário
    data_liberacao = "2024-10-24"
    data_honra = "2025-08-23"
    data_anterior_honra = "2025-08-22"
    data_amortizacao = data_liberacao  # mesma data se não houver amortização

    valor_liberado = 46799.99
    saldo_devedor_anterior = 47000.00
    amortizacao = 0.00

    # Busca taxas
    taxas = fetch_selic_over(data_liberacao, data_honra)
    ftms_map = calcular_ftms(taxas, data_liberacao, data_honra)

    # Busca FTMS específicos
    ftms_L = obter_ftms(ftms_map, data_liberacao)
    ftms_D = obter_ftms(ftms_map, data_honra)
    ftms_D_1 = obter_ftms(ftms_map, data_anterior_honra)
    ftms_A = obter_ftms(ftms_map, data_amortizacao)

    # Aplicação da fórmula
    parte_sd = saldo_devedor_anterior * (ftms_D / ftms_D_1)
    parte_amort = amortizacao * (ftms_D / ftms_A)
    sd_f = valor_liberado + parte_sd - parte_amort

    # Impressão
    print("\n🧾 MEMÓRIA DE CÁLCULO - PRONAMPE")
    print(f"Data da Liberação (LD): {data_liberacao} | FTMS_L: {ftms_L:.8f}")
    print(f"Data da Honra (D): {data_honra} | FTMS_D: {ftms_D:.8f}")
    print(f"Dia útil anterior à honra (D-1): {data_anterior_honra} | FTMS_D-1: {ftms_D_1:.8f}")
    print(f"Data da Amortização: {data_amortizacao} | FTMS_A: {ftms_A:.8f}")
    print(f"\nValor Liberado (LD): R$ {valor_liberado:,.2f}")
    print(f"Saldo Devedor Anterior (SD_D-1): R$ {saldo_devedor_anterior:,.2f}")
    print(f"Amortização (AC_D): R$ {amortizacao:,.2f}")
    print("\n📐 Cálculo:")
    print(f"SD_F = LD + SD_D-1 * (FTMS_D / FTMS_D-1) - AC_D * (FTMS_D / FTMS_L)")
    print(f"SD_F = {valor_liberado:,.2f} + {saldo_devedor_anterior:,.2f} * ({ftms_D:.8f} / {ftms_D_1:.8f}) - {amortizacao:,.2f} * ({ftms_D:.8f} / {ftms_L:.8f})")
    print(f"\n✅ Valor a ser honrado: R$ {sd_f:,.2f}")

if __name__ == '__main__':
    calcular_honra_pronampe()