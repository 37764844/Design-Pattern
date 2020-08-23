package com.hszy.sjms.product;

import com.hszy.sjms.response.AwardRes;

/**
 * 模拟优惠券服务
 */
public class CouponService {

    public AwardRes sendCoupon(String uId, String couponNumber, String uuid) {
        System.out.println("模拟发放优惠券一张：" + uId + "," + couponNumber + "," + uuid);
        return new AwardRes("0000", "发放成功");
    }
}
