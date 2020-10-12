package com.hszy.sjms.service.logic.impl;

import java.util.Map;

import com.hszy.sjms.service.logic.BaseLogic;

public class UserGenderFilter extends BaseLogic {
	
	@Override
	public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
		return decisionMatter.get("gender");
	}
}
