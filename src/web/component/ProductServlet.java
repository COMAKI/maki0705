package web.component;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.product.ProductBiz;
import com.vo.Product;



/**
 * Servlet implementation class UserList
 */
@WebServlet({ "/Product", "/product" })
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductBiz<Product,Integer> biz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        biz = new ProductBiz<>();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd = request.getParameter("cmd");
		String next = "main.jsp";
		if(cmd.equals("add")) {
			
			String dir = "C:\\skagh-lee-web\\mvc1\\WebContent\\img";
			int size = 1024*1024*1024;

			MultipartRequest mreq = new MultipartRequest(request, dir,size , "EUC-KR");
			

			System.out.println("a81148"+mreq.getParameter("name") +mreq.getParameter("price") );
			
			String name = mreq.getParameter("name");
			int price = Integer.parseInt(mreq.getParameter("price"));
			String imgname = mreq.getOriginalFileName("imgname");
			
			
			Product p = new Product(name, price ,imgname);
			
			try {
				System.out.println("registering product");
				biz.register(p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect("main.mc?view=center_all");		
			
		}else if(cmd.equals("updatepage")) {
			
			try {	
				Product product = biz.get(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("it",product);
				RequestDispatcher rd = request.getRequestDispatcher("main.mc?view=prodetail");
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				response.sendRedirect("main.mc?view=registerfail");		
				e.printStackTrace();
			}
		}else if(cmd.equals("updateimpl")) {
			
			String dir = "C:\\skagh-lee-web\\mvc1\\WebContent\\img";
			int size = 1024*1024*1024;

			MultipartRequest mreq = new MultipartRequest(request, dir,size , "EUC-KR");
			
			String id = mreq.getParameter("id");
			String name = mreq.getParameter("name");
			String imgname = mreq.getOriginalFileName("imgname");
			
			Product p = new Product(Integer.parseInt(id),name, 12000 ,imgname);
			
			try {
				biz.modify(p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
	}

}
