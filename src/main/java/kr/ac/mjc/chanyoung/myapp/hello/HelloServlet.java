package kr.ac.mjc.chanyoung.myapp.hello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* web.xml에서 metadata-complete="false"를 하면
 * @WebServlet annotation으로 매핑할 수 있다.
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");

		// request에 데이터를 싣는다.
		request.setAttribute("greeting", "Hello " + name);

		// forward to /WEB-INF/jsp/hello.jsp
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/hello.jsp")
				.forward(request, response);
	}
}
