package servlet;

import java.io.IOException;
import bean.BookOrder;
import bean.OrderOperation;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/DoOrder")
public class DoOrder extends HttpServlet {

	public DoOrder() {
		super();
	}
	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		
		BookOrder bookorderbean=new BookOrder();	//创建订单实体类对象	
		request.setCharacterEncoding("utf-8");// 处理中文输入		
		HttpSession session = request.getSession();// 获取session
		//获取输入的表单数据，封装订单实体类对象
		bookorderbean.setUsername(request.getParameter("username"));
		bookorderbean.setZipcode(request.getParameter("zipcode"));
		bookorderbean.setPhone(request.getParameter("phone"));
		bookorderbean.setCreditcard(request.getParameter("creditcard"));
		bookorderbean.setTotal(((Double)session.getAttribute("total")).doubleValue());
		session.setAttribute("order",bookorderbean);//本条订单信息保存在session中，供bye.jsp使用
		OrderOperation op = new OrderOperation(); //创建保存订单的操作类对象
		op.saveOrder(bookorderbean); //将订单信息保存到数据库
		request.getRequestDispatcher("bye.jsp").forward(request,response); //转显示订单信息页面
	}
	public void init() throws ServletException {
	}
}
