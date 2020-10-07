package com.hszy.sjms.bridge.mode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PayFaceMode implements IPayMode {

	public boolean security(String uId) {
		log.info("⼈脸⽀付，⻛控校验脸部识别");
		return true;
	}
}