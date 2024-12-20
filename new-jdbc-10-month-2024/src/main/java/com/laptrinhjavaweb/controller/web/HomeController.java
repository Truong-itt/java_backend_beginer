package com.laptrinhjavaweb.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

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
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.utils.FormUtil;
import com.laptrinhjavaweb.utils.SessionUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap" ,"/thoat"})
public class HomeController extends HttpServlet {

	@Inject
	private ICategoryService categoryService;
	@Inject
	private INewService newService;
	@Inject
	private IUserService userService;
	private static final long serialVersionUID = 2686801510274002166L;
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws SecurityException, IOException, ServletException {
		// lay hanh dong thuc hien
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			// lay key
			
			System.out.println("xin chao ---");
			String message = request.getParameter("message");
			String alert = request.getParameter("alert");
			System.out.println(message);
			System.out.println(alert);
			if (message != null && alert != null) {
				request.setAttribute("message", resourceBundle.getString(message));
				request.setAttribute("alert", alert);
			}
			System.out.println(action);
			RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
			rd.forward(request, response);
		}
		else if (action != null && action.equals("logout")){
			SessionUtil.getInstance().removeValue(request, "USERMODEL");
			// khong chuyen den ma la dang di den	
			response.sendRedirect(request.getContextPath() + "/trang-chu");
		}
		else {
			// phan 1 chuyen data thon thuong
			UserModel test = new UserModel();
			test.setFullName("truong dep trai");
			request.setAttribute("ca", test);
//			/views/admin/home.jsp

			// thuc hanh voi lop categories
//			String code = "the-thao";
//			request.setAttribute("categories", categoryService.findAll());
			// thuc hanh voi lop newdao

			// truyen du lieu
//			Long categoryId = 1L;
//			request.setAttribute("news", newService.findByCategory(categoryId));

			// test save
//			String title = "bai viet xx";
//			String content = "bai viet xx";
//			Long categoryId = 1L;
//			NewModel truongitt = new NewModel();
//			truongitt.setTitle(title);
//			truongitt.setContent(content);
//			truongitt.setCategoryId(categoryId);
//			request.setAttribute("news", newService.save(truongitt));

			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws SecurityException, IOException {
		System.out.println("xin chao moi nguoi");
		String action = request.getParameter("action");
		System.out.println(action);
		if (action != null && action.equals("login")) {
			System.out.println("dang login");	
			UserModel model = FormUtil.toModel(UserModel.class, request);
			System.out.println(model.toString());
			System.out.println(model.getUserName());
			System.out.println(model.getPassWord());
			System.out.println(model.getStatus());
			
			
			model = userService.findByUserNameAndPasswordAndStatus(model.getUserName(), model.getPassWord(), 1);
			if (model != null) {
				SessionUtil.getInstance().putValue(request, "USERMODEL", model);
				if (model.getRole().getCode().equals("USER")){	
					System.out.println("dang nhap voi dang user");		
					response.sendRedirect(request.getContextPath() + "/trang-chu");
				}
				else if (model.getRole().getCode().equals("ADMIN")) {
					System.out.println("dang nhap voi dang admin ");
					response.sendRedirect(request.getContextPath() + "/admin-home");
				}
			}
			else {
				System.out.println("dang nhap sai pass");
				response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=username_password_invalid&alert=danger");					
			}
		}
	}
}
