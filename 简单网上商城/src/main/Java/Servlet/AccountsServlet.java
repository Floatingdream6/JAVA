package Servlet;

import DAOImpl.ShopDemoDAOImpl;
import Util.ShopInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String shopname = request.getParameter("shopname");
        int shopnumber =Integer.parseInt(request.getParameter("shopnumber"));
        String owner = (String)request.getSession().getAttribute("username");
        ShopDemoDAOImpl sdl = new ShopDemoDAOImpl();
        ShopInfo shopinfo = sdl.SerachShop(shopname);
        sdl.AddAccountsInfo(shopinfo,owner);
        response.sendRedirect("/ShopDemo_war_exploded/JspPage/AccountsPage.jsp");
    }
}
