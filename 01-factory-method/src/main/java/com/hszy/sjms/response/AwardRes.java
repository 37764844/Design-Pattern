package com.hszy.sjms.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AwardRes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String code; // 编码
    private String info; // 描述
}
