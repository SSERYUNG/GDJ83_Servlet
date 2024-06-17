package com.sse.home;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sse.home.student.StudentController;
import com.sse.home.weather.WeatherController;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// TODO Auto-generated method stub
		System.out.println("실행 됨");

		String uri = request.getRequestURI();
		String method = request.getMethod();

		if (!uri.equals("/favicon.ico")) {

//			System.out.println(uri);
//			System.out.println(method);

			String[] ar = uri.split("/");

			String path = "";
			Action action = new Action();

			if (uri.equals("/")) {
				action.setFlag(true);
				action.setPath("/WEB-INF/views/index.jsp");
			} else if (ar[1].equals("student")) {
				StudentController st = new StudentController();
				action = st.start(request);

			} else if (ar[1].equals("weather")) {
				WeatherController wt = new WeatherController();
				action = wt.start(request);

			}
			if (action.isFlag()) {

				RequestDispatcher view = request.getRequestDispatcher(action.getPath());
				view.forward(request, response);
			} else {
				response.sendRedirect(action.getPath());
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
