package com.example.demo.padraocodigo.flyweightpattern;

import java.util.HashMap;
import java.util.Map;

public class Cache {

	private static Map<String, Object> map = new HashMap<>();

	public static Object get(String key) {
		return map.get(key);
	}

	public static void put(String key, Object value) {
		map.put(key, value);
	}

	public static void remove(String key) {
		map.remove(key);
	}
}
