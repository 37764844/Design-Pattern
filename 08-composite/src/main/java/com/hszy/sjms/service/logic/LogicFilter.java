package com.hszy.sjms.service.logic;

import java.util.List;
import java.util.Map;

import com.hszy.sjms.vo.TreeNodeLink;

public interface LogicFilter {

    Long filter(String matterValue, List<TreeNodeLink> treeNodeLineInfoList);
    
    String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);
}
