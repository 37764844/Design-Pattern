package com.hszy.sjms.service.engine;

import java.util.Map;

import com.hszy.sjms.vo.EngineResult;
import com.hszy.sjms.vo.TreeRich;

public interface IEngine {

	EngineResult process(final Long treeId, final String userId, TreeRich treeRich, final Map<String, String> decisionMatter);

}
