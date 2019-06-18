package com.xt.utils;

import java.util.List;

import com.alibaba.fastjson.JSON;

public class StringUtils {

	// 将类转换json

	// 将json转换为Java对象
	public static List jsonToJava(String json, Class cls) {
		return JSON.parseArray(json, cls);
	}
	
	public static String javaToJson(Object obj) {
		return JSON.toJSONString(obj);
	}
}
