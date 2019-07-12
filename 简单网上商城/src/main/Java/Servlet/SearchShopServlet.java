package Servlet;

import Util.ShopInfo;
import DAOImpl.ShopDemoDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SearchShopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String message = request.getParameter("message");
        ArrayList<ShopInfo> list = new ShopDemoDAOImpl().SearchShopinfo(message);
        PrintWriter p = response.getWriter();
        HttpSession session = request.getSession();
        if(list.size()==0){
            p.println("<script language='javascript'>");
            p.println("alert('查询无结果！');");
            p.println("window.history.back(-1)");
            p.println("</script>");
        }else{
            session.setAttribute("message",message);
            //session.setMaxInactiveInterval(3600);
            if(session.getAttribute("username")==null){
                response.sendRedirect("/ShopDemo_war_exploded/JspPage/SearchResultPageNotIn.jsp");
            }else{
                response.sendRedirect("/ShopDemo_war_exploded/JspPage/SearchResultPage.jsp");
            }
        }
    }
}
