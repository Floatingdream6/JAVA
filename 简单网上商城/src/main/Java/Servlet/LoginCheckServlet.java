package Servlet;

import DAOImpl.ShopDemoDAOImpl;
import Util.User;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginCheckServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ShopDemoDAOImpl sdl = new ShopDemoDAOImpl();
        User user = sdl.SearchByName(username);
        if(user!=null&&user.getPassword().equals(password)){
            request.getRequestDispatcher("/JspPage/SuccessPage.jsp").forward(request,response);
        }else{
            PrintWriter p = response.getWriter();
            p.println("<script language='javascript'>");
            p.println("alert('用户名或密码不正确');");
            p.println("window.location.href='/ShopDemo_war_exploded/index.jsp'");
            p.println("</script>");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }
}
