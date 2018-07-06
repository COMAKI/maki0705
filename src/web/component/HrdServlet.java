package web.component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.hrd.HrdBiz;
import com.vo.Hrd;

/**
 * Servlet implementation class HrdServlet
 */
@WebServlet({ "/HrdServlet", "/hrd" })
public class HrdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HrdBiz<Hrd, String> biz;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HrdServlet() {
		super();
		biz = new HrdBiz<Hrd, String>();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String next = "main.mc";
		String cmd = request.getParameter("cmd");
		String token = "E8jnarAHnqQyN21mUParp5SRITSDPUSS";
		int pageNum = 1;
		ServletContext context = getServletContext();
		URL resourceUrl = context.getResource("/WEB-INF/hrd1.xml");

		if (cmd.equals("add")) {
			request.setCharacterEncoding("utf-8");
	        response.setContentType("text/html; charset=utf-8");
	       
			while (true) {
				String addr = "http://www.hrd.go.kr/jsp/HRDP/HRDPO00/HRDPOA40/HRDPOA40_1.jsp?authKey=" + token
						+ "&returnType=XML&outType=1&" + "pageNum=" + pageNum + "&pageSize=100&"
						+ "srchTraStDt=20150101&srchTraEndDt=20150631&sort=ASC&sortCol=TR_NM_i";

				URL url = new URL(addr);
		         
				try {
//	            SAXParserFactory parserModel = SAXParserFactory.newInstance();
//	            SAXParser concreteParser   = parserModel.newSAXParser();
//	            XMLReader myReader    = concreteParser.getXMLReader();
//	            myReader.parse(new InputSource(url.openStream()));
	            DocumentBuilderFactory factory1 = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder2 = factory1.newDocumentBuilder();
//	            Document doc = builder2.parse(new InputSource(url.openStream()));
	            Document doc = builder2.parse(resourceUrl.toString());


		
				/*DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder;
				Document doc;
				try {
					dBuilder = dbFactoty.newDocumentBuilder();
					doc = dBuilder.parse(addr);*/
					// root tag
					doc.getDocumentElement().normalize();
					System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

					// 파싱할 tag
					NodeList nList = doc.getElementsByTagName("scn_list");
					// System.out.println("파싱할 리스트 수 : "+ nList.getLength());

					for (int temp = 0; temp < nList.getLength(); temp++) {
						Node nNode = nList.item(temp);
						if (nNode.getNodeType() == Node.ELEMENT_NODE) {

							Element eElement = (Element) nNode;
							String title = getTagValue("title", eElement);
							String titleIcon = getTagValue("titleIcon", eElement);
							String imgGubun = getTagValue("imgGubun", eElement);
							String subTitle = getTagValue("subTitle", eElement);
							String address = getTagValue("address", eElement);
							String telNo = getTagValue("telNo", eElement);
							String contents = getTagValue("contents", eElement);
							String superViser = getTagValue("superViser", eElement);
							String trainTarget = getTagValue("trainTarget", eElement);
							String yardMan = getTagValue("yardMan", eElement);
							String realMan = getTagValue("realMan", eElement);
							String courseMan = getTagValue("courseMan", eElement);
							String regCourseMan = getTagValue("regCourseMan", eElement);
							String traEndDate = getTagValue("traEndDate", eElement);
							String traStartDate = getTagValue("traStartDate", eElement);
							String grade = getTagValue("grade", eElement);
							String ncsCd = getTagValue("ncsCd", eElement);
							String instCd = getTagValue("instCd", eElement);
							String trprId = getTagValue("trprId", eElement);
							String trprDegr = getTagValue("trprDegr", eElement);
							System.out.println("######################");
							System.out.println(eElement.getTextContent());
							biz.register(new Hrd(title, titleIcon, imgGubun, subTitle, address, telNo, contents, superViser,
									trainTarget, yardMan, realMan, courseMan, regCourseMan, traEndDate, traStartDate, grade,
									ncsCd, instCd, trprId, trprDegr));
						} // for end
					} // if end
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pageNum++;
				if(pageNum>1) break;
			} // while end
		}
		if (cmd.equals("list")) {
			ArrayList<Hrd> list;
			try {
				list = biz.get();
				request.setAttribute("hrdlist", list);
				next += "?view=hrd_list";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("hrdlist", null);
				next += "?view=hrd_list";
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher(next);
		rd.forward(request, response);
	}

	private static String getTagValue(String tag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		if (nValue == null)
			return null;
		return nValue.getNodeValue();
	}
}
