package com.hszy.sjms.matter.builder;

import com.hszy.sjms.matter.Matter;

public interface IMenu {

    /**
     * 吊顶
     */
    IMenu appendCeiling(Matter matter);

    /**
     * 涂料
     */
    IMenu appendCoat(Matter matter);

    /**
     * 地板
     */
    IMenu appendFloor(Matter matter);


    /**
     * 明细
     */
    String getDetail();
}
