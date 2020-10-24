package com.hszy.sjms.flyweight.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Stock {
	private int total; // 库存总量
	private int used; // 库存已用
}
