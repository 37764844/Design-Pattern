package com.hszy.sjms;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hszy.sjms.controller.QuestionBankController;
import com.hszy.sjms.utils.Topic;
import com.hszy.sjms.utils.TopicRandomUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PrototypeApplication.class)
@WebAppConfiguration
public class PrototypeApplicationTest {

	
	@Test
	public void random() {
        Map<String, String> map01 = new HashMap<String, String>();
        map01.put("A", "JAVA2 EE");
        map01.put("B", "JAVA2 Card");
        map01.put("C", "JAVA2 ME");
        map01.put("D", "JAVA2 HE");
        map01.put("E", "JAVA2 SE");
        
        Topic random = TopicRandomUtil.random(map01, "D");
        
        System.out.println(random);
	}
	
	@Test
	public void testQuestionBank() throws CloneNotSupportedException {
	    QuestionBankController questionBankController = new QuestionBankController();
        System.out.println(questionBankController.createPaper("花花", "1000001921032"));
        System.out.println(questionBankController.createPaper("豆豆", "1000001921051"));
        System.out.println(questionBankController.createPaper("大宝", "1000001921987"));

	}
	
}