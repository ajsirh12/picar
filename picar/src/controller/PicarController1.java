package controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuestionDAO1;
import dao.QuestionDAOImpl1;
import model.Question;
import page2.PageManager;
import page2.PageSQL;

@WebServlet(name = "PicarController1", urlPatterns = {"/question_list","/question_insert","/question_req_list","/question_input"})
public class PicarController1 extends HttpServlet {

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
		
		if(action.equals("question_insert")) {
			//로그인 페이지로 이동하는 코드 넣어주세요
			RequestDispatcher rd = req.getRequestDispatcher("/write.jsp");
			rd.forward(req, resp);
		}
		else if(action.equals("question_list")) {
			
			QuestionDAO1 questionDAO = new QuestionDAOImpl1();
			List<Question> questions = questionDAO.selectAll();
			
			req.setAttribute("questions", questions);
			
			System.out.println(questions);
			
			RequestDispatcher rd = req.getRequestDispatcher("jsp/base/question.jsp");
			rd.forward(req, resp);	
		}
		
		else if(action.equals("question_req_list")) {
			
			int requestPage = Integer.parseInt(req.getParameter("reqPage"));
			PageManager pm = new PageManager(requestPage);
			
			QuestionDAO1 questionDAO = new QuestionDAOImpl1();
			List<Question> questions = questionDAO.selectAll(pm.getPageRowResullt().getRowStartNumber(), pm.getPageRowResullt().getRowEndNumber());
			
			req.setAttribute("questions", questions);
			
			req.setAttribute("pageGroupResult", pm.getPageGroupResult(PageSQL.QUESTION_SELECT_ALL_COUNT));
			
			RequestDispatcher rd = req.getRequestDispatcher("jsp/base/question2.jsp");
			rd.forward(req, resp);
			
		}
		
		else if(action.equals("question_input")) {
			
		}
		
	}
	
}
