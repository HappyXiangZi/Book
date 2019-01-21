package servlet;
import bean.*;
import java.util.*;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
@WebServlet("/AddTitlesToCart")
public class AddTitlesToCart extends HttpServlet {
	public AddTitlesToCart() {
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

		HttpSession session = request.getSession(false);
		RequestDispatcher dispatcher;

		// ���session�����ڣ���ת�����ͼ�飨��viewBook.jsp����ҳ��
		if (session == null) {
			dispatcher = request.getRequestDispatcher("/viewBook.jsp");
			dispatcher.forward(request, response);
		}

		//  ��session��ȡ�����ﳵ��"cart"������Ҫ��ӵ��鼮����"titles"��
		Map cart = (Map) session.getAttribute("cart");
		Title titles = (Title) session.getAttribute("titles");

		// ������ﳵ�����ڣ��������ﳵ
		if (cart == null) {
			cart = new HashMap();

			// �����ﳵ����session֮��
			session.setAttribute("cart", cart);
		}
		//  �ӹ��ﳵ���󣨡�cart�����и���ͼ�����ȡ����Ӧ��ͼ�������
		CartItem cartItem = (CartItem) cart.get(titles.getIsbn());
		if (cartItem != null) // ������ﳵ������ͼ��������������ѡ������.
			cartItem.setQuantity(cartItem.getQuantity() + 1);
		else{		// ���򣬴���һ��ͼ���������Ŀ�����ﳵ��Map cart����.
			CartItem cartItem1=new CartItem();
			cartItem1.setTitles(titles);
			cartItem1.setQuantity(1);
			cart.put(titles.getIsbn(), cartItem1);
		}			

		//�ɹ���ӵ����ﳵ��ת��viewCart.jsp��ʾ���ﳵ
		dispatcher = request.getRequestDispatcher("/viewCart.jsp");
		dispatcher.forward(request, response);
		

	}

public void init() throws ServletException {
		}

}
