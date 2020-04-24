package kr.ac.mjc.chanyoung.myapp.model1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.mjc.chanyoung.myapp.student.dao.Student;
import kr.ac.mjc.chanyoung.myapp.student.dao.StudentDao;

@WebServlet("/student/model1/studentInfo")
public class StudentInfoServlet extends HttpServlet {

	StudentDao studentDao = null;

	@Override
	public void init() throws ServletException {
		studentDao = new StudentDao();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		Student student = studentDao.getStudent(id);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>학생 상세정보</h3>");
		out.format("<p>학번: %s</p>\n", student.getId());
		out.format("<p>이름: %s</p>\n", student.getName());
		out.format("<p>학과: %s</p>\n", student.getDept());
		out.format("<p><a href='studentList'>목록</a></p>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}