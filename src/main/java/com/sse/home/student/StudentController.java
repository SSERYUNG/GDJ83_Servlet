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
//			번호, 이름, 평균만 출력하게 하기
			List<StudentDTO> stlist = studentService.getStudents();
			request.setAttribute("list", stlist);
			action.setPath("/WEB-INF/views/student/list.jsp");

		} else if (ar[2].equals("add")) {

			if (method.toUpperCase().equals("POST")) {
				System.out.println("학생 등록 데이터가 올것");

				StudentDTO student = new StudentDTO();

				String name = request.getParameter("name");
				int a = Integer.parseInt(request.getParameter("kor"));
				int b = Integer.parseInt(request.getParameter("eng"));
				int c = Integer.parseInt(request.getParameter("math"));
				int d = a + b + c;
				double e = d / 3;

				student.setName(name);
				student.setKor(a);
				student.setEng(b);
				student.setMath(c);
				student.setTotal(d);
				student.setAvg(e);

				studentService.stadd(student);

				action.setFlag(false);
				action.setPath("./list");

			} else {

				action.setPath("/WEB-INF/views/student/add.jsp");
			}

		} else if (ar[2].equals("delete")) {

			int num = Integer.parseInt(request.getParameter("number"));
			StudentDTO one = new StudentDTO();
			one.setNum(num);
			studentService.stremove(one);

			action.setFlag(false);
			action.setPath("./list");

		} else if (ar[2].equals("detail")) {

			String number = request.getParameter("num");
			StudentDTO st = new StudentDTO();
			st.setNum(Integer.parseInt(number));
			st = studentService.getone(st);

			if (st != null) {

				request.setAttribute("one", st);
				action.setPath("/WEB-INF/views/student/detail.jsp");
			} else {

				request.setAttribute("message", "정보가 없습니다");
				action.setPath("/WEB-INF/views/commons/message.jsp");
			}
		} else if (ar[2].equals("update")) {

			if (method.toUpperCase().equals("POST")) {
				int num = Integer.parseInt(request.getParameter("num"));
				String name = request.getParameter("name");
				int kor = Integer.parseInt(request.getParameter("kor"));
				int eng = Integer.parseInt(request.getParameter("eng"));
				int math = Integer.parseInt(request.getParameter("math"));
				int total = kor + eng + math;
				double avg = total / 3;

				StudentDTO studentDTO = new StudentDTO();

				studentDTO.setNum(num);
				studentDTO.setName(name);
				studentDTO.setKor(kor);
				studentDTO.setEng(eng);
				studentDTO.setMath(math);
				studentDTO.setTotal(total);
				studentDTO.setAvg(avg);

				studentService.revise(studentDTO);

				action.setFlag(false);
				action.setPath("./list");

			} else {

				int i = Integer.parseInt(request.getParameter("number"));
				StudentDTO one = new StudentDTO();
				one.setNum(i);
				StudentDTO student = studentService.getone(one);

				request.setAttribute("st", student);

				System.out.println(student.getName());
				action.setPath("/WEB-INF/views/student/update.jsp");
			}

		}

		else {

		}

		return action;
	}
}
