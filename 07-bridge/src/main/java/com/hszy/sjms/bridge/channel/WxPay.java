package com.hszy.sjms.bridge.channel;

import java.math.BigDecimal;

import com.hszy.sjms.bridge.mode.IPayMode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WxPay extends AbstractPay {
	public WxPay(IPayMode payMode) {
		super(payMode);
	}

	public String transfer(String uId, String tradeId, BigDecimal amount) {
		log.info("模拟微信渠道⽀付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
		boolean security = payMode.security(uId);
		log.info("模拟微信渠道⽀付⻛控校验。uId：{} tradeId：{} security：{}", uId, tradeId, security);
		if (!security) {
			log.info("模拟微信渠道⽀付划账拦截。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
			return "0001";
		}
		log.info("模拟微信渠道⽀付划账成功。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
		return "0000";
	}
}
