package com.hszy.sjms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hszy.sjms.controller.DirectorController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BuilderPrintApplication.class)
@WebAppConfiguration
public class BuilderPrintApplicationTest {

	@Autowired
	DirectorController controller;
	
	@Test
	public void printCodeTest() {
		controller.printCode();
	}
	
}