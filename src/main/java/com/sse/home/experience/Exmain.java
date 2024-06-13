package com.sse.home.experience;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.sse.home.weather.WeatherDTO;

public class Exmain {

	public static void main(String[] args) {

		WeatherDTO dto = new WeatherDTO();
		dto.setCity("a");
		dto.setGion(1);
		dto.setHumidity(2);
		dto.setNum(1);
		dto.setStatus("b");

		File file = new File("C:\\study", "weather.txt");
		FileWriter fw = null;
		fw.wri
		
	}
}
