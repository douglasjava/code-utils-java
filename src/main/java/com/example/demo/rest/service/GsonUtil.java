package com.example.demo.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Component
public class GsonUtil<T> {

	public List<T> jsonToListObject(String inputString) {
		return new Gson().fromJson(inputString, new TypeToken<List<T>>() {
		}.getType());
	}

	public Object jsonToObject(String inputString, Class<T> T) {
		return new Gson().fromJson(inputString, T);
	}

}
