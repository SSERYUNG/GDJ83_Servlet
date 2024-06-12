package com.sse.home.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
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
}
