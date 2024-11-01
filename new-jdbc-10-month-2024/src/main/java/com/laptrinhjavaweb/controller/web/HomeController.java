package com.laptrinhjavaweb.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewService;


@WebServlet(urlPatterns = { "/trang-chu" })
public class HomeController extends HttpServlet{

	@Inject
	private ICategoryService categoryService;
	@Inject
	private INewService newService;
	
	private static final long serialVersionUID = 2686801510274002166L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws SecurityException, IOException, ServletException {
		
		// phan 1 chuyen data thon thuong
		UserModel test = new UserModel();
		test.setFullName("truong dep trai");
		request.setAttribute("ca", test);
//		/views/admin/home.jsp
		
		
		// thuc hanh voi lop categories
//		String code = "the-thao";
//		request.setAttribute("categories", categoryService.findAll());
		// thuc hanh voi lop newdao
		
		// truyen du lieu 
//		Long categoryId = 1L;
//		request.setAttribute("news", newService.findByCategory(categoryId));
		
		
		// test save
//		String title = "bai viet xx";
//		String content = "bai viet xx";
//		Long categoryId = 1L;
//		NewModel truongitt = new NewModel();
//		truongitt.setTitle(title);
//		truongitt.setContent(content);
//		truongitt.setCategoryId(categoryId);
//		request.setAttribute("news", newService.save(truongitt));

		
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws SecurityException, IOException {
		
	}
}
