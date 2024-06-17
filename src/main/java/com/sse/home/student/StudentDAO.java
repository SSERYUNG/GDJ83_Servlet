package com.sse.home.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.el.parser.AstIdentifier;

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

	public void addst(StudentDTO studentDTO) throws Exception {

		StringBuffer sb = new StringBuffer();
		List<StudentDTO> ar = this.makeList();

		int num = ar.size() + 1;
		studentDTO.setNum(num);

		sb.append(studentDTO.getNum());
		sb.append(",");
		sb.append(studentDTO.getName());
		sb.append(",");
		sb.append(studentDTO.getKor());
		sb.append(",");
		sb.append(studentDTO.getEng());
		sb.append(",");
		sb.append(studentDTO.getMath());
		sb.append(",");
		sb.append(studentDTO.getTotal());
		sb.append(",");
		sb.append(studentDTO.getAvg());

		String line = sb.toString();

		File file = new File("C:\\study", "student.txt");
		FileWriter fw = new FileWriter(file, true);
		fw.write(line + "\r\n");
		fw.flush();
		fw.close();

	}

	public void removest(StudentDTO studentDTO) throws Exception {

		List<StudentDTO> ar = this.makeList();

		for (int i = 0; i < ar.size(); i++) {
			if (ar.get(i).getNum() == studentDTO.getNum()) {
				ar.remove(i);
				break;
			}
		}

		for (int i = 0; i < ar.size(); i++) {
			ar.get(i).setNum(i + 1);
		}

		for (int i = 0; i < ar.size(); i++) {

			if (i == 0) {

				StringBuffer sb = new StringBuffer();
				sb.append(ar.get(i).getNum());
				sb.append(",");
				sb.append(ar.get(i).getName());
				sb.append(",");
				sb.append(ar.get(i).getKor());
				sb.append(",");
				sb.append(ar.get(i).getEng());
				sb.append(",");
				sb.append(ar.get(i).getMath());
				sb.append(",");
				sb.append(ar.get(i).getTotal());
				sb.append(",");
				sb.append(ar.get(i).getAvg());

				String line = sb.toString();
				File file = new File("C:\\study", "student.txt");
				FileWriter fw = new FileWriter(file, false);
				fw.write(line + "\r\n");
				fw.flush();
				fw.close();
			} else {

				StringBuffer sb = new StringBuffer();
				sb.append(ar.get(i).getNum());
				sb.append(",");
				sb.append(ar.get(i).getName());
				sb.append(",");
				sb.append(ar.get(i).getKor());
				sb.append(",");
				sb.append(ar.get(i).getEng());
				sb.append(",");
				sb.append(ar.get(i).getMath());
				sb.append(",");
				sb.append(ar.get(i).getTotal());
				sb.append(",");
				sb.append(ar.get(i).getAvg());

				String line = sb.toString();
				File file = new File("C:\\study", "student.txt");
				FileWriter fw = new FileWriter(file, true);
				fw.write(line + "\r\n");
				fw.flush();
				fw.close();
			}

		}

	}

	public void revise(StudentDTO studentDTO) throws Exception {

		List<StudentDTO> ar = this.makeList();

		for (int i = 0; i < ar.size(); i++) {
			if (ar.get(i).getNum() == studentDTO.getNum()) {
				ar.set(i, studentDTO);
				break;
			}
		}

		for (int i = 0; i < ar.size(); i++) {

			if (i == 0) {

				StringBuffer sb = new StringBuffer();
				sb.append(ar.get(i).getNum());
				sb.append(",");
				sb.append(ar.get(i).getName());
				sb.append(",");
				sb.append(ar.get(i).getKor());
				sb.append(",");
				sb.append(ar.get(i).getEng());
				sb.append(",");
				sb.append(ar.get(i).getMath());
				sb.append(",");
				sb.append(ar.get(i).getTotal());
				sb.append(",");
				sb.append(ar.get(i).getAvg());

				String line = sb.toString();
				File file = new File("C:\\study", "student.txt");
				FileWriter fw = new FileWriter(file, false);
				fw.write(line + "\r\n");
				fw.flush();
				fw.close();
			} else {

				StringBuffer sb = new StringBuffer();
				sb.append(ar.get(i).getNum());
				sb.append(",");
				sb.append(ar.get(i).getName());
				sb.append(",");
				sb.append(ar.get(i).getKor());
				sb.append(",");
				sb.append(ar.get(i).getEng());
				sb.append(",");
				sb.append(ar.get(i).getMath());
				sb.append(",");
				sb.append(ar.get(i).getTotal());
				sb.append(",");
				sb.append(ar.get(i).getAvg());

				String line = sb.toString();
				File file = new File("C:\\study", "student.txt");
				FileWriter fw = new FileWriter(file, true);
				fw.write(line + "\r\n");
				fw.flush();
				fw.close();
			}

		}
	}

}
