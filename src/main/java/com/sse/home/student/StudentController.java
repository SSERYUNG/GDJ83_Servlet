package com.sse.home.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sse.home.Action;

public class StudentController {

	private StudentService studentService;

	public StudentController() {
		this.studentService = new StudentService();

	}

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	public Action start(HttpServletRequest request) {

		String uri = request.getRequestURI();
		String[] ar = uri.split("/");
		String method = request.getMethod();

		Action action = new Action();
		action.setFlag(true);

		if (ar[2].equals("list")) {
			List<Student> stlist = studentService.getStudents();
			request.setAttribute("list", stlist);
			action.setPath("/WEB-INF/views/student/list.jsp");
		} else if (ar[2].equals("add")) {

			if (method.toUpperCase().equals("POST")) {
				System.out.println("학생 등록 데이터가 올것");
				Student student = new Student();

				String name = request.getParameter("name");
				int num = Integer.parseInt(request.getParameter("num"));
				double avg = Double.parseDouble(request.getParameter("avg"));

				System.out.println(num + name + avg);

				student.setNum(num);
				student.setName(name);
				student.setAvg(avg);

				action.setFlag(false);
				action.setPath("./list");

				System.out.println(request.getParameter("ch"));
				System.out.println(request.getParameter("mobile"));

				String[] var = request.getParameterValues("ch2");
				for (String s : var) {
					System.out.println(s);
				}

			} else {

				action.setPath("/WEB-INF/views/student/add.jsp");
			}

		} else if (ar[2].equals("delete")) {

		} else if (ar[2].equals("detail")) {

			Student student = this.studentService.makeStudent();
			request.setAttribute("s", student);

			action.setPath("/WEB-INF/views/student/detail.jsp");
		} else {

		}

		return action;
	}
}
