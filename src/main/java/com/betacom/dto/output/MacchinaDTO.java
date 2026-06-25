package com.betacom.dto.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class MacchinaDTO {

	private Integer numeroRuote;
    private String targa;
    private Integer cc;
    private Integer numeroPorte;
}

