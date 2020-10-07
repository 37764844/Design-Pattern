package com.hszy.sjms.bridge.mode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PayFingerprintMode implements IPayMode {
	public boolean security(String uId) {
		log.info("指纹⽀付，⻛控校验指纹信息");
		return true;
	}
}
