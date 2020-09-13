package com.hszy.sjms.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class User implements Serializable, Cloneable {

	private static final long serialVersionUID = 8404160198081826236L;

	public String userId;

	public String password;

	public List<String> attribute;

	@Override
	public Object clone() throws CloneNotSupportedException {

		return super.clone();

	}
}
