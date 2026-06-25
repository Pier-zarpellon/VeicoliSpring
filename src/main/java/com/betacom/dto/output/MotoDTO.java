package com.betacom.dto.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class MotoDTO {
	
	private Integer numeroRuote;
	private String targa;
	private Integer cc;
	
}