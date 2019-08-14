package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarDAO;
import dao.CarDAOImpl;
import dao.JoinDAO;
import dao.JoinDAOImpl;
import model.Car;
import model.JoinRent;

@WebServlet(name = "PicarController", urlPatterns = {"/rentedList", "/rentedSearch","/insertcar"})
public class PicarController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
		System.out.println("doGet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
		System.out.println("doPost");
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		req.setCharacterEncoding("utf-8");
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		if(action.equals("rentedList")) {
			//String carNum = req.getParameter("carNum");
			List<JoinRent> joinRentList = new ArrayList<JoinRent>();
			JoinDAO joinDAO = new JoinDAOImpl();
			joinRentList = joinDAO.selectJoin();
			//joinRentList = joinDAO.selectJoinBycarNum("7");
			for(JoinRent j:joinRentList) {
				System.out.println(j);
			}
			req.setAttribute("rentedList", joinRentList);
			
			RequestDispatcher rd = req.getRequestDispatcher("jsp/admin/rentcarlist.jsp");
			rd.forward(req, resp);
		}
		else if(action.equals("rentedSearch")) {
			
		}
		else if(action.equals("insertcar")){
			RequestDispatcher rd = req.getRequestDispatcher("jsp/admin/insertcar.jsp");
			rd.forward(req,resp);
		}
		else if(action.equals("registercar")) {
			req.setCharacterEncoding("utf-8");
			
			CarDAO dao = new CarDAOImpl();
			Car car = new Car();
			
			car.setCarType(Integer.parseInt(req.getParameter("cartype")));
			car.setCarName(req.getParameter("carname"));
			car.setFuelType(req.getParameter("fueltype"));
			car.setColorType(req.getParameter("colortype"));
			car.setPeople(Integer.parseInt(req.getParameter("people")));
			car.setCarImage(req.getParameter("carimage"));
			
			boolean result = dao.insert(car);
			
			RequestDispatcher rd = req.getRequestDispatcher("jsp/admin/insertcar.jsp");
			rd.forward(req, resp);	
			
		}
	}
	
}
