package com.hszy.sjms.bridge.mode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PayCypher implements IPayMode {

	public boolean security(String uId) {
		log.info("密码⽀付，⻛控校验环境安全");
		return true;
	}
}
