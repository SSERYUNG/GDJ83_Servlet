package com.sse.home.experience;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.sse.home.weather.WeatherDAO;
import com.sse.home.weather.WeatherDTO;

public class Exmain {

	public static void main(String[] args) {


		File file = new File("C:\\study", "a.txt");
		FileWriter fw=null;
		try {
			fw = new FileWriter(file, true);
			fw.write("hello");
			fw.write("ii");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
