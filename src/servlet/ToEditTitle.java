package servlet;
import bean.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ToEditTitle")
public class ToEditTitle extends HttpServlet {
	public ToEditTitle() {
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
		Title title=titleDao.findByIsbn(isbn);
		request.setAttribute("title",title); //��ͼ����Ϣ������request������,ת�����༭ҳ��
		request.getRequestDispatcher("editTitle.jsp").forward(request, response);
			}

	public void init() throws ServletException {
	}

}