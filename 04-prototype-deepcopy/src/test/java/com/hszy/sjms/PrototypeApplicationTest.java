package com.hszy.sjms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hszy.sjms.model.User;
import com.hszy.sjms.model.UserDeepCopy;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PrototypeApplication.class)
@WebAppConfiguration
public class PrototypeApplicationTest {

	@Test
	public void testClone() throws CloneNotSupportedException {
		// 构建对象
		User user = new User();
		user.setUserId("wangfei");
		user.setPassword("1111");
		List<String> attribute = new ArrayList<String>();
		attribute.add("男");
		attribute.add("23");
		user.setAttribute(attribute);

		User copyUser = (User) user.clone();
		copyUser.setUserId("zhangfei");
		copyUser.getAttribute().add("党员");
		
		System.out.println(user.toString());
		System.out.println(copyUser.toString());
	}
	
	@Test
	public void testDeepCopy() throws CloneNotSupportedException {
		// 构建对象
		UserDeepCopy user = new UserDeepCopy();
		user.setUserId("wangfei");
		user.setPassword("1111");
		List<String> attribute = new ArrayList<String>();
		attribute.add("男");
		attribute.add("23");
		user.setAttribute(attribute);

		UserDeepCopy copyUser = (UserDeepCopy) user.clone();
		copyUser.setUserId("zhangfei");
		copyUser.getAttribute().add("党员");
		
		System.out.println(user.toString());
		System.out.println(copyUser.toString());
	}
	
	@Test
	public void testDeepCopyA() throws ClassNotFoundException, IOException {
		// 构建对象
		UserDeepCopy user = new UserDeepCopy();
		user.setUserId("wangfei");
		user.setPassword("1111");
		List<String> attribute = new ArrayList<String>();
		attribute.add("男");
		attribute.add("23");
		user.setAttribute(attribute);

		UserDeepCopy copyUser = user.deepCopy();
		copyUser.setUserId("zhangfei");
		copyUser.getAttribute().add("党员");
		
		System.out.println(user.toString());
		System.out.println(copyUser.toString());
	}
}