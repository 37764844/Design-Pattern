package com.hszy.sjms;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hszy.sjms.bridge.channel.AbstractPay;
import com.hszy.sjms.bridge.channel.WxPay;
import com.hszy.sjms.bridge.channel.ZfbPay;
import com.hszy.sjms.bridge.mode.PayFaceMode;
import com.hszy.sjms.bridge.mode.PayFingerprintMode;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BridgeApplication.class)
@WebAppConfiguration
public class BridgeApplicationTest {

	@Test
	public void payTest() {
		System.out.println("\r\n模拟测试场景；微信⽀付、⼈脸⽅式。");
		AbstractPay wxPay = new WxPay(new PayFaceMode());
		wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));
		System.out.println("\r\n模拟测试场景；⽀付宝⽀付、指纹⽅式。");
		AbstractPay zfbPay = new ZfbPay(new PayFingerprintMode());
		zfbPay.transfer("jlu19dlxo111", "100000109894", new BigDecimal(100));
	}
}