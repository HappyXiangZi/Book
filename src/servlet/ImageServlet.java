package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.imageio.*;
/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		int width=78;
		int height=20;
		//��������
		BufferedImage bim=new BufferedImage(68,20,BufferedImage.TYPE_INT_RGB);
		//��ȡͼƬ����
		Graphics g=bim.getGraphics();
		Random rm=new Random();
		g.setColor(new Color(rm.nextInt(150),200,rm.nextInt(150)));
		g.fillRect(0, 0, width, height);		
		StringBuffer sbf=new StringBuffer("");
		//�������
		for(int i=0;i<4;i++){
			g.setColor(Color.black);
		    g.setFont(new Font("��������",Font.BOLD|Font.ITALIC,22));
			int n=rm.nextInt(10);
			sbf.append(n);
		    g.drawString(""+n, i*15+5, 18);
		}
		//���ɵ���֤�뱣�浽session��
		HttpSession session=request.getSession(true);
		session.setAttribute("piccode", sbf);
	    //��ֹ����
		response.setHeader("Prama","no-cache");
		response.setHeader("Coche-Control","no-cache");
		response.setDateHeader("Expires",0);
		response.setContentType("image/jpeg");
		//���ͼƬ
		ImageIO.write(bim, "JPG", response.getOutputStream());
		response.getOutputStream().close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
