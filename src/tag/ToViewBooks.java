package tag;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.TitleDao;
import bean.TitleDaoImpl;
@WebServlet("/ToViewBooks")
public class ToViewBooks extends HttpServlet {
	public ToViewBooks() {
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
		PageResult pageResult=new PageResult();  
		TitleDao dao=new TitleDaoImpl();
		List list=dao.getTitles();  //�õ�ͼ���б�
		int pageSize=pageResult.getPageSize();//ÿҳ��ʾ�ļ�¼��
		int pageNo;  //��ǰҳ��
		if(request.getParameter("pageResult.pageNo")!=null){
		 pageNo=Integer.parseInt(request.getParameter("pageResult.pageNo")); //�������л�ȡ��ǰҳ��
		}
		else
			pageNo=pageResult.getPageNo();  //����ȱʡ��ҳ��
		if(request.getParameter("pageResult.pageSize")!=null)
			pageSize=Integer.parseInt(request.getParameter("pageResult.pageSize")); //��ȡ������ÿҳ��ʾ��¼��
		int len=list.size();
		len=len>(pageNo)*pageSize?(pageNo)*pageSize:len; //��ʾ����ǰҳʱ�ļ�¼��
		List list1=list.subList((pageNo-1)*pageSize,len);  //����pageNoҳ�����ݴ�list�и��Ƶ�list1������
		//��Ҫ��ʾ�ĵ�ǰҳ�����ݣ���ǰҳ�����ܼ�¼��������pageResult������
		pageResult.setList(list1);
		pageResult.setPageNo(pageNo);
		pageResult.setRecTotal(list.size());
		pageResult.setPageSize(pageSize);
		request.setAttribute("pageResult",pageResult);//��pageResult���󱣴���request��
		request.getRequestDispatcher("/test/viewBookByPageTag.jsp").forward(request,response); //ת����ch18Ŀ¼��viewBook.jspҳ��
	}
	public void init() throws ServletException {
	}
}
