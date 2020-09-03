package com.hszy.sjms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hszy.sjms.controller.BuilderController;
import com.hszy.sjms.matter.builder.IMenu;
import com.hszy.sjms.matter.ceiling.impl.LevelOneCeiling;
import com.hszy.sjms.matter.coat.impl.DuluxCoat;
import com.hszy.sjms.matter.floor.impl.DongPengTile;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BuilderApplication.class)
@WebAppConfiguration
public class BuilderApplicationTest {

	@Autowired
	BuilderController builder;
	
	@Test
	public void getDecorationTest() {
		IMenu menu = builder.getDecoration(120.3, new LevelOneCeiling(), new DuluxCoat(), new DongPengTile());
		System.out.println(menu.getDetail());
	}
	
}