package com.laptrinhjavaweb.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.utils.HttpUtil;



@WebServlet(urlPatterns = { "/api-admin-new" })
public class NewAPI extends HttpServlet{
	
	@Inject
	private INewService newService;
	
	private static final long serialVersionUID = -7056763231377861911L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ObjectMapper mapper  = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		// logic truyen la truyen 
		// HttpUtil.of(request.getReader());
		// hieu va dung no nu mot cai string
		// loi the do no la of duoc dung nen co the hieu no la cua lop day luon 
		// suy ra dugn va trien khai ngay tren mot dong
		NewModel newModel = HttpUtil.of(request.getReader()).toModel(NewModel.class);
//		System.out.println(newModel.getTitle());
//		System.out.println(newModel.getContent());
//		System.out.println(newModel.getCategoryId());
		System.out.println(newModel.getThumbnail());
		System.out.println(newModel.getShortDescription());
//		System.out.println(newModel.getCreatedDate());
//		System.out.println(newModel.getCreateBy());
		System.out.println("xin chao moi nguoi");
		newModel = newService.save(newModel);       // save va tim id 
		mapper.writeValue(response.getOutputStream(), newModel);
		System.out.println(newModel);
		
    }
    
    protected void doPut(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {

    }
    
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {

    }
} 