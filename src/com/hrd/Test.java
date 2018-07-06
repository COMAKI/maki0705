package com.hrd;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.vo.Hrd;

public class Test {

	public static void main(String[] args) throws IOException {
		HrdBiz<Hrd, String> biz =
				new HrdBiz<>();
		StringBuilder sBuffer = new StringBuilder();
		String token = "E8jnarAHnqQyN21mUParp5SRITSDPUSS";
		int pageNum = 1;
		
		String url = "http://www.hrd.go.kr/jsp/HRDP/HRDPO00/HRDPOA40/HRDPOA40_1.jsp?authKey="
					+ token
					+"&returnType=XML&outType=1&"
					+"pageNum="+pageNum+"&pageSize=100&"
					+"srchTraStDt=20150101&srchTraEndDt=20150631&sort=ASC&sortCol=TR_NM_i";
		
		System.out.println("url: "+url);
	      // create a new DocumentBuilderFactory
	      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

	      try {
	         // use the factory to create a documentbuilder
	         DocumentBuilder builder = factory.newDocumentBuilder();

	         URL reurl = new URL(url);
	         InputStream fis = reurl.openStream();
	         // create a new document from input source
//	         FileInputStream fis = new FileInputStream(url);
	         InputSource is = new InputSource(fis);
	        

	         InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
	         BufferedReader br = new BufferedReader(isr);
	         String line;
	         while((line = br.readLine()) != null)
	         {	        	 
	             sBuffer.append(line);
	         }
	         
	         String xml = sBuffer.toString();
	         InputStream isds = new ByteArrayInputStream(xml.getBytes());

	         Document doc = builder.parse(is);
	         br.close();

	         

	         // get the first element
	         
        	 Element element = doc.getDocumentElement();

	         // get all child nodes
	         NodeList nodes = element.getChildNodes();

	         doc.getDocumentElement().normalize();
	         System.out.println("Root element: " + doc.getDocumentElement().getNodeName()); // Root element: result
	 		
	         NodeList nList = doc.getElementsByTagName("scn_list");
	         System.out.println("파싱할 리스트 수 : "+ nList.getLength());
	         // print the text content of each child
	         for (int i = 0; i < nodes.getLength(); i++) {
	            System.out.println("" + nodes.item(i).getTextContent());
	         }
	         
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      }
		// root tag 
		

		
	}

	public static void showList() {
		HrdBiz<Hrd, String> biz =
				new HrdBiz<>();
		ArrayList<Hrd> list = null; 
		try {
			list = biz.get();
			for(Hrd u : list) {
				System.out.println(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}






