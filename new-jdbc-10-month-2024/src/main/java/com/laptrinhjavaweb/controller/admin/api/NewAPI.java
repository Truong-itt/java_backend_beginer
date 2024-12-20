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
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.utils.HttpUtil;
import com.laptrinhjavaweb.utils.SessionUtil;



@WebServlet(urlPatterns = { "/api-admin-new" })
public class NewAPI extends HttpServlet{
	
	@Inject
	private INewService newService;
	
	private static final long serialVersionUID = -7056763231377861911L;
	// post du lieu 
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

//		System.out.println(newModel.getThumbnail());
//		System.out.println(newModel.getShortDescription());
//		System.out.println("xin chao moi nguoi");
		newModel.setCreateBy(((UserModel)SessionUtil.getInstance().getValue(request, "USERMODEL")).getFullName());
		newModel = newService.save(newModel);       // save va tim id 
		mapper.writeValue(response.getOutputStream(), newModel);
//		System.out.println(newModel);
		
    }
    
    protected void doPut(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		ObjectMapper mapper  = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		// doc du lieu va format du lieu
		NewModel updateNew = HttpUtil.of(request.getReader()).toModel(NewModel.class);
		updateNew.setCreateBy(((UserModel)SessionUtil.getInstance().getValue(request, "USERMODEL")).getFullName());

		
		
//		System.out.println(updateNew.getId());
//		System.out.println(updateNew.getTitle());
//		System.out.println(updateNew.getThumbnail());
//		System.out.println(updateNew.getShortDescription());
//		System.out.println(updateNew.getContent());
//		System.out.println(updateNew.getCategoryId());
		
		updateNew = newService.update(updateNew);
		mapper.writeValue(response.getOutputStream(), updateNew);
    }
    
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		ObjectMapper mapper  = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewModel newModel = HttpUtil.of(request.getReader()).toModel(NewModel.class);
		newService.delete(newModel.getIds());
		mapper.writeValue(response.getOutputStream(), "{xin chao moi nguoi}");
    }
} 
