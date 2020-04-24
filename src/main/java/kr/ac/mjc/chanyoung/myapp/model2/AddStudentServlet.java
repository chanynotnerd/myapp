package kr.ac.mjc.chanyoung.myapp.model2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.mjc.chanyoung.myapp.student.dao.Student;
import kr.ac.mjc.chanyoung.myapp.student.dao.StudentDao;

@WebServlet("/student/model2/addStudent")
public class AddStudentServlet extends HttpServlet {

	StudentDao studentDao = null;

	@Override
	public void init() throws ServletException {
		studentDao = (StudentDao) getServletContext()
				.getAttribute("studentDao");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String dept = request.getParameter("dept");

		Student student = new Student(null, name, dept);
		studentDao.addStudent(student);
		response.sendRedirect(
				request.getContextPath() + "/student/model2/studentList");
	}
}
