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
	import com.laptrinhjavaweb.model.CategoryModel;
	import com.laptrinhjavaweb.model.NewModel;
	import com.laptrinhjavaweb.pagging.PageRequest;
	import com.laptrinhjavaweb.pagging.Pageble;
	import com.laptrinhjavaweb.service.ICategoryService;
	import com.laptrinhjavaweb.service.INewService;
	import com.laptrinhjavaweb.service.impl.CategoryService;
	import com.laptrinhjavaweb.sort.Sorter;
	import com.laptrinhjavaweb.utils.FormUtil;
	import com.laptrinhjavaweb.utils.MessageUtil;
	
	@WebServlet(urlPatterns = { "/admin-new" })
	public class NewController extends HttpServlet {
	
		private static final long serialVersionUID = 8884535893457453365L;
	
		@Inject
		private INewService newService;
	
		@Inject
		private ICategoryService categoryService;
	
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
			System.out.println("thong tin request:" + request.toString());
			NewModel model = FormUtil.toModel(NewModel.class, request);
			String view = "";
			System.out.println(SystemConstant.LIST);
			
			System.out.println(model.getType());
			if (model.getType().equals(SystemConstant.LIST)) {
				Integer offset = (model.getPage() - 1) * model.getMaxPageItem();
				System.out.println("offset:" + offset);
				System.out.println("getMaxPageItem " + model.getMaxPageItem());
				System.out.println("SortName " + model.getSortName());
				System.out.println("SortBy " + model.getSortBy());
				Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
						new Sorter(model.getSortName(), model.getSortBy()));
				model.setListResult(newService.findAll(pageble));
	
				model.setTotalItem(newService.getTotalItem());
				model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
				
				request.setAttribute(SystemConstant.MODEL, model);
				view = "/views/admin/new/list.jsp";
			} else if (model.getType().equals(SystemConstant.EDIT)) {
				if (model.getId() != null) {
					model = newService.findOne(model.getId());
				}	
				request.setAttribute("categories",  categoryService.findAll());
				view = "/views/admin/new/edit.jsp";
			}
			
			MessageUtil.showMessage(request);
			request.setAttribute(SystemConstant.MODEL, model);
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
	
			
			
			
			
	//		Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
	//				new Sorter(model.getSortName(), model.getSortBy()));
	//		model.setListResult(newService.findAll(pageble));
	//
	//		model.setTotalItem(newService.getTotalItem());
	//		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
	//
	//		request.setAttribute(SystemConstant.MODEL, model);
	//
	//		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/new/list.jsp");
	//		rd.forward(request, response);
	
		}
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
	
		}
	}
