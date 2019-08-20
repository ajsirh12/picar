package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarDAO;
import dao.CarDAOImpl;
import model.JoinInsert;

@WebServlet(name = "EunJungController", urlPatterns = {"/insertcar","/registercar","/carlistloc"})

public class EunJungController extends HttpServlet{

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
			
			String uri = req.getRequestURI();
			
			System.out.println(uri);
			
			int lastIndex = uri.lastIndexOf("/");
			String action = uri.substring(lastIndex+1);
			
			req.setCharacterEncoding("utf-8");
			
			if(action.equals("insertcar")) {
				RequestDispatcher rd = req.getRequestDispatcher("/jsp/admin/insertcar.jsp");
				rd.forward(req, resp);
			
			}else if(action.equals("registercar")) {
				
				CarDAO dao = new CarDAOImpl();
				JoinInsert jis = new JoinInsert();
				
				jis.setCarNum(req.getParameter("carnum"));
				jis.setCarname(req.getParameter("carname"));
				jis.setCost(Integer.parseInt(req.getParameter("cost")));
				jis.setCarloc(Integer.parseInt(req.getParameter("carloc")));
				
				//제대로 들어가있는지 true, false로 확인하기 위해 사용
				boolean result = dao.insert(jis);
				
				System.out.println(jis);
				System.out.println(result);
				
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.forward(req, resp);			
			}			
		}			
}
