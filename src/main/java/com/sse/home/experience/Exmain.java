package com.sse.home.experience;

import java.util.List;

import com.sse.home.weather.WeatherDAO;
import com.sse.home.weather.WeatherDTO;

public class Exmain {

	public static void main(String[] args) {

		WeatherDAO a = new WeatherDAO();
		List<WeatherDTO> ar = null;
		try {
			ar = a.getWeathers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WeatherDTO b = new WeatherDTO();
		b.setNum(2);

		for (int i = 0; i < ar.size(); i++) {
			if (ar.get(i).getNum() == b.getNum()) {
				ar.remove(i);
				break;
			}
		}

		ar.get(0).setNum(555);

		System.out.println(ar.get(0).getNum());

	}
}
