package com.sse.home.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WeatherDAO {

//	getWeathers 메소드
//	파일 날씨정보들을 담아서 파싱하고 DTO에 담아서 리턴

	public List<WeatherDTO> getWeathers() throws Exception {

		File file = new File("C:\\study", "weather.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<WeatherDTO> wdtoar = new ArrayList<WeatherDTO>();

		while (true) {
			String line = br.readLine();
			if (line != null) {
				line = line.replace(',', '-');
				String[] ar = line.split("-");

				WeatherDTO wdto = new WeatherDTO();

				wdto.setNum(Long.parseLong(ar[0].trim()));
				wdto.setCity(ar[1].trim());
				wdto.setGion(Double.parseDouble(ar[2].trim()));
				wdto.setStatus(ar[3].trim());
				wdto.setHumidity(Integer.parseInt(ar[4].trim()));

				wdtoar.add(wdto);
			} else {
				break;
			}
		}
		br.close();
		fr.close();
		return wdtoar;

	}

	// 리스트에서 하나만 꺼내오는 메서드
	public WeatherDTO getDetail(WeatherDTO weatherDTO) throws Exception {
		List<WeatherDTO> ar = this.getWeathers();
		WeatherDTO result = null;

		for (WeatherDTO w : ar) {
			if (w.getNum() == weatherDTO.getNum()) {
				result = w;
				break;
			}
		}

		return result;
	}

	public void add(WeatherDTO weatherDTO) throws Exception {
//		FileWriter에서 예외 발생한거 던져둠

//		도시명-기온-상태-습도
		Calendar ca = Calendar.getInstance();

		StringBuffer sb = new StringBuffer();

		sb.append(ca.getTimeInMillis());
		sb.append("-");
		sb.append(weatherDTO.getCity());
		sb.append("-");
		sb.append(weatherDTO.getGion());
		sb.append("-");
		sb.append(weatherDTO.getStatus());
		sb.append("-");
		sb.append(weatherDTO.getHumidity());

		String line = sb.toString();

		File file = new File("C:\\study", "weather.txt");
		FileWriter fw = null;
		fw = new FileWriter(file, true);
		fw.write(line + "\r\n");
		fw.flush();
		fw.close();
	}

//	딜리트 메서드
	public void delete(WeatherDTO weatherDTO) throws Exception {
//		전체 날씨 리스트를 불러와서
//		지우려고 하는 num과 일치하는 것을 리스트에서 삭제
//		이 삭제된 리스트를 파일에 다시 저장
		List<WeatherDTO> ar = this.getWeathers();

		for (int i = 0; i < ar.size(); i++) {
			if (ar.get(i).getNum() == weatherDTO.getNum()) {
				ar.remove(i);
				break;
			}
		}

		for (int i = 0; i < ar.size(); i++) {
			ar.get(i).setNum(i + 1);
		}

		for (int i = 0; i < ar.size(); i++) {
			StringBuffer sb = new StringBuffer();
			sb.append(ar.get(i).getNum());
			sb.append("-");
			sb.append(ar.get(i).getCity());
			sb.append("-");
			sb.append(ar.get(i).getGion());
			sb.append("-");
			sb.append(ar.get(i).getStatus());
			sb.append("-");
			sb.append(ar.get(i).getHumidity());
			String line = sb.toString();

			if (i == 0) {
				File file = new File("C:\\study", "weather.txt");
				FileWriter fw = null;
				fw = new FileWriter(file, false);

				fw.write(line + "\r\n");
				fw.flush();
				fw.close();
			} else {
				File file = new File("C:\\study", "weather.txt");
				FileWriter fw = null;
				fw = new FileWriter(file, true);

				fw.write(line + "\r\n");
				fw.flush();
				fw.close();
			}
		}

	}
}
