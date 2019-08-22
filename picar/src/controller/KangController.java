package controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommListDAO;
import dao.CommListDAOImpl;
import dao.CommentJoinListDAO;
import dao.CommentJoinListDAOImpl;
import dao.PicarMemberDAO;
import dao.PicarMemberDAOImpl;
import dao.QuestionDAO;
import dao.QuestionDAO1;
import dao.QuestionDAOImpl;
import dao.QuestionDAOImpl1;
import model.CommList;
import model.CommentJoinList;
import model.PicarMember;
import model.Question;
import page2.PageManager;
import page2.PageSQL;

@WebServlet(name = "KangController", urlPatterns = {"/question_list.do","/question_insert.do","/question_req_list.do","/question_input.do","/question_req_insert.do",
													"/question_detail.do","/question_detail2.do","/question_delete.do","/question_update.do","/question_req_admin_list.do",
													"/question_admin_detail.do","/question_admin_delete.do","/question_admin_detail2.do","/commlist_insert.do","/commlist.update.do"})
public class KangController extends HttpServlet {

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
		
		if(action.equals("question_insert.do")) {
			//로그인 페이지로 이동하는 코드 넣어주세요
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/base/input.jsp");
			rd.forward(req, resp);
		}
		else if(action.equals("question_req_insert.do")) {
			
			QuestionDAO1 questionDAO = new QuestionDAOImpl1();
			Question question = new Question();
			
			question.setQuestTitle(req.getParameter("questTitle"));
			question.setQuestText(req.getParameter("questText"));	
			question.setMemberNum(Integer.parseInt(req.getParameter("memberNum")));
			
			boolean result = questionDAO.insert(question);
			
			System.out.println(question);
			
			
			RequestDispatcher rd = req.getRequestDispatcher("question_req_list.do?reqPage=1");
			rd.forward(req, resp);
		}
		
		else if(action.equals("question_list.do")) {
			
			QuestionDAO1 questionDAO = new QuestionDAOImpl1();
			List<Question> questions = questionDAO.selectAll();
			
			req.setAttribute("questions", questions);
			
			System.out.println(questions);
			
			RequestDispatcher rd = req.getRequestDispatcher("jsp/base/question.jsp");
			rd.forward(req, resp);	
		}
		
		else if(action.equals("question_req_list.do")) {
			
			int requestPage = Integer.parseInt(req.getParameter("reqPage"));
			PageManager pm = new PageManager(requestPage);

			CommentJoinListDAO commentJoinListDAO = new CommentJoinListDAOImpl();
			List<CommentJoinList> commentJoinLists = commentJoinListDAO.selectAll(pm.getPageRowResullt().getRowStartNumber(), pm.getPageRowResullt().getRowEndNumber());
			
			req.setAttribute("commentJoinLists", commentJoinLists);
			
			req.setAttribute("pageGroupResult", pm.getPageGroupResult(PageSQL.COMMENTJOINLIST_SELECT_ALL_COUNT));
			
			//System.out.println(commentJoinLists);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/base/question2.jsp");
			rd.forward(req, resp);
			 
		}
		
		else if(action.equals("question_detail.do")) {
			
			int questnum = Integer.parseInt(req.getParameter("questnum"));
			
			CommentJoinListDAO commentJoinListDAO = new CommentJoinListDAOImpl();
			CommentJoinList commentJoinList = commentJoinListDAO.selectByQuestnum(questnum);
			
			CommListDAO commListDAO = new CommListDAOImpl();
			CommList commList = commListDAO.selectByQuestnum(questnum);
			
			req.setAttribute("commList", commList);
			
			//System.out.println(commentJoinList);
			
			req.setAttribute("commentJoinList", commentJoinList);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/base/commentc1.jsp");
			rd.forward(req, resp);
			
		}
		
		else if(action.equals("question_detail2.do")) {
			
			int questnum = Integer.parseInt(req.getParameter("questnum"));
			
			CommentJoinListDAO commentJoinListDAO = new CommentJoinListDAOImpl();
			CommentJoinList commentJoinList = commentJoinListDAO.selectByQuestnum(questnum);
			
			//System.out.println(commentJoinList);
			
			req.setAttribute("commentJoinList", commentJoinList);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/base/commentc2.jsp");
			rd.forward(req, resp);
			
		}
		
