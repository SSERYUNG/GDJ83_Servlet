package com.sse.home.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentService {

	public List<Student> getStudents() {
		ArrayList<Student> ar = new ArrayList<Student>();
		Random random = new Random();

		for (int i = 0; i < 5; i++) {

			Student st = new Student();
			st.setNum(i + 1);
			st.setName("name" + i);
			st.setAvg(random.nextInt(100) + random.nextDouble());

			ar.add(st);
		}
		return ar;
	}

	public Student makeStudent() {

		Student student = new Student();
		student.setNum(1);
		student.setName("sse");
		student.setAvg(11.01);

		return student;
	}

}
