package tomcatTest;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;



public class EmbedTomcat {

	public static void main(String[] args) throws Exception {

		Tomcat tomcat = new Tomcat();

		tomcat.setPort(8782);
		Connector connector = tomcat.getConnector();
		// 인코딩을 UTF-8로 설정
		connector.setURIEncoding("UTF-8");
		
		File docBase = new File(System.getProperty("java.io.tmpdir"));
		Context ctxt = tomcat.addContext("", docBase.getAbsolutePath());
		
		// 서블릿 추가
		Tomcat.addServlet(ctxt, "hellowServlet", new HellowServlet());
		ctxt.addServletMapping("/hellow", "hellowServlet");

		tomcat.start();
		tomcat.getServer().await();
	}
}