package com.hszy.sjms.request;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

@Data
public class AwardReq implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String uId;                 // 用户唯一ID
    private Long awardType;          // 奖品类型(可以用枚举定义)；1优惠券、2实物商品、3第三方兑换卡(爱奇艺)
    private String awardNumber;         // 奖品编号；sku、couponNumber、cardId
    private String bizId;               // 业务ID，防重复
    private Map<String, String> extMap; // 扩展信息

}
