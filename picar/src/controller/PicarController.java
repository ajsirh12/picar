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
import dao.CarListDAO;
import dao.CarListDAOImpl;
import dao.JoinDAO;
import dao.JoinDAOImpl;
import dao.RentInfoDAO;
import dao.RentInfoDAOImpl;
import model.Car;
import model.CarList;
import model.JoinRent;
import model.RentInfo;
import page.PageManager;
import page.PageSQL;

<<<<<<< HEAD
@WebServlet(name = "PicarController", urlPatterns = {"/rentedList", "/rentedSearch"})
=======
@WebServlet(name = "PicarController", urlPatterns = {"/rentedList.do", "/rentedSearch.do", "/myRentCar.do", "/renew_car.do"})
>>>>>>> branch 'master' of https://github.com/ajsirh12/picar
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
		
		if(action.equals("rentedList.do")) {
			int requestPage = Integer.parseInt(req.getParameter("reqPage"));
			
			PageManager manager = new PageManager(requestPage);

			req.setAttribute("pageGroupResult", manager.getPageGroupResult(PageSQL.RENTED_SELECT_ALL_COUNT));
			
			int rowStartNumber = manager.getPageRowResult().getRowStartNumber();
			int rowEndNumber = manager.getPageRowResult().getRowEndNumber();
			System.out.println(rowStartNumber+" "+rowEndNumber);
			List<JoinRent> joinRentList = new ArrayList<JoinRent>();
			JoinDAO joinDAO = new JoinDAOImpl();
			//joinRentList = joinDAO.selectJoin();
			joinRentList = joinDAO.selectJoin(rowStartNumber, rowEndNumber);

			for(JoinRent j:joinRentList) {
				System.out.println(j);
			}
			req.setAttribute("rentedList", joinRentList);
			
			RequestDispatcher rd = req.getRequestDispatcher("jsp/admin/rentcarlist.jsp");
			rd.forward(req, resp);
		}
		else if(action.equals("rentedSearch.do")) {
			String carNum = req.getParameter("carNum");
			int requestPage = Integer.parseInt(req.getParameter("reqPage"));
			
			PageManager manager = new PageManager(requestPage);
			
			int rowStartNumber = manager.getPageRowResult().getRowStartNumber();
			int rowEndNumber = manager.getPageRowResult().getRowEndNumber();
			
			System.out.println(rowStartNumber+" "+rowEndNumber+" "+carNum);
			
			req.setAttribute("pageGroupResult", manager.getPageGroupResult(PageSQL.RENTED_SELECT_ALL_COUNT));
			List<JoinRent> joinRentList = new ArrayList<JoinRent>();
			JoinDAO joinDAO = new JoinDAOImpl();
			//joinRentList = joinDAO.selectJoinBycarNum(carNum);
			joinRentList = joinDAO.selectJoinBycarNum(rowStartNumber, rowEndNumber, carNum);
			for(JoinRent j:joinRentList) {
				System.out.println(j);
			}
			req.setAttribute("rentedList", joinRentList);
			RequestDispatcher rd = req.getRequestDispatcher("jsp/admin/rentcarlistsearch.jsp");
			rd.forward(req, resp);
		}
<<<<<<< HEAD
=======
		else if(action.equals("myRentCar.do")) {
			int membernum = Integer.parseInt(req.getParameter("membernum"));
			//System.out.println(membernum);
			
			RentInfoDAO rentInfoDAO = new RentInfoDAOImpl();
			RentInfo rentInfo = rentInfoDAO.selectByMemberNum(membernum);
			//System.out.println(rentInfo);
			
			if(rentInfo!=null) {
				String carNum = rentInfo.getCarNum();
				CarListDAO carListDAO = new CarListDAOImpl();
				CarList carList = carListDAO.selectByCarNum(carNum);
				
				//System.out.println(carList);
				
				int cartype = carList.getCarType();
				CarDAO carDAO = new CarDAOImpl();
				Car car = carDAO.selectByCarType(cartype);
				
				//System.out.println(car);
				
				req.setAttribute("rentinfo", rentInfo);
				req.setAttribute("carlist", carList);
				req.setAttribute("car", car);
				
				RequestDispatcher rd = req.getRequestDispatcher("jsp/client/myrentcar.jsp");
				rd.forward(req, resp);
			}
			else if(rentInfo==null) {
				resp.sendRedirect("index.jsp");
			}
		}
		else if(action.equals("renew_car.do")) {
			int renew = Integer.parseInt(req.getParameter("renew"));
			int rentNum = Integer.parseInt(req.getParameter("rentnum"));
			int memberNum = Integer.parseInt(req.getParameter("membernum"));
			
			RentInfoDAO rentInfoDAO = new RentInfoDAOImpl();
			rentInfoDAO.renewByRentNum(renew, rentNum);
			
			resp.sendRedirect("myRentCar.do?membernum=" + memberNum);
		}
>>>>>>> branch 'master' of https://github.com/ajsirh12/picar
	}
}
