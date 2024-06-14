package com.sse.home.weather;

import java.util.List;

public class WeatherService {

	private WeatherDAO wdao;

	public WeatherService() {
		wdao = new WeatherDAO();
	}

//	list를 가져오는거
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

//	detail 가져오는거
	public WeatherDTO getDetail(WeatherDTO weatherDTO) {
		try {
			weatherDTO = wdao.getDetail(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			weatherDTO = null;
		}
		return weatherDTO;
	}

	public void add(WeatherDTO weatherDTO) {

		try {
			wdao.add(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void delete(WeatherDTO weatherDTO) {
		try {
			wdao.delete(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
