package com.hszy.sjms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hszy.sjms.matter.Matter;
import com.hszy.sjms.matter.builder.IMenu;
import com.hszy.sjms.matter.builder.impl.DecorationPackageMenu;

@Service
public class BuilderController {
	
	@Autowired
	DecorationPackageMenu menu;

	public IMenu getDecoration(Double area,Matter ceiling, Matter coat,Matter floor) {
		menu.setArea(area);
		return menu.appendCeiling(ceiling).appendCoat(coat).appendFloor(floor);		
	}
	
}
