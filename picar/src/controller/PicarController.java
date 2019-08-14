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
import javax.servlet.http.HttpSession;

import dao.PicarMemberDAO;
import dao.PicarMemberDAOImpl;
import model.PicarMember;

import dao.CarDAO;
import dao.CarDAOImpl;
import dao.JoinDAO;
import dao.JoinDAOImpl;
import model.Car;
import model.JoinRent;
import page.PageManager;
import page.PageSQL;

<<<<<<< HEAD
@WebServlet(name = "PicarController", urlPatterns = {"/rentedList", "/rentedSearch", "/login","/logout","/login_input","/member_save"})
=======
@WebServlet(name = "PicarController", urlPatterns = {"/rentedList", "/rentedSearch","/insertcar"})
>>>>>>> refs/remotes/origin/master
public class PicarController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		req.setCharacterEncoding("utf-8");
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
	
		//로그인 입력 
		if(action.equals("login_input")) {
			
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.forward(req, resp);
			
		}else if(action.equals("login")) {
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			
			PicarMemberDAO dao = new PicarMemberDAOImpl();
			PicarMember picarmember = dao.selectById(id, password);
			
			
			if(picarmember !=null){
				HttpSession session = req.getSession();
				session.setAttribute("picarmember", picarmember);
				
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.forward(req, resp);
								
			}else{				
				
				req.setAttribute("message", "유효하지 않는 아이디이거나, 비밀번호가 일치하지 않습니다.");
								
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.forward(req, resp);
				
			}			
			
		}else if(action.equals("logout")) {			
			
			HttpSession session = req.getSession();
			session.removeAttribute("picarmember");
			
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);	
		
		}else if(action.equals("rentedList")) {
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
		else if(action.equals("rentedSearch")) {
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
		else if(action.equals("member_save")) {
			PicarMemberDAO dao = new PicarMemberDAOImpl();
			PicarMember picarMember = new PicarMember();
			
			picarMember.setId(req.getParameter("id"));
			picarMember.setPassword(req.getParameter("password"));
			picarMember.setName(req.getParameter("name"));
			picarMember.setPhone(req.getParameter("phone"));
			picarMember.setLicense(Integer.parseInt(req.getParameter("license")));
			picarMember.setValidate(req.getParameter("validdate"));
			
		
			boolean result = dao.insert(picarMember);
			System.out.println(result);
		
			RequestDispatcher rd =req.getRequestDispatcher("/membership.jsp");
			rd.forward(req, resp);
		
		
		
		
		}
		
}}
=======
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
>>>>>>> refs/remotes/origin/master
