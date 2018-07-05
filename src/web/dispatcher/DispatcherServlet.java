package web.dispatcher;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.ProductBiz;
import com.vo.Product;

@WebServlet({ "/DispatcherServlet", "/dispatcher" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ProductBiz<Product,Integer> productbiz = new ProductBiz<>();
	
    public DispatcherServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));

		path = path.substring(1, path.lastIndexOf("."));
		String next = "main.jsp";
		if(path.equals("main")){
			String view = request.getParameter("view");
			if(view == null){
				view = "center_all";
			}
			build(request, view);
			next = "main.jsp";
		}else{
			next = path;
		}
		
		System.out.println(next);
		RequestDispatcher rd = 
		request.getRequestDispatcher(next);
		rd.forward(request, response);
	}
	
	
	// make ui
	private void build(HttpServletRequest request,
			String view){
		if(view.equals("center_all")) {
			request.setAttribute("center", "/inner/center_all");
			request.setAttribute("nav", Navi.login);
		}else if(view.equals("product_table")) {
			List list = null;
			try {
				list = productbiz.get();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("plist", list);
			request.setAttribute("center", "/inner/center_product_table");
			request.setAttribute("nav", Navi.login);
		}else if(view.equals("product_detail")) {
			int id = Integer.parseInt(request.getParameter("product_id"));
			Product p = null;
			try {
				p = productbiz.get(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("detailp", p);
			request.setAttribute("center", "/inner/center_product_detail");
			request.setAttribute("nav", Navi.login);
		}else if(view.equals("register")) {
			request.setAttribute("center", "/inner/center_register");
			request.setAttribute("nav", Navi.register);
		}else if(view.equals("login")) {
			request.setAttribute("center", "/inner/center_login");
			request.setAttribute("nav", Navi.about);
		}else if(view.equals("useradd")) {
			request.setAttribute("center", "user/add");
			request.setAttribute("nav", Navi.useradd);
		}else if(view.equals("productupdate")) {
			try {	
				Product product = productbiz.get(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("detailp",product);
				request.setAttribute("center", "/inner/center_productupdate");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				request.setAttribute("center","/inner/center_somethingwrong");		
				e.printStackTrace();
			}
		}else{
			request.setAttribute("center", "/inner/center_"+view);
		}
		
	}

	
	

}




