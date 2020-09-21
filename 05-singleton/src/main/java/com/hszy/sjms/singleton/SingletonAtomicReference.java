package com.hszy.sjms.singleton;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

public class SingletonAtomicReference implements Serializable {

	private static final long serialVersionUID = -4978476173085592171L;
	
	private static final AtomicReference<SingletonAtomicReference> INSTANCE = new AtomicReference<>();
	
	private SingletonAtomicReference() {
		
	}
	
	private String content;
	
	
	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public static final SingletonAtomicReference getInstance() {
		for(;;) {
			SingletonAtomicReference instance = INSTANCE.get();
			if(null != instance ) {
				return instance;
			}
			INSTANCE.compareAndSet(null, new SingletonAtomicReference());
			return INSTANCE.get();			
		}
	}
}
