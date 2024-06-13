package com.sse.home.experience;

import java.util.List;

import com.sse.home.student.StudentDAO;
import com.sse.home.student.StudentDTO;

public class Exmain {

	public static void main(String[] args) {

		StudentDAO dao = new StudentDAO();
		List<StudentDTO> ar = null;

		try {
			ar = dao.makeList();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ar.size());

		StudentDTO one = new StudentDTO();
		one.setNum(2);

		for (StudentDTO a : ar) {
			System.out.println(one);

			if (a.getNum() == one.getNum()) {
				one = a;
				break;
			} else {
				one = null;
			}

		}

		System.out.println(one.getName());

	}
}