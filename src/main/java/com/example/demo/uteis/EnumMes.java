package com.example.demo.uteis;

import java.time.Month;

import lombok.Getter;

@Getter
public enum EnumMes {

	JANUARY("JAN", Month.JANUARY),
	FEBRUARY("FEB", Month.FEBRUARY),
	MARCH("MAR", Month.MARCH),
	APRIL("APR", Month.APRIL),
	MAY("MAY", Month.MAY),
	JUNE("JUN", Month.JUNE),
	JULY("JUL", Month.JULY),
	AUGUST("AUG", Month.AUGUST),
	SEPTEMBER("SEP", Month.SEPTEMBER),
	OCTOBER("OCT", Month.OCTOBER),
	NOVEMBER("NOV", Month.NOVEMBER),
	DECEMBER("DEC", Month.DECEMBER);
	
	private String sigla;
	private Month month;
	
	private EnumMes(String sigla, Month month) {
		this.sigla = sigla;
		this.month = month;
	}
	
	public static EnumMes fromValue(String sigla) {
		for (EnumMes erro : EnumMes.values()) {
			if (erro.getSigla().equalsIgnoreCase(sigla)) {
				return erro;
			}
		}
		return null;
	}
}
