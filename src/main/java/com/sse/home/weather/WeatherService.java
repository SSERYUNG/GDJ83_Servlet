package com.sse.home.weather;

import java.util.List;

public class WeatherService {

	private WeatherDAO wdao;

	public WeatherService() {
		wdao = new WeatherDAO();
	}

	public List<WeatherDTO> getWeathers() {

		List<WeatherDTO> ar = null;
		try {
			ar = wdao.getWeathers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ar;
	}

}