		else if(action.equals("question_delete.do")) {
			
			CommentJoinListDAO commentJoinListDAO = new CommentJoinListDAOImpl();
			int questnum = Integer.parseInt(req.getParameter("questnum"));
			boolean result = commentJoinListDAO.deleteByQuestnum(questnum);
			
			System.out.println(result);
			
			RequestDispatcher rd = req.getRequestDispatcher("question_req_list.do?reqPage=1");
			rd.forward(req, resp);
		}
		else if(action.equals("question_update.do")) {
			
			CommentJoinList commentJoinList = new CommentJoinList();
			
			commentJoinList.setQuestnum(Integer.parseInt(req.getParameter("questnum")));//오류가 나는 부분 빼고 실행했을 경우 실행은 되나 false가 뜸			
			commentJoinList.setQuestTitle(req.getParameter("questTitle"));
			commentJoinList.setQuestText(req.getParameter("questText"));
			
			CommentJoinListDAO commentJoinListDAO = new CommentJoinListDAOImpl();
			boolean result = commentJoinListDAO.update(commentJoinList);
			
			System.out.println(result);
			System.out.println(commentJoinList);
			
			RequestDispatcher rd = req.getRequestDispatcher("question_req_list.do?reqPage=1");
			rd.forward(req, resp);
			
		}
		else if(action.equals("question_req_admin_list.do")) {
			
			int requestPage = Integer.parseInt(req.getParameter("reqPage"));
			PageManager pm = new PageManager(requestPage);

			CommentJoinListDAO commentJoinListDAO = new CommentJoinListDAOImpl();
			List<CommentJoinList> commentJoinLists = commentJoinListDAO.adminselectAll(pm.getPageRowResullt().getRowStartNumber(), pm.getPageRowResullt().getRowEndNumber());
			
			req.setAttribute("commentJoinLists", commentJoinLists);
			
			req.setAttribute("pageGroupResult", pm.getPageGroupResult(PageSQL.COMMENTJOINLIST_SELECT_ALL_COUNT));
			
			//System.out.println(commentJoinLists);
			
			RequestDispatcher rd = req.getRequestDispatcher("jsp/admin/adminquestionlist.jsp");
			rd.forward(req, resp);
		}
		
			else if(action.equals("question_admin_detail.do")) {
			
			int questnum = Integer.parseInt(req.getParameter("questNum"));
			
			CommentJoinListDAO commentJoinListDAO = new CommentJoinListDAOImpl();
			CommentJoinList commentJoinList = commentJoinListDAO.selectByQuestnum(questnum);
			
			req.setAttribute("commentJoinList", commentJoinList);
			
			CommListDAO commListDAO = new CommListDAOImpl();
			CommList commList = commListDAO.selectByQuestnum(questnum);
			
			req.setAttribute("commList", commList);
			
			RequestDispatcher rd = req.getRequestDispatcher("jsp/admin/commentadmin.jsp");
			rd.forward(req, resp);
			
		}
		
			else if(action.equals("question_admin_detail2.do")) {
				
				int questnum = Integer.parseInt(req.getParameter("questNum"));
				
				CommentJoinListDAO commentJoinListDAO = new CommentJoinListDAOImpl();
				CommentJoinList commentJoinList = commentJoinListDAO.selectByQuestnum(questnum);
				
				req.setAttribute("commentJoinList", commentJoinList);
				
				CommListDAO commListDAO = new CommListDAOImpl();
				CommList commList = commListDAO.selectByQuestnum(questnum);
				
				req.setAttribute("commList", commList);
				
				RequestDispatcher rd = req.getRequestDispatcher("jsp/admin/commentadmin2.jsp");
				rd.forward(req, resp);
				
			}
		
			else if(action.equals("question_admin_delete.do")) {
				
				CommentJoinListDAO commentJoinListDAO = new CommentJoinListDAOImpl();
				int questnum = Integer.parseInt(req.getParameter("questnum"));
				boolean result = commentJoinListDAO.deleteByQuestnum(questnum);
				
				System.out.println(result);
				
				RequestDispatcher rd = req.getRequestDispatcher("question_req_admin_list.do?reqPage=1");
				rd.forward(req, resp);
				
			}
		
			else if(action.equals("commlist_insert.do")) {
				
				int questnum = Integer.parseInt(req.getParameter("questNum"));
				
				CommListDAO commListDAO = new CommListDAOImpl();
				CommList commList = new CommList();
			
				commList.setCommText(req.getParameter("commText"));
				commList.setCommNum(Integer.parseInt(req.getParameter("commNum")));
				commList.setMemberNum(Integer.parseInt(req.getParameter("memberNum")));
				commList.setQuestnum(Integer.parseInt(req.getParameter("questNum")));
				
				boolean result = commListDAO.insert(commList);
				
				CommentJoinListDAO commentJoinListDAO = new CommentJoinListDAOImpl();
				boolean result1 = commentJoinListDAO.updateAnswer(questnum);
				
				RequestDispatcher rd = req.getRequestDispatcher("question_req_admin_list.do?reqPage=1");
				rd.forward(req, resp);
			}
		
			else if(action.equals("commlist.update.do")) {
				
				CommList commList = new CommList();
				
				commList.setCommText(req.getParameter("commText"));
				commList.setMemberNum(Integer.parseInt(req.getParameter("memberNum")));
				commList.setQuestnum(Integer.parseInt(req.getParameter("questNum")));
				
				CommListDAO commListDAO = new CommListDAOImpl();
				boolean result = commListDAO.update(commList);
				
				System.out.println(commList);
				
				RequestDispatcher rd = req.getRequestDispatcher("question_req_admin_list.do?reqPage=1");
				rd.forward(req, resp);
			}
	}
	
}
