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
//		String realpath = request.getRealPath("images"); //ͼ�����ͼ�񱣴���WebRoot�µ�"images"�ļ�����
		String realpath = request.getSession().getServletContext().getRealPath("images"); 
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";	
		System.out.println("path="+path);
		System.out.println("request.getRealPath('images')="+realpath);
		System.out.println("basePath="+basePath);
		System.out.println("isbn="+isbn);
	    DiskFileUpload fu = new DiskFileUpload();	
	    fu.setSizeMax(1024*1024); // ���������û��ϴ��ļ���С,��λ:�ֽ�
        fu.setRepositoryPath(realpath);	    
	     //����request�����д�������д��������ϴ��ķ���ͼ���ļ���������������������浽"\images"�ļ�����
	     try{
	    	List fileItems = fu.parseRequest(request);
	    	Iterator iter = fileItems.iterator();
	    	while (iter.hasNext()) // ���δ���ÿ���ϴ����ļ�
		    {
		      FileItem item = (FileItem) iter.next();		      
		      if (!item.isFormField())  //�������������ļ�������б���Ϣ
		      {
		        //����Ϊ�ļ��������ϴ���ͼ������ļ����������ͬ��������/images�ļ����¡�		        
		        File savedFile = new File(realpath, isbn+".jpg");
		        item.write(savedFile);
		      }
		    } 
	    	TraceLogger.info("�ϴ��ļ��ɹ�");
	     }
	     catch(Exception e){}
	     response.sendRedirect("uploadfile_show.jsp?isbn="+isbn);
	  }

	public void init() throws ServletException {
	}
}
