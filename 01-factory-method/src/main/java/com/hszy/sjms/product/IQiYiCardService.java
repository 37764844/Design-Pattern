package com.hszy.sjms.product;

import com.hszy.sjms.response.AwardRes;

/**
 * 模拟爱奇艺会员卡服务
 */
public class IQiYiCardService {

    public AwardRes grantToken(String bindMobileNumber, String cardId) {
        System.out.println("模拟发放爱奇艺会员卡一张：" + bindMobileNumber + "，" + cardId);
        return new AwardRes("0000", "发放成功");
    }

}
