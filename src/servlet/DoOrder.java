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
		
		BookOrder bookorderbean=new BookOrder();	//��������ʵ�������	
		request.setCharacterEncoding("utf-8");// ������������		
		HttpSession session = request.getSession();// ��ȡsession
		//��ȡ����ı����ݣ���װ����ʵ�������
		bookorderbean.setUsername(request.getParameter("username"));
		bookorderbean.setZipcode(request.getParameter("zipcode"));
		bookorderbean.setPhone(request.getParameter("phone"));
		bookorderbean.setCreditcard(request.getParameter("creditcard"));
		bookorderbean.setTotal(((Double)session.getAttribute("total")).doubleValue());
		session.setAttribute("order",bookorderbean);//����������Ϣ������session�У���bye.jspʹ��
		OrderOperation op = new OrderOperation(); //�������涩���Ĳ��������
		op.saveOrder(bookorderbean); //��������Ϣ���浽���ݿ�
		request.getRequestDispatcher("bye.jsp").forward(request,response); //ת��ʾ������Ϣҳ��
	}
	public void init() throws ServletException {
	}
}
