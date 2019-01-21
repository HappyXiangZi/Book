package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.TitleDao;
import bean.TitleDaoImpl;
import bean.TraceLogger;
@WebServlet("/DoDeleteTitle")
public class DoDeleteTitle extends HttpServlet {
	public DoDeleteTitle() {
		super();
	}
	public void destroy() {
		super.destroy(); 
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		String isbn=request.getParameter("isbn");
		TitleDao titleDao=new TitleDaoImpl();
		int n=titleDao.delete(isbn);
		
		if(n>0) {
			response.sendRedirect("listBook.jsp");
			TraceLogger.info("删除图书成功");
		}
		else {
			response.sendRedirect("error.jsp");
			TraceLogger.info("删除图书失败");
		}
	}

	public void init() throws ServletException {
	}
}
