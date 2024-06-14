package com.sse.home.weather;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sse.home.Action;

public class WeatherController {

	private WeatherService ws;

	public WeatherController() {
		this.ws = new WeatherService();
	}

	public Action start(HttpServletRequest request) {

		String uri = request.getRequestURI();
		String[] ar = uri.split("/");

		Action action = new Action();
		action.setFlag(true);

		String method = request.getMethod().toUpperCase();

		if (ar[2].equals("list")) {

			List<WeatherDTO> wdtoar = ws.getWeathers();
			request.setAttribute("weatherlist", wdtoar);

			action.setPath("/WEB-INF/views/weather/list.jsp");
		} else if (ar[2].equals("add")) {

			if (method.equals("POST")) {
				String city = request.getParameter("city");
				double gion = Double.parseDouble(request.getParameter("gion"));
				String status = request.getParameter("status");
				int humidity = Integer.parseInt(request.getParameter("humidity"));

				WeatherDTO weatherDTO = new WeatherDTO();
				weatherDTO.setCity(city);
				weatherDTO.setGion(gion);
				weatherDTO.setStatus(status);
				weatherDTO.setHumidity(humidity);

				ws.add(weatherDTO);

				action.setFlag(false);
				action.setPath("/weather/list");

			} else {

				action.setPath("/WEB-INF/views/weather/add.jsp");
			}
		} else if (ar[2].equals("delete")) {

		} else if (ar[2].equals("detail")) {

			String num = request.getParameter("num");
			WeatherDTO weatherDTO = new WeatherDTO();
			weatherDTO.setNum(Long.parseLong(num));
			weatherDTO = ws.getDetail(weatherDTO);

			if (weatherDTO != null) {
				request.setAttribute("dto", weatherDTO);
				action.setPath("/WEB-INF/views/weather/detail.jsp");
			} else {
				request.setAttribute("message", "정보가 없어요");
				action.setPath("/WEB-INF/views/commons/message.jsp");
			}
		} else {

		}

		return action;

	}

}
