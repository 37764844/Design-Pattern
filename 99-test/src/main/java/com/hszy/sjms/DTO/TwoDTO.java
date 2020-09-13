package com.hszy.sjms.DTO;

import java.io.Serializable;

import lombok.Data;

@Data
public class TwoDTO implements Serializable {

	private static final long serialVersionUID = 4429721546429434861L;
	
	private Long id;
	
	private Long linkId;

}
