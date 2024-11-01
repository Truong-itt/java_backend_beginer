package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.utils.FormUtil;

@WebServlet(urlPatterns = { "/admin-new" })
public class NewController extends HttpServlet{

	private static final long serialVersionUID = 8884535893457453365L;
	
	
	@Inject 
	private INewService newService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws SecurityException, IOException, ServletException {
		
		// phuong thuc get thong thuong
//		NewModel model = new NewModel();
//		String pageStr = request.getParameter("page");
//		String maxPageItem = request.getParameter("maxPageItem");
//		System.out.println("pageStr:"+pageStr);
//		System.out.println("maxPageItem:"+maxPageItem);
//		if (pageStr != null) {
//			
//			model.setPage(Integer.parseInt(pageStr));
//		} else {
//			model.setPage(1);
//		}
//		if (maxPageItem != null) {
//			model.setMaxPageItem(Integer.parseInt(maxPageItem));
//		}
		
		// cai tien bang BeanUtils
		NewModel model = FormUtil.toModel(NewModel.class, request);
		
		// totalpage = totalitem/ maxpageitem
		System.out.println("model.getPage"+model.getPage());
		Integer offset = (model.getPage() - 1) * model.getMaxPageItem();
		System.out.println("offset:"+offset);
		model.setListResult(newService.findAll(offset, 	model.getMaxPageItem()));
		
		model.setTotalItem(newService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
		
		request.setAttribute(SystemConstant.MODEL, model);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/new/list.jsp");
		rd.forward(request, response);
	}
}
