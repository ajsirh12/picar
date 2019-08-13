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

import dao.JoinDAO;
import dao.JoinDAOImpl;
import model.JoinRent;
import page.PageManager;
import page.PageSQL;

@WebServlet(name = "PicarController", urlPatterns = {"/rentedList", "/rentedSearch"})
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
			int requestPage = Integer.parseInt(req.getParameter("reqPage"));
			System.out.println(Integer.parseInt(req.getParameter("reqPage")));
			PageManager manager = new PageManager(requestPage);

			req.setAttribute("pageGroupResult", manager.getPageGroupResult(PageSQL.RENTED_SELECT_ALL_COUNT));
			
			List<JoinRent> joinRentList = new ArrayList<JoinRent>();
			JoinDAO joinDAO = new JoinDAOImpl();
			joinRentList = joinDAO.selectJoinPage(manager.getPageRowResult().getRowStartNumber(), manager.getPageRowResult().getRowEndNumber());

			for(JoinRent j:joinRentList) {
				System.out.println(j);
			}
			req.setAttribute("rentedList", joinRentList);
			
			RequestDispatcher rd = req.getRequestDispatcher("jsp/admin/rentcarlist.jsp");
			rd.forward(req, resp);
		}
		else if(action.equals("rentedSearch")) {
			String carNum = req.getParameter("carNum");
			System.out.println(carNum);
			List<JoinRent> joinRentList = new ArrayList<JoinRent>();
			JoinDAO joinDAO = new JoinDAOImpl();
			joinRentList = joinDAO.selectJoinBycarNum(carNum);
			for(JoinRent j:joinRentList) {
				System.out.println(j);
			}
			req.setAttribute("rentedList", joinRentList);
			RequestDispatcher rd = req.getRequestDispatcher("jsp/admin/rentcarlist.jsp");
			rd.forward(req, resp);
		}
	}
	
}
