package com.sse.home.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

//	파일에서 전체 학생 리스트 가져오기
	public List<StudentDTO> makeList() throws Exception {
		File file = new File("C:\\study", "student.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<StudentDTO> star = new ArrayList<StudentDTO>();

		while (true) {

			String line = br.readLine();

			if (line != null) {
				String[] ar = line.split(",");

				StudentDTO st = new StudentDTO();

				st.setNum(Integer.parseInt(ar[0].trim()));
				st.setName(ar[1].trim());
				st.setKor(Integer.parseInt(ar[2].trim()));
				st.setEng(Integer.parseInt(ar[3].trim()));
				st.setMath(Integer.parseInt(ar[4].trim()));
				st.setTotal(Integer.parseInt(ar[5].trim()));
				st.setAvg(Double.parseDouble(ar[6].trim()));

				star.add(st);
			} else {
				break;
			}
		}
		return star;
	}

//	번호를 비교해서 번호가 같으면 그 학생 리스트 가져오기
	public StudentDTO onelist(StudentDTO student) throws Exception {
		List<StudentDTO> ar = this.makeList();
		StudentDTO one = null;

		for (StudentDTO a : ar) {
			if (a.getNum() == student.getNum()) {
				one = a;
				break;
			}

		}

		return one;
	}

}
