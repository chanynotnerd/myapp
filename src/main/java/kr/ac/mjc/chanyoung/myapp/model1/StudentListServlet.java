package kr.ac.mjc.chanyoung.myapp.model1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.mjc.chanyoung.myapp.student.dao.Student;
import kr.ac.mjc.chanyoung.myapp.student.dao.StudentDao;

@WebServlet("/student/model1/studentList")
public class StudentListServlet extends HttpServlet {

	StudentDao studentDao = null;

	@Override
	public void init() throws ServletException {
		studentDao = new StudentDao();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Student> studentList = studentDao.listStudents();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>학생 목록</h3>");
		out.println("<ul>");
		for (Student student : studentList)
			out.format(
					"<li>학번: <a href='./studentInfo?id=%s'>%s</a>, 이름: %s, 학과: %s</li>\n",
					student.getId(), student.getId(), student.getName(),
					student.getDept());
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
