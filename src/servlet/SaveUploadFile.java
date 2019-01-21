package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.io.*;
import org.apache.commons.fileupload.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.DBcon;
import bean.TraceLogger;
@WebServlet("/SaveUploadFile")
public class SaveUploadFile extends HttpServlet {
	public SaveUploadFile() {
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
		String isbn = request.getParameter("isbn");
		String path = request.getContextPath();
//		String realpath = request.getRealPath("images"); //图书封面图像保存在WebRoot下的"images"文件夹中
		String realpath = request.getSession().getServletContext().getRealPath("images"); 
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";	
		System.out.println("path="+path);
		System.out.println("request.getRealPath('images')="+realpath);
		System.out.println("basePath="+basePath);
		System.out.println("isbn="+isbn);
	    DiskFileUpload fu = new DiskFileUpload();	
	    fu.setSizeMax(1024*1024); // 设置允许用户上传文件大小,单位:字节
        fu.setRepositoryPath(realpath);	    
	     //接收request对象中从浏览器中传来的欲上传的封面图像文件，重新以书号命名，保存到"\images"文件夹中
	     try{
	    	List fileItems = fu.parseRequest(request);
	    	Iterator iter = fileItems.iterator();
	    	while (iter.hasNext()) // 依次处理每个上传的文件
		    {
		      FileItem item = (FileItem) iter.next();		      
		      if (!item.isFormField())  //忽略其他不是文件域的所有表单信息
		      {
		        //以下为文件名处理，上传的图书封面文件名与书号相同，保存在/images文件夹下。		        
		        File savedFile = new File(realpath, isbn+".jpg");
		        item.write(savedFile);
		      }
		    } 
	    	TraceLogger.info("上传文件成功");
	     }
	     catch(Exception e){}
	     response.sendRedirect("uploadfile_show.jsp?isbn="+isbn);
	  }

	public void init() throws ServletException {
	}
}
