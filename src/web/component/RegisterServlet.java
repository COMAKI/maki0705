package web.component;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.UserBiz;
import com.vo.User;

import web.dispatcher.Navi;
import web.dispatcher.Util;

@WebServlet({ "/RegisterServlet", "/register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserBiz<User,String> biz;
	
	public RegisterServlet() {
        super();
        biz = new UserBiz<>();
    }
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		System.out.println("register service received");
		name = Util.convertKr(name);
		try {
			biz.register(new User(id,pwd,name));
			request.setAttribute("name",name);
			RequestDispatcher rd = request.getRequestDispatcher("main.mc?view=registerok");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.sendRedirect("main.mc?view=somethingwrong");		
			e.printStackTrace();
		}
		
		
	}

}




