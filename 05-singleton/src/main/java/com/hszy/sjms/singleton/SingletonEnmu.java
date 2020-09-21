package com.hszy.sjms.singleton;

public enum SingletonEnmu  {
	INSTANCE;
	
	private String content;
	
	
	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	
	public SingletonEnmu getSingletonEnmu() {
		return this;
	}

}
