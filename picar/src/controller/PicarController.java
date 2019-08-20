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
import dao.LocationDAO;
import dao.LocationDAOImpl;
import dao.RentInfoDAO;
import dao.RentInfoDAOImpl;
import model.Car;
import model.CarList;
import model.JoinRent;
import model.Location;
import model.RentInfo;
import page.PageManager;
import page.PageSQL;

@WebServlet(name = "PicarController", urlPatterns = {"/rentedList.do", "/rentedSearch.do", "/myRentCar.do", "/renew_car.do", "/allRentCar.do",
		"/allRentCarSearch.do", "/carDetail.do", "/returnCar.do", "/carInfoUpdate.do", "/carInfoDelete.do"})
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
			//System.out.println(rowStartNumber+" "+rowEndNumber);
			
			List<JoinRent> joinRentList = new ArrayList<JoinRent>();
			JoinDAO joinDAO = new JoinDAOImpl();
			//joinRentList = joinDAO.selectJoin();
			joinRentList = joinDAO.selectJoin(rowStartNumber, rowEndNumber);

			/*for(JoinRent j:joinRentList) {
				System.out.println(j);
			}*/
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
			
			//System.out.println(rowStartNumber+" "+rowEndNumber+" "+carNum);
			
			req.setAttribute("pageGroupResult", manager.getPageGroupResult(PageSQL.RENTED_SELECT_ALL_COUNT_SEARCHED, carNum));
			List<JoinRent> joinRentList = new ArrayList<JoinRent>();
			JoinDAO joinDAO = new JoinDAOImpl();
			//joinRentList = joinDAO.selectJoinBycarNum(carNum);
			joinRentList = joinDAO.selectJoinBycarNum(rowStartNumber, rowEndNumber, carNum);
			/*for(JoinRent j:joinRentList) {
				System.out.println(j);
			}*/
			req.setAttribute("rentedList", joinRentList);
			RequestDispatcher rd = req.getRequestDispatcher("jsp/admin/rentcarlistsearch.jsp");
			rd.forward(req, resp);
		}
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
		else if(action.equals("allRentCar.do")) {
			int requestPage = Integer.parseInt(req.getParameter("reqPage"));
			
			PageManager manager = new PageManager(requestPage);

			req.setAttribute("pageGroupResult", manager.getPageGroupResult(PageSQL.CARLIST_SELECT_ALL_COUNT));
			
			int rowStartNumber = manager.getPageRowResult().getRowStartNumber();
			int rowEndNumber = manager.getPageRowResult().getRowEndNumber();
			
			CarListDAO carListDAO = new CarListDAOImpl();
			List<CarList> carListList = carListDAO.selectAll(rowStartNumber, rowEndNumber);
			/*for(CarList c:carListList) {
				System.out.println(c);
			}*/
			CarDAO carDAO = new CarDAOImpl();
			List<Car> carList = carDAO.selectAll();
			/*for(Car c:carList) {
				System.out.println(c);
			}*/
			LocationDAO locationDAO = new LocationDAOImpl();
			List<Location> locationList = locationDAO.selectAll();
			/*for(Location c:locationList) {
				System.out.println(c);
			}*/
			req.setAttribute("carListList", carListList);
			req.setAttribute("carList", carList);
			req.setAttribute("locationList", locationList);
			
			RequestDispatcher rd = req.getRequestDispatcher("jsp/admin/allrentcar.jsp");
			rd.forward(req, resp);
		}
		else if(action.equals("carDetail.do")) {
			String carNum = req.getParameter("carNum");
			
			CarListDAO carListDAO = new CarListDAOImpl();
			CarList carListList = carListDAO.selectByCarNum(carNum);
				
			System.out.println(carListList);
				
			CarDAO carDAO = new CarDAOImpl();
			List<Car> carList = carDAO.selectAll();
			LocationDAO locationDAO = new LocationDAOImpl();
			List<Location> locationList = locationDAO.selectAll();
			for(Location c:locationList) {
				System.out.println("1"+c);
			}
			for(Car c:carList) {
				System.out.println("2"+c);
			}
			req.setAttribute("carListList", carListList);
			req.setAttribute("carList", carList);
			req.setAttribute("locationList", locationList);
			
			RequestDispatcher rd = req.getRequestDispatcher("jsp/admin/carDetail.jsp");
			rd.forward(req, resp);
		}
		else if(action.equals("returnCar.do")) {
			String carNum = req.getParameter("carNum");
			
			CarListDAO carListDAO = new CarListDAOImpl();
			carListDAO.updateValidRent(carNum);
			RentInfoDAO rentInfoDAO = new RentInfoDAOImpl();
			rentInfoDAO.deleteByCarNum(carNum);
			
			resp.sendRedirect("rentedList.do?reqPage=1");
		}
		else if(action.equals("carInfoUpdate.do")) {
			CarListDAO carListDAO = new CarListDAOImpl();
			CarList carList = new CarList();
			
			//String carNum = req.getParameter("carnum");
			
			carList.setCost(Integer.parseInt(req.getParameter("cost")));
			carList.setValidRent(req.getParameter("validrent"));
			carList.setCarLoc(Integer.parseInt(req.getParameter("carloc")));
			carList.setCarnum(req.getParameter("carnum"));
			carListDAO.updateCost(carList);
			
			resp.sendRedirect("allRentCar.do?reqPage=1");
		}
		else if(action.equals("carInfoDelete.do")) {
			String carNum = req.getParameter("carnum");
			System.out.println(carNum);
			CarListDAO carListDAO = new CarListDAOImpl();
			carListDAO.deleteCarList(carNum);
			
			resp.sendRedirect("allRentCar.do?reqPage=1");
		}
	}
	
}
