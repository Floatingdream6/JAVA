package Servlet;

import DAOImpl.ShopDemoDAOImpl;
import Util.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        PrintWriter p = response.getWriter();
        try {
            if (new ShopDemoDAOImpl().AddUser(new User(name, id, password)) == 1) {
                p.println("<script language='javascript'>");
                p.println("alert('注册成功！');");
                p.println("window.location.href='/ShopDemo_war_exploded/index.jsp'");
                p.println("</script>");
                p.flush();
            } else {
                p.println("<script language='javascript'>");
                p.println("alert('该用户已存在！');");
                p.println("window.location.href='/ShopDemo_war_exploded/JspPage/LoGonPage.jsp'");
                p.println("</script>");
                p.flush();
            }
        }catch(Exception e){
        }
    }
}
