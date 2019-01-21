package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.TitleDao;
import bean.TitleDaoImpl;
import bean.TraceLogger;
import bean.Title;

public class DoSaveEditTitle extends HttpServlet {

	public DoSaveEditTitle() {
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
		//从页面获取文本框数据
		String isbn=request.getParameter("isbn");  //Isbn号
		String title=request.getParameter("title");  //书名
		//title=new String(title.getBytes("ISO-8859-1"),"GBK");
		String copyright=request.getParameter("copyright");  //版权
		String imageFile=request.getParameter("imageFile");  //封面图像文件名称
		int editionNumber=Integer.parseInt(request.getParameter("editionNumber"));  //版本号
		int publisherId=Integer.parseInt(request.getParameter("publisherId")); //出版商ID
		float price=Float.parseFloat(request.getParameter("price")); //价格
		//将数据添加进封装类中
		Title titlebean=new Title();
		titlebean.setIsbn(isbn);
		titlebean.setCopyright(copyright);
		titlebean.setEditionNumber(editionNumber);
		titlebean.setImageFile(imageFile);
		titlebean.setPrice(price);
		titlebean.setPublisherId(publisherId);
		titlebean.setTitle(title);
		//调用数据库操作类执行更新操作
		TitleDao titleDao=new TitleDaoImpl();
		int n=titleDao.update(titlebean);
		if(n>0) {
			response.sendRedirect("listBook.jsp");
			TraceLogger.info("更新图书成功");
		}
		else {
			response.sendRedirect("error.jsp");	
			TraceLogger.info("更新图书失败");
		}
	}

	public void init() throws ServletException {
	}
}
