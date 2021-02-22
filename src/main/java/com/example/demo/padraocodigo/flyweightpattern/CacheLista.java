package com.example.demo.padraocodigo.flyweightpattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheLista {

	private static Map<String, List<String>> map = new HashMap<>();

	public static List<String> get(String key) {
		return map.get(key);
	}

	public static void put(String key, String value) {
		List<String> values = null;
		if (map.get(key) == null) {
			values = new ArrayList<>();
			values.add(value);
			map.put(key, values);

		} else {
			map.get(key).add(value);

		}
	}

	public static void remove(String key) {
		map.remove(key);
	}

}
