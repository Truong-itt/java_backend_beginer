package com.laptrinhjavaweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.utils.SessionUtil;
import com.laptrinhjavaweb.constant.SystemConstant;
public class AuthorizationFilter implements Filter {
	private ServletContext context;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
	        throws IOException, ServletException {
	    HttpServletRequest request = (HttpServletRequest) servletRequest;
	    HttpServletResponse response = (HttpServletResponse) servletResponse;

	    // Lấy URL bỏ qua phần Context Path
	    String url = request.getRequestURI().substring(request.getContextPath().length());
	    System.out.println("URL after removing context path: " + url);

	    // Kiểm tra nếu đường dẫn bắt đầu với "/admin"
	    if (url.startsWith("/admin")) {
	        System.out.println("tien hanh kiem tra");
	        UserModel model = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");

	        if (model != null) {
	            if (model.getRole().getCode().equals(SystemConstant.ADMIN)) {
	                filterChain.doFilter(servletRequest, servletResponse);
	            } else if (model.getRole().getCode().equals(SystemConstant.USER)) {
	                response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=not_permission&alert=danger");
	            }
	        } else {
	            response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=not_login&alert=danger");
	        }
	    } else {
	        System.out.println("thong tin dang nhap");
	        filterChain.doFilter(servletRequest, servletResponse);
	    }
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
