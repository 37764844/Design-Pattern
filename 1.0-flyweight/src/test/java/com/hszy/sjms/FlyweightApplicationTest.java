package com.hszy.sjms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSON;
import com.hszy.sjms.flyweight.controller.ActivityController;
import com.hszy.sjms.flyweight.model.Activity;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FlyweightApplication.class)
@WebAppConfiguration
@Slf4j
public class FlyweightApplicationTest {

	@Test
	public void test_queryActivityInfo() throws InterruptedException {
		ActivityController activityController = new ActivityController();
		for (int idx = 0; idx < 10; idx++) {
			Long req = 10001L;
			Activity activity = activityController.queryActivityInfo(req);
			log.info("测试结果：{} {}", req, JSON.toJSONString(activity));
			Thread.sleep(1200);
		}
	}
}