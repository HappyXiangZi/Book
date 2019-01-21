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
		List list=dao.getTitles();  //得到图书列表
		int pageSize=pageResult.getPageSize();//每页显示的记录数
		int pageNo;  //当前页号
		if(request.getParameter("pageResult.pageNo")!=null){
		 pageNo=Integer.parseInt(request.getParameter("pageResult.pageNo")); //从请求中获取当前页号
		}
		else
			pageNo=pageResult.getPageNo();  //采用缺省的页号
		if(request.getParameter("pageResult.pageSize")!=null)
			pageSize=Integer.parseInt(request.getParameter("pageResult.pageSize")); //获取请求中每页显示记录数
		int len=list.size();
		len=len>(pageNo)*pageSize?(pageNo)*pageSize:len; //显示到当前页时的记录数
		List list1=list.subList((pageNo-1)*pageSize,len);  //将第pageNo页的数据从list中复制到list1数组中
		//将要显示的当前页的数据，当前页数，总记录数保存在pageResult对象中
		pageResult.setList(list1);
		pageResult.setPageNo(pageNo);
		pageResult.setRecTotal(list.size());
		pageResult.setPageSize(pageSize);
		request.setAttribute("pageResult",pageResult);//将pageResult对象保存在request中
		request.getRequestDispatcher("/test/viewBookByPageTag.jsp").forward(request,response); //转发到ch18目录中viewBook.jsp页面
	}
	public void init() throws ServletException {
	}
}
