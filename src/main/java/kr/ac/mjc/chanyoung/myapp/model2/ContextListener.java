package kr.ac.mjc.chanyoung.myapp.model2;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import kr.ac.mjc.chanyoung.myapp.student.dao.StudentDao;

public class ContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		System.out.println(context.getContextPath() + " 애플리케이션을 시작합니다..");
		StudentDao studentDao = new StudentDao();
		// 애플리케이션 영역에 studentDao를 저장한다.
		context.setAttribute("studentDao", studentDao);
		System.out.println("studentDao를 애플리케이션 컨텍스트 영역에 넣었습니다.");
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		context.removeAttribute("studentDao");
		System.out.println("studentDao를 애플리케이션 컨텍스트 영역에서 제거했습니다.");
		System.out.println(context.getContextPath() + " 애플리케이션을 종료합니다.");
	}
}
