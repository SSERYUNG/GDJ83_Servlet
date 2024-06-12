package com.sse.home.weather;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WeatherService {

	private StringBuffer sb;

	public WeatherService() {

		this.sb = new StringBuffer();
		this.sb.append(" 서울   , 29.3  -맑음  -   60");
		this.sb.append(" -부산   , 33.6  -흐림  -   90");
		this.sb.append(" -제주   , 26.8  -눈  -   30");
		this.sb.append(" -대구   , 11.1  -태풍  -   70");

	}

	public List<WeatherDTO> getWeathers() {

		String sbline = this.sb.toString();
		sbline = sbline.replace(',', '-');

		StringTokenizer st = new StringTokenizer(sbline, "-");

		ArrayList<WeatherDTO> wdtoar = new ArrayList<WeatherDTO>();

		while (st.hasMoreTokens()) {

			WeatherDTO wdto = new WeatherDTO();
			wdto.setCity(st.nextToken().trim());
			wdto.setGion(Double.parseDouble(st.nextToken().trim()));
			wdto.setStatus(st.nextToken().trim());
			wdto.setHumidity(Integer.parseInt(st.nextToken().trim()));

			wdtoar.add(wdto);

		}
		return wdtoar;
	}

}
