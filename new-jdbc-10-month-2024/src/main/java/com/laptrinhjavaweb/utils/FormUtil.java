package com.laptrinhjavaweb.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import com.laptrinhjavaweb.model.NewModel;

public class FormUtil {
	
	@SuppressWarnings("unchecked")
	public static <T> T toModel(Class<T> clazz, HttpServletRequest request) {
	    T object = null;
	    try {
	        object = clazz.getDeclaredConstructor().newInstance();
	        System.out.println("Object created: " + object.getClass().getName());
	        
	        // In các tham số trong request
	        Map<String, String[]> parameterMap = request.getParameterMap();
	        for (String key : parameterMap.keySet()) {
	            System.out.println("Parameter: " + key + " = " + Arrays.toString(parameterMap.get(key)));
	        }
	        
	        BeanUtils.populate(object, parameterMap);

	        // Kiểm tra giá trị thuộc tính sau khi populate
	        if (object instanceof NewModel) {
	            NewModel model = (NewModel) object;
	            System.out.println("Model type after populate: " + model.getType());
	        }
	        
	    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
	        System.out.print("Exception in FormUtil.toModel: " + e.getMessage());
	        e.printStackTrace();
	    }
	    return object;
	}

}
