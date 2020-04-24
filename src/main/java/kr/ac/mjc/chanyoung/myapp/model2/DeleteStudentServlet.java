package kr.ac.mjc.chanyoung.myapp.model2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.mjc.chanyoung.myapp.student.dao.StudentDao;

@WebServlet("/student/model2/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {

	StudentDao studentDao = null;

	@Override
	public void init() throws ServletException {
		studentDao = (StudentDao) getServletContext()
				.getAttribute("studentDao");
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		studentDao.deleteStudent(id);
		response.sendRedirect(
				request.getContextPath() + "/student/model2/studentList");
	}
}