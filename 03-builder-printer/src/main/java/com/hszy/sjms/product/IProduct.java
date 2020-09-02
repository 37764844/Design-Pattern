package com.hszy.sjms.product;

import com.hszy.sjms.print.interfaces.ICode;
import com.hszy.sjms.print.interfaces.IProtocol;

public interface IProduct {

	void setCode(ICode code);
	
	void setProtocol(IProtocol protocol);
	
	void print();
}
