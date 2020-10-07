package com.hszy.sjms.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class FirstDTO implements Serializable {

	private static final long serialVersionUID = -8806037029984245990L;

	private Long id;
	
	private String name;
	
	private Integer age;
	
	private Long linkId;

}
