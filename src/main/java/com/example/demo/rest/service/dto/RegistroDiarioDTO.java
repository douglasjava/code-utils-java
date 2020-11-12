package com.example.demo.rest.service.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RegistroDiarioDTO implements Comparable<RegistroDiarioDTO> {

	@JsonProperty("dt_ocorrencia")
	private LocalDate dtOcorrencia;

	@JsonProperty("sg_uf")
	private String sgUf;

	@JsonProperty("nu_cpf")
	private String nuCpf;

	@JsonProperty("nu_cnpj")
	private String nuCnpj;

	@JsonProperty("nm_credor")
	private String nmCredor;

	@JsonProperty("tp_operacao")
	private Integer tpOperacao;

	@JsonProperty("vl_unitario")
	private BigDecimal vlUnitario;

	@JsonProperty("qt_itens")
	private Integer qtItens;

	@JsonIgnore
	private String cnpjCpf;

	public LocalDate getDtOcorrencia() {
		return dtOcorrencia;
	}

	public void setDtOcorrencia(LocalDate dtOcorrencia) {
		this.dtOcorrencia = dtOcorrencia;
	}

	public String getSgUf() {
		return sgUf;
	}

	public void setSgUf(String sgUf) {
		this.sgUf = sgUf;
	}

	public String getNuCpf() {
		return nuCpf;
	}

	public void setNuCpf(String nuCpf) {
		this.nuCpf = nuCpf;
	}

	public String getNuCnpj() {
		return nuCnpj;
	}

	public void setNuCnpj(String nuCnpj) {
		this.nuCnpj = nuCnpj;
	}

	public String getNmCredor() {
		return nmCredor;
	}

	public void setNmCredor(String nmCredor) {
		this.nmCredor = nmCredor;
	}

	public Integer getTpOperacao() {
		return tpOperacao;
	}

	public void setTpOperacao(Integer tpOperacao) {
		this.tpOperacao = tpOperacao;
	}

	public BigDecimal getVlUnitario() {
		return vlUnitario;
	}

	public void setVlUnitario(BigDecimal vlUnitario) {
		this.vlUnitario = vlUnitario;
	}

	public Integer getQtItens() {
		return qtItens;
	}

	public void setQtItens(Integer qtItens) {
		this.qtItens = qtItens;
	}

	public String getCnpjCpf() {
		return cnpjCpf;
	}

	public void setCnpjCpf(String cnpjCpf) {
		this.cnpjCpf = cnpjCpf;
	}

	@Override
	public String toString() {
		return "RegistroDiarioDTO [dtOcorrencia=" + dtOcorrencia + ", sgUf=" + sgUf + ", nuCpf=" + nuCpf + ", nuCnpj="
				+ nuCnpj + ", nmCredor=" + nmCredor + ", tpOperacao=" + tpOperacao + ", vlUnitario=" + vlUnitario
				+ ", qtItens=" + qtItens + "]";
	}

	@Override
	public int compareTo(RegistroDiarioDTO obj) {
		if (this == obj) {
			return 0;
		}

		int result = (this.sgUf != null && obj != null && obj.sgUf != null) ? this.sgUf.compareTo(obj.sgUf) : 1;
		result = (result == 0 && this.tpOperacao != null && obj.tpOperacao != null)
				? this.tpOperacao.compareTo(obj.tpOperacao)
				: result;
		result = (result == 0 && this.dtOcorrencia != null && obj.dtOcorrencia != null)
				? this.dtOcorrencia.compareTo(obj.dtOcorrencia)
				: result;
		result = (result == 0 && this.nmCredor != null && obj.nmCredor != null) ? this.nmCredor.compareTo(obj.nmCredor)
				: result;
		return result;
	}

	public static void main(String[] args) {
		List<RegistroDiarioDTO> listaRegistroDiario = new ArrayList<RegistroDiarioDTO>();
		RegistroDiarioDTO r1 = new RegistroDiarioDTO();
		r1.setSgUf("MG");
		r1.setTpOperacao(2);
		r1.setDtOcorrencia(LocalDate.now());
		r1.setNmCredor("BB");

		RegistroDiarioDTO r2 = new RegistroDiarioDTO();
		r2.setSgUf("MG");
		r2.setTpOperacao(1);
		r2.setDtOcorrencia(LocalDate.now());
		r2.setNmCredor("SAFRA");

		listaRegistroDiario.add(r1);
		listaRegistroDiario.add(r2);

		System.out.println(listaRegistroDiario);

		Collections.sort(listaRegistroDiario);

		System.out.println(listaRegistroDiario);
	}
}
