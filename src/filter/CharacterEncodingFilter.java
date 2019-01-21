package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharacterEncodingFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+"/";
		String url = req.getRequestURL().toString();
		String str = (String) req.getSession().getAttribute("userName");
		
		if (str != null  //如果已登录或请求的是登录相关资源，则放行，否则，转登录页面
				|| url.equals(basePath+"index.jsp")
				|| url.equals(basePath+"images/top.jpg")
				|| url.equals(basePath+"checkUser.jsp")
				|| url.equals(basePath+"ImageServlet")) { 
			chain.doFilter(request, response);

		} else {
				res.sendRedirect("index.jsp");
		}			
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
