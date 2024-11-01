package com.laptrinhjavaweb.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
	private String value;
	// nap du lieu vao model
	public <T> T toModel(Class<T> tClass) {
		try {
			// doc du lieu map ve cho phia model data access layer
			return new ObjectMapper().readValue(value, tClass);	
		}
		catch (Exception e) {
			return null;
		}
	}
	
 	public HttpUtil(String value) {
 		this.value = value;
	}

	public static HttpUtil of (BufferedReader reader) {
	    StringBuilder sb = new StringBuilder();
	    String line;
	    try {
			while ((line = reader.readLine()) != null) {
			    sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new HttpUtil(sb.toString());
	}
}
