package web.component;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class DataCenter
 */
@WebServlet({ "/DataCenter", "/dc" })
public class DataCenter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataCenter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		JSONArray ja = new JSONArray();
		JSONObject jo = new JSONObject();
		jo.put("data", 1rg);
		ja.add(jo);
		
		response.setContentType("text/json; charset=EUC-KR");
		PrintWriter writer = response.getWriter(); 
		writer.print(b);*/
	}

}
