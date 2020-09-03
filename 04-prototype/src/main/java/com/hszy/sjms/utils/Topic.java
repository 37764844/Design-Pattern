package com.hszy.sjms.utils;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic {

	/**
	 * 选项：A、B、C、D
	 */
    private Map<String, String> option;
    
    /**
     * 答案：B
     */
    private String key;

}
