package com.hszy.sjms.service.engine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.hszy.sjms.service.logic.LogicFilter;
import com.hszy.sjms.service.logic.impl.UserAgeFilter;
import com.hszy.sjms.service.logic.impl.UserGenderFilter;

public class EngineConfig {

	public static Map<String, LogicFilter> logicFilterMap;

	static {
		logicFilterMap = new ConcurrentHashMap<>();
		logicFilterMap.put("userAge", new UserAgeFilter());
		logicFilterMap.put("userGender", new UserGenderFilter());
	}

	public Map<String, LogicFilter> getLogicFilterMap() {
		return logicFilterMap;
	}

	public void setLogicFilterMap(Map<String, LogicFilter> logicFilterMap) {
		this.logicFilterMap = logicFilterMap;
	}
}
