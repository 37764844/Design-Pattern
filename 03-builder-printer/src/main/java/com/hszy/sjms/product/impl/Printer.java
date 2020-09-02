package com.hszy.sjms.product.impl;

import org.springframework.stereotype.Service;

import com.hszy.sjms.print.interfaces.ICode;
import com.hszy.sjms.print.interfaces.IProtocol;
import com.hszy.sjms.product.IProduct;

@Service
public class Printer implements IProduct {

	private ICode code;
	
	private IProtocol protocol;
	
	@Override
	public void setCode(ICode code) {
		this.code = code;
		
	}

	@Override
	public void setProtocol(IProtocol protocol) {
		this.protocol = protocol;
		
	}

	@Override
	public void print() {
		System.out.println("Code:" + code.getCodeType() + ", Protocol:" + protocol.getProtocolType() + ".");
	}

}
