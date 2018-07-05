package web.dispatcher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.UserBiz;
import com.vo.User;

/**
 * Servlet implementation class LogInOut
 */
@WebServlet({ "/LogInOut", "/loginout" })
public class LogInOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserBiz<User,String> biz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInOut() {
        super();
        // TODO Auto-generated constructor stub
        biz = new UserBiz<>();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session!=null) {
			session.invalidate();
		}
		request.setAttribute("center", "/inner/center_login");
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pw = request.getParameter("pwd");
		
		String center = "/inner/center_all";
		
		User user = null;
		
		try {
			user = biz.get(id);
			System.out.println(user);
			if(true) {
				HttpSession session = request.getSession();
				session.setAttribute("loginid", id);
				
			}else {
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			center = "/inner/center_login";
			request.setAttribute("loginstate", "fail");
		}
		
		request.setAttribute("center", center);
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
		
	}

}
