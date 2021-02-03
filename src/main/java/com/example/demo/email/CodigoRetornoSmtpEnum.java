package com.example.demo.email;

import lombok.Getter;

@Getter
public enum CodigoRetornoSmtpEnum {

	STATUS_221(211,"System status, or system help reply."),
	STATUS_250(250,"OK, queuing for node node started."),
	STATUS_220(220,"Domain service ready.");
	
	private int code;
	private String description;
	
	private CodigoRetornoSmtpEnum(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
}
