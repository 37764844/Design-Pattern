package com.hszy.sjms.builder;

import com.hszy.sjms.print.interfaces.ICode;
import com.hszy.sjms.print.interfaces.IProtocol;
import com.hszy.sjms.product.IProduct;

public interface Builder {
	
	
	
	void builderCode(ICode code);
	
	void builderProtocol(IProtocol protocol);
	
	IProduct getPrinter();
}
