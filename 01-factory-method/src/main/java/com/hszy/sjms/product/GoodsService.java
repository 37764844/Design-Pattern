package com.hszy.sjms.product;

import com.hszy.sjms.response.AwardRes;

/**
 * 模拟实物商品服务
 */
public class GoodsService {

    public AwardRes deliverGoods(DeliverReq req) {
        System.out.println("模拟发货实物商品一个：" + req.toString());
        return new AwardRes("0000", "发放成功");
    }
}
