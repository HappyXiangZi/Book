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

		// 如果session不存在，，转到浏览图书（“viewBook.jsp”）页面
		if (session == null) {
			dispatcher = request.getRequestDispatcher("/viewBook.jsp");
			dispatcher.forward(request, response);
		}

		//  从session中取出购物车（"cart"），和要添加的书籍对象（"titles"）
		Map cart = (Map) session.getAttribute("cart");
		Title titles = (Title) session.getAttribute("titles");

		// 如果购物车不存在，创建购物车
		if (cart == null) {
			cart = new HashMap();

			// 将购物车存入session之中
			session.setAttribute("cart", cart);
		}
		//  从购物车对象（“cart”）中根据图书书号取出相应的图书项对象
		CartItem cartItem = (CartItem) cart.get(titles.getIsbn());
		if (cartItem != null) // 如果购物车中已有图书项对象，则更新其选购数量.
			cartItem.setQuantity(cartItem.getQuantity() + 1);
		else{		// 否则，创建一个图书项对象条目到购物车（Map cart）中.
			CartItem cartItem1=new CartItem();
			cartItem1.setTitles(titles);
			cartItem1.setQuantity(1);
			cart.put(titles.getIsbn(), cartItem1);
		}			

		//成功添加到购物车后，转向viewCart.jsp显示购物车
		dispatcher = request.getRequestDispatcher("/viewCart.jsp");
		dispatcher.forward(request, response);
		

	}

public void init() throws ServletException {
		}

}
