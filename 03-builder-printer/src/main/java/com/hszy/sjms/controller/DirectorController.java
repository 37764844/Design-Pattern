package com.hszy.sjms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hszy.sjms.builder.Builder;
import com.hszy.sjms.print.interfaces.ICode;
import com.hszy.sjms.print.interfaces.IProtocol;

@Service
public class DirectorController {

	@Autowired
	private Builder builder;
	
	public void printCode() {
		builder.builderCode(new ICode() {			
			@Override
			public String getCodeType() {
				return "二维码";
			}
		});
		
		builder.builderProtocol(new IProtocol() {
			
			@Override
			public String getProtocolType() {
				return "TCP";
			}
		});
		
		builder.getPrinter().print();
	}
}
