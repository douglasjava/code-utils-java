from datetime import datetime
import requests
import json

def get_selic_over(start_date, end_date):
    url = f"https://api.bcb.gov.br/dados/serie/bcdata.sgs.1178/dados?formato=json&dataInicial={start_date}&dataFinal={end_date}"
    response = requests.get(url)
    data = json.loads(response.text)
    taxas = {}
    for item in data:
        dt = datetime.strptime(item["data"], "%d/%m/%Y").strftime("%Y-%m-%d")
        valor = float(item["valor"].replace(",", ".")) / 100
        taxas[dt] = valor
    return taxas

def calcular_ftms(taxas, data_inicio, data_fim):
    datas = sorted([d for d in taxas if data_inicio <= d <= data_fim])
    ftms = {}
    acumulado = 1.0
    for dt in datas:
        taxa = taxas[dt]
        acumulado *= (1 + taxa / 252)
        ftms[dt] = acumulado
    return ftms

if __name__ == "__main__":
    data_amortizacao = "2024-12-27"
    data_d_menos_1 = "2025-06-24"
    data_honra = "2025-06-25"

    start_date = "27/12/2024"
    end_date = "25/06/2025"

    saldo_devedor_anterior = 180304.80
    amortizacao_original = 31.88

    taxas = get_selic_over(start_date, end_date)
    ftms_map = calcular_ftms(taxas, data_amortizacao, data_honra)

    ftms_A = ftms_map.get(data_amortizacao)
    ftms_D_1 = ftms_map.get(data_d_menos_1)
    ftms_D = ftms_map.get(data_honra)

    amortizacao_corrigida = amortizacao_original * (ftms_D / ftms_A)
    saldo_corrigido = saldo_devedor_anterior * (ftms_D / ftms_D_1)
    valor_final = saldo_corrigido - amortizacao_corrigida

    print("=== Fatores FTMS ===")
    print("FTMS_A   :", round(ftms_A, 8))
    print("FTMS_D-1 :", round(ftms_D_1, 8))
    print("FTMS_D   :", round(ftms_D, 8))
    print("\n=== Cálculo Final ===")
    print("Saldo Devedor Anterior  :", saldo_devedor_anterior)
    print("Saldo Corrigido         :", round(saldo_corrigido, 2))
    print("Amortização Corrigida   :", round(amortizacao_corrigida, 2))
    print("Valor a ser Honrado (VH):", round(valor_final, 2))