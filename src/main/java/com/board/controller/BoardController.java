package com.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.board.db.BoardDto;
import com.board.db.UserDto;
import com.board.db.UserDao;
import com.board.service.BoardService;

@WebServlet("/")
public class BoardController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BoardController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String view = null;
        
        // URL에서 프로젝트 이름 뒷 부분의 문자열 얻어내기
        String uri = request.getRequestURI();
        String conPath = request.getContextPath();
        String com = uri.substring(conPath.length());
        
        HttpSession session = request.getSession(false);
        UserDto user = (session != null) ? (UserDto) session.getAttribute("userInfo") : null;
        boolean isAdmin = (user != null && "admin".equals(user.getId()));

        if (com.equals("/")) {
            view = "index.jsp";
        } else if (com.equals("/loginForm")) {
            view = "/sign-in/login.jsp";
        } else if (com.equals("/login")) {
            request.setCharacterEncoding("utf-8");
            String id = request.getParameter("id");
            String password = request.getParameter("password");

            // UserDao 인스턴스 생성 및 사용자 조회
            UserDao userDao = new UserDao();
            UserDto result = userDao.selectUserById(id);

            if (result != null && result.getPassword().equals(password)) {
                // 로그인 성공
                System.out.println("로그인 성공!");
                HttpSession newSession = request.getSession();
                newSession.setAttribute("userInfo", result);
                request.setAttribute("userLoggedIn", true);
                view = "index.jsp";
            } else {
                // 로그인 실패
                System.out.println("로그인 실패: 사용자 ID 또는 비밀번호가 올바르지 않습니다.");
                view = "sign-in/login.jsp";
            }
        } else if (com.equals("/logout")) {
            PrintWriter out = response.getWriter();
            if (session != null) {
                session.invalidate();
                out.print("로그아웃");
            }
            out.close();
            view = "index.jsp";
        } else if (com.equals("/registerForm")) {
            view = "/sign-in/register.jsp";
        } else if (com.equals("/listForm")) {
            String tmp = request.getParameter("page");
            int pageNo = (tmp != null && tmp.length() > 0) ? Integer.parseInt(tmp) : 1;
            request.setAttribute("msgList", new BoardService().getMsgList(pageNo));
            request.setAttribute("pgnList", new BoardService().getPagination(pageNo));
            view = "list.jsp";
        } else if (com.equals("/view")) {
            int num = Integer.parseInt(request.getParameter("num"));
            BoardDto boardDto = new BoardService().getMsg(num);
            request.setAttribute("msg", boardDto);
            view = "view.jsp";
        } else if (com.equals("/write")) {
            String tmp = request.getParameter("num");
            int num = (tmp != null && tmp.length() > 0) ? Integer.parseInt(tmp) : 0;

            BoardDto dto = new BoardDto();
            String action = "insert";

            if (num > 0) {
                dto = new BoardService().getMsgForWrite(num);
                action = "update?num=" + num;
            }

            request.setAttribute("msg", dto);
            request.setAttribute("action", action);
            view = "write.jsp";
        } else if (com.equals("/insert")) {
            request.setCharacterEncoding("utf-8");
            String writer = request.getParameter("writer");
            String title = request.getParameter("title");
            String content = request.getParameter("content");

            try {
                new BoardService().writeMsg(writer, title, content);
                view = "redirect:list";
            } catch (Exception e) {
                request.setAttribute("errorMessage", e.getMessage());
                view = "errorBack.jsp";
            }
        } else if (com.equals("/update")) {
            request.setCharacterEncoding("utf-8");
            int num = Integer.parseInt(request.getParameter("num"));
            String writer = request.getParameter("writer");
            String title = request.getParameter("title");
            String content = request.getParameter("content");

            try {
                BoardDto boardDto = new BoardService().getMsg(num);

                if (isAdmin || (user != null && user.getId().equals(boardDto.getWriter()))) {
                    new BoardService().updateMsg(writer, title, content, num);
                    view = "redirect:list";
                } else {
                    request.setAttribute("num", num);
                    request.setAttribute("action", "update");
                    view = "confirmPassword.jsp";
                }
            } catch (Exception e) {
                request.setAttribute("errorMessage", e.getMessage());
                view = "errorBack.jsp";
            }
        } else if (com.equals("/delete")) {
            int num = Integer.parseInt(request.getParameter("num"));
            BoardDto boardDto = new BoardService().getMsg(num);

            if (isAdmin || (user != null && user.getId().equals(boardDto.getWriter()))) {
                new BoardService().deleteMsg(num);
                view = "redirect:list";
            } else {
                request.setAttribute("num", num);
                request.setAttribute("action", "delete");
                view = "confirmPassword.jsp";
            }
        } else if (com.equals("/confirmPassword")) {
            String action = request.getParameter("action");
            String password = request.getParameter("password");

            UserDto loggedInUser = (UserDto) session.getAttribute("userInfo");
            if (loggedInUser != null && loggedInUser.getPassword().equals(password)) {
                int num = Integer.parseInt(request.getParameter("num"));
                if ("delete".equals(action)) {
                    new BoardService().deleteMsg(num);
                } else if ("update".equals(action)) {
                    String writer = request.getParameter("writer");
                    String title = request.getParameter("title");
                    String content = request.getParameter("content");
                    try {
						new BoardService().updateMsg(writer, title, content, num);
					} catch (Exception e) {
						e.printStackTrace();
					}
                }
                view = "redirect:list";
            } else {
                request.setAttribute("errorMessage", "비밀번호가 틀렸습니다.");
                view = "errorBack.jsp";
            }
        }

        // view에 담긴 문자열에 따라 포워딩 또는 리다이렉팅
        if (view.startsWith("redirect:")) {
            response.sendRedirect(view.substring(9));
        } else {
            request.getRequestDispatcher(view).forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
