package kr.ac.mjc.chanyoung.myapp.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
public class HelloWorld extends HttpServlet {
	
	public HelloWorld() { //Constructor
		System.out.println("HelloWorld 인스턴스가 생성되었습니다.");
	}

	@Override
	public void init() throws ServletException {	//init
		System.out.println("HelloWorld가 초기화되었습니다. ");
	}
	@Override	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		System.out.println("HelloWorld의 doGet()  메소드를 실행합니다."
				+Thread.currentThread().getName());
		response.setContentType("text/html");		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello World!</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello World!</h1>");
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	public void destroy() {
		System.out.println("HelloWorld를 종료합니다.");
	}
}
