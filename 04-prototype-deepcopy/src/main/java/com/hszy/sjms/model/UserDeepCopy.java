package com.hszy.sjms.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class UserDeepCopy implements Serializable, Cloneable {

	private static final long serialVersionUID = 8404160198081826236L;

	public String userId;

	public String password;

	public List<String> attribute;

	@SuppressWarnings("unchecked")
	@Override
	public Object clone() throws CloneNotSupportedException {

		UserDeepCopy user = (UserDeepCopy)super.clone();
		
		user.setAttribute((List<String>)((ArrayList<String>)user.getAttribute()).clone());
		
		return user;
	}
	
	public UserDeepCopy deepCopy() throws IOException, ClassNotFoundException {
		
		// 序列化
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		
		// 反序列化
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return (UserDeepCopy) ois.readObject();
	}
}
