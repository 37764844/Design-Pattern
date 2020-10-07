package com.hszy.sjms.bridge.channel;

import java.math.BigDecimal;

import com.hszy.sjms.bridge.mode.IPayMode;

public abstract class AbstractPay {
	protected IPayMode payMode;

	public AbstractPay(IPayMode payMode) {
	 this.payMode = payMode;
	 }

	public abstract String transfer(String uId, String tradeId, BigDecimal amount);

}
