package com.sse.home.student;

import java.util.List;

public class StudentService {

	private StudentDAO stdao;

	public StudentService() {
		stdao = new StudentDAO();
	}

	public List<StudentDTO> getStudents() {

		List<StudentDTO> ar = null;

		try {
			ar = stdao.makeList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;

	}

	public StudentDTO getone(StudentDTO student) {

		try {
			student = stdao.onelist(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			student = null;
		}
		return student;
	}

}
