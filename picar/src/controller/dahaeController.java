package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CommentJoinListDAO;
import dao.CommentJoinListDAOImpl;
import dao.MemberGradeDAO;
import dao.MemberGradeDAOImpl;
import dao.PicarMemberDAO;
import dao.PicarMemberDAOImpl;
import model.CommentJoinList;
import model.MemberGrade;
import model.PicarMember;
import page2.PageManager;
import page2.PageSQL;

@WebServlet(name = "dahaeController", urlPatterns = {"/login","/logout","/login_input","/member_save",
				"/sign_up","/idcheck","/idinput","/idfind","/id_find","/password_find","/passwordfind",
				"/password_update","/picarmemberlist","/member_detail","/picarmember_update",
				"/picarmember_delete","/member_infor","/member_infor_update","/passwodcheck"})
public class dahaeController extends HttpServlet {

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
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/base/login.jsp");
			rd.forward(req, resp);
		
		//로그인
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
								
				RequestDispatcher rd = req.getRequestDispatcher("/jsp/base/login.jsp");
				rd.forward(req, resp);
				
			}			
			
		}else if(action.equals("logout")) {			
			
			HttpSession session = req.getSession();
			session.removeAttribute("picarmember");
			
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, resp);	
		
		//회원가입
		}else if(action.equals("member_save")) {	
						
			PicarMemberDAO dao = new PicarMemberDAOImpl();
			PicarMember picarMember = new PicarMember();
			
			picarMember.setId(req.getParameter("id"));
			picarMember.setPassword(req.getParameter("password"));
			picarMember.setName(req.getParameter("name"));
			picarMember.setPhone(req.getParameter("phone"));
			picarMember.setLicense(req.getParameter("license"));
			picarMember.setValidate(req.getParameter("years")+req.getParameter("month")+req.getParameter("days"));			
			
			boolean result = dao.insert(picarMember);
			System.out.println(result);
		
			/*RequestDispatcher rd =req.getRequestDispatcher("/index.jsp");
			rd.forward(req, resp);*/
			resp.sendRedirect("index.jsp");
	
		//회원가입 입력화면
		}else if(action.equals("sign_up")) {
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/base/membership.jsp");
			rd.forward(req, resp);
									
		//아이디 입력화면
		}else if(action.equals("idinput")) {
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/base/membership.jsp");
			rd.forward(req, resp);
	
		//중복체크
			
		}else if(action.equals("idcheck")) {

			PicarMemberDAO dao = new PicarMemberDAOImpl();
			int count = dao.checkById(req.getParameter("id"));
			
			req.setAttribute("count", count);
			
			if(count==0) 
			{
				req.setAttribute("message", "멋진 아이디네요!");
			}else {
				req.setAttribute("message", "이미 사용중이거나 탈퇴한 아이디입니다.");				
			}
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/base/idcheckResult.jsp");
			rd.forward(req, resp);	
				
		//아이디찾기 입력화면
		}else if(action.equals("id_find")) {
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/base/idFind.jsp");
			rd.forward(req, resp);	
					
		//아이디찾기
		}else if(action.equals("idfind")){
			String name = req.getParameter("name2");
			String phone = req.getParameter("phone2");
			
			PicarMemberDAO dao = new PicarMemberDAOImpl();
			
			PicarMember picarmember = dao.selectFindId(name, phone);
						
			req.setAttribute("picarrmember", picarmember);
			System.out.println(picarmember);
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/base/findId.jsp");
			rd.forward(req, resp);
	
		//비밀번호 찾기 입력화면
		}else if (action.equals("password_find")) {
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/base/passwordFind.jsp");
			rd.forward(req, resp);	
			
		//비밀번호 찾기
		}else if (action.equals("passwordfind")) {
			
			String id = req.getParameter("id");					
			String name = req.getParameter("name"); 
			String phone = req.getParameter("phone");
			
			PicarMemberDAO dao = new PicarMemberDAOImpl();
			PicarMember picarmember = dao.selectFindPassword(id, name, phone);
			
			req.setAttribute("picarmembers", picarmember);
			System.out.println(picarmember);

			RequestDispatcher rd = req.getRequestDispatcher("/jsp/base/passwordChange.jsp");
			rd.forward(req, resp);	
		
		//비밀번호 찾기 변경
		}else if(action.equals("password_update")) {
			
			PicarMemberDAO dao = new PicarMemberDAOImpl();
			PicarMember picarMember = new PicarMember();			
			
			picarMember.setPassword(req.getParameter("password"));
			picarMember.setName(req.getParameter("name"));
			picarMember.setId(req.getParameter("id"));
			picarMember.setPhone(req.getParameter("phone"));
			
			boolean result = dao.update(picarMember);

			System.out.println(picarMember);
			System.out.println(result);

			RequestDispatcher rd = req.getRequestDispatcher("/jsp/base/login.jsp");
			rd.forward(req, resp);
		
		//관리자 회원 리스트
		}else if(action.equals("picarmemberlist")) {
			
			PicarMemberDAO dao = new PicarMemberDAOImpl();

			List<PicarMember> picarmemberlists = dao.selectAll();
			
			req.setAttribute("picarmemberlists",picarmemberlists);	
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/admin/picarmemberlist.jsp");
			rd.forward(req, resp);
			
		//관리자 회원 디테일
		}else if (action.equals("member_detail")) {
			
			int memnum = Integer.parseInt(req.getParameter("memberdetail"));
			
			PicarMemberDAO dao = new PicarMemberDAOImpl();
			MemberGradeDAO dao2 = new MemberGradeDAOImpl();
			
			PicarMember picarmember = dao.selectByNum(memnum);
			List<MemberGrade> membergrades = dao2.gradeSelectAll();
			
			req.setAttribute("picarmember", picarmember);
			req.setAttribute("membergrades", membergrades);
				
			RequestDispatcher rd =req.getRequestDispatcher("/jsp/admin/picarmemberdetail.jsp");
			rd.forward(req, resp);	
		
		//관리자 회원정보 수정
		}else if(action.equals("picarmember_update")) {
			
			PicarMember picarmember = new PicarMember();
			
			picarmember.setId(req.getParameter("id"));
			picarmember.setPassword(req.getParameter("password"));
			picarmember.setName(req.getParameter("name"));
			picarmember.setPhone(req.getParameter("phone"));
			picarmember.setLicense(req.getParameter("license"));
			picarmember.setValidate(req.getParameter("validate"));
			picarmember.setGradeNo(Integer.parseInt(req.getParameter("membergrade")));
			picarmember.setMemberNum(Integer.parseInt(req.getParameter("membernum")));
							
			PicarMemberDAO dao = new PicarMemberDAOImpl();
			boolean result = dao.memberUpdate(picarmember);
			
			System.out.println(picarmember+"1212");
			System.out.println(result);
			
			RequestDispatcher rd = req.getRequestDispatcher("picarmemberlist");
			rd.forward(req, resp);
			
		//관리자가 회원 정보 삭제
		}else if(action.equals("picarmember_delete")) {
			
			int membernum = Integer.parseInt(req.getParameter("membernum"));
			
			PicarMemberDAO dao = new PicarMemberDAOImpl();
			boolean result = dao.deleteByMemberNum(membernum);
					
			System.out.println(result);
						
			RequestDispatcher rd =req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		
		
		//회원의 정보 화면
		}else if(action.equals("member_infor")) {
			
			RequestDispatcher rd = req.getRequestDispatcher("jsp/client/memberinfor.jsp");
			rd.forward(req, resp);
			
		//회원의 정보 수정
		}else if(action.equals("member_infor_update")) {
			
			PicarMember picarmember = new PicarMember();
			
			picarmember.setPassword(req.getParameter("newpassword"));
			picarmember.setName(req.getParameter("name"));
			picarmember.setPhone(req.getParameter("phone"));
			picarmember.setLicense(req.getParameter("license"));
			picarmember.setValidate(req.getParameter("validate"));
			picarmember.setMemberNum(Integer.parseInt(req.getParameter("membernum")));
							
			PicarMemberDAO dao = new PicarMemberDAOImpl();
			boolean result = dao.memberInforUpdate(picarmember);
			
			System.out.println(picarmember);
			System.out.println(result);
			
			RequestDispatcher rd = req.getRequestDispatcher("jsp/client/memberinfor.jsp");
			rd.forward(req, resp);
		
		
		}else if(action.equals("passwodcheck")) {
	
			PicarMemberDAO dao = new PicarMemberDAOImpl();
			int count = dao.checkBypwd(req.getParameter("password"));
			
			req.setAttribute("count", count);
			
			if(count==0) 
			{
				req.setAttribute("message", "기존 비밀번호가 다릅니다.");
			}else {
				req.setAttribute("message", "비밀번호가 확인 되었습니다.");				
			}
			
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);	
			
		}

		
	}	
}
