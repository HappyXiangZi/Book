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
import bean.Title;
@WebServlet("/DoAddTitle")
public class DoAddTitle extends HttpServlet {
	public DoAddTitle() {
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
		//��ҳ���ȡ�ı�������
		String isbn=request.getParameter("isbn");  //Isbn��
		String booktitle=request.getParameter("title");  //����
		//booktitle=new String(booktitle.getBytes("ISO-8859-1"),"GBK");
		String copyright=request.getParameter("copyright");  //��Ȩ
		String imageFile=request.getParameter("imageFile");  //����ͼ���ļ�����
		int editionNumber=Integer.parseInt(request.getParameter("editionNumber"));  //�汾��
		int publisherId=Integer.parseInt(request.getParameter("publisherId")); //������ID
		float price=Float.parseFloat(request.getParameter("price")); //�۸�
		//���������ӽ���װ����
		Title titlebean=new Title();
		titlebean.setIsbn(isbn);
		titlebean.setCopyright(copyright);
		titlebean.setEditionNumber(editionNumber);
		//title.setImageFile(imageFile);
		titlebean.setImageFile(isbn+".jpg");
		titlebean.setPrice(price);
		titlebean.setPublisherId(publisherId);
		titlebean.setTitle(booktitle);
		//�������ݿ������ִ�в������
		TitleDao titleDao=new TitleDaoImpl();
		int n=titleDao.add(titlebean);
		if(n>0) {
			response.sendRedirect("listBook.jsp");
			TraceLogger.info("����ͼ��ɹ�");
		}
		else {
			response.sendRedirect("error.jsp");
			TraceLogger.info("����ͼ��ʧ��");
		}
	}

	public void init() throws ServletException {
	}
}