package com.hszy.sjms.builder.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hszy.sjms.builder.Builder;
import com.hszy.sjms.print.interfaces.ICode;
import com.hszy.sjms.print.interfaces.IProtocol;
import com.hszy.sjms.product.IProduct;

@Service
public class PrinterBuilder implements Builder {

	@Autowired
	private IProduct product;
	
	@Override
	public void builderCode(ICode code) {
		product.setCode(code);		
	}

	@Override
	public void builderProtocol(IProtocol protocol) {
		product.setProtocol(protocol);	
	}
	
	@Override
	public IProduct getPrinter() {
		return product;
	}
}
