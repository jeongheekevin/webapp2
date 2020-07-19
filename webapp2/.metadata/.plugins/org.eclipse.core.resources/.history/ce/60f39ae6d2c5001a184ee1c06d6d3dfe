package tomcatTest;

import java.io.IOException;
import java.io.PrintWriter;

public class HellowServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	

	public void init() throws ServletException {

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 응답 content type설정
		response.setContentType("text/html");

		// 내용 출력
		PrintWriter out = response.getWriter();
		out.println("
Hello World!!!!
");
	}

	public void destroy() {

	}

}