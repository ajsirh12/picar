package controller;

import java.io.IOException;
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
import dao.JoinDetailDAO;
import dao.JoinDetailDAOImpl;
import dao.LocationDAO;
import dao.LocationDAOImpl;
import model.Car;
import model.CarList;
import model.JoinDetail;
import model.JoinInsert;
import model.Location;


@WebServlet(name = "EunJungController", urlPatterns = {"/insertcar","/registercar","/carlistloc",
													"/carlists","/carlisty","/cardetail","/carsearch"})

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
	            CarDAO carDAO = new CarDAOImpl();
	            List<Car> carList = carDAO.selectAll();
	            
	            LocationDAO locationDAO = new LocationDAOImpl();
	            List<Location> locationLIst = locationDAO.selectAll();
	            
	            req.setAttribute("carlist", carList);
	            req.setAttribute("locationlist", locationLIst);
	            
	            RequestDispatcher rd = req.getRequestDispatcher("/jsp/admin/insertcar.jsp");
	            rd.forward(req, resp);
			
			// 차량등록
			}else if(action.equals("registercar")) {
				
				CarDAO dao = new CarDAOImpl();
				JoinInsert jis = new JoinInsert();
				
				jis.setCarNum(req.getParameter("carnum"));
				jis.setCarType(Integer.parseInt(req.getParameter("cartype")));
				jis.setCost(Integer.parseInt(req.getParameter("cost")));
				jis.setCarloc(Integer.parseInt(req.getParameter("carloc")));
				
				//제대로 들어가있는지 true, false로 확인하기 위해 사용
				boolean result = dao.insert(jis);
				
				System.out.println(jis);
				System.out.println(result);
				
				RequestDispatcher rd = req.getRequestDispatcher("/jsp/client/carlist.jsp");
	            rd.forward(req, resp);
				
			
			//보유지점 리스트
			}else if(action.equals("carlistloc")) {
				LocationDAO dao = new LocationDAOImpl();
				List<Location> loclist = dao.selectAll();
				
				req.setAttribute("carlocc", loclist);
				
				System.out.println(loclist);
				
				
				RequestDispatcher rd = req.getRequestDispatcher("/jsp/client/carlistloc.jsp");
				rd.forward(req, resp);
				
			// 차량리스트	
			}/*else if(action.equals("carlists")) {
				
				int carloc = Integer.parseInt(req.getParameter("carloc"));
				
				CarListDAO dao = new CarListDAOImpl();
				
				CarList carlist = dao.selectByCarloc(carloc);
				
				req.setAttribute("carlist", carlist);
				
				System.out.println(carlist);
				
				RequestDispatcher rd = req.getRequestDispatcher("/jsp/client/carlist.jsp");
				rd.forward(req, resp);
				
			//차량리스트
			}*/else if(action.equals("carlisty")) {
				int carloc = Integer.parseInt(req.getParameter("carloc"));
	
				CarListDAO dao = new CarListDAOImpl();
				List<CarList> carlists = dao.selectbyCarloc(carloc);
		
				req.setAttribute("carloc", carloc);
				req.setAttribute("carlists", carlists);

				RequestDispatcher rd = req.getRequestDispatcher("/jsp/client/carlist.jsp");
				rd.forward(req, resp);
		     
			//차량상세보기			
			}else if(action.equals("cardetail")) {
				
				String carnum = req.getParameter("carnum");
				
				JoinDetailDAO dao = new JoinDetailDAOImpl();
				JoinDetail detail = dao.selectByCarNum(carnum);
				
				System.out.println(detail);
								
				req.setAttribute("detail", detail);
				
				RequestDispatcher rd = req.getRequestDispatcher("/jsp/client/cardetail.jsp");
				rd.forward(req, resp);
				
			// 차량검색	
			}else if(action.equals("carsearch")) {
				
				String carname = req.getParameter("carname");
				int carloc = Integer.parseInt(req.getParameter("carloc"));
				
				CarListDAO listdao = new CarListDAOImpl();
				List<CarList> carlists = listdao.selectByName(carloc, carname);
				
				LocationDAO locdao = new LocationDAOImpl();
				Location loc = locdao.selectByCarloc(carloc);
							
				req.setAttribute("carlists", carlists);
				req.setAttribute("loc", loc);
				
				for(CarList carlist : carlists) {
					System.out.println(carlist);
				}

				RequestDispatcher rd = req.getRequestDispatcher("/jsp/client/carlist.jsp");
				rd.forward(req, resp);				
			}		
		}			
}
