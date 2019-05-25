package Servlet;

import DAOImpl.ShopDemoDAOImpl;
import Util.Address;
import Util.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddaddressServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        ShopDemoDAOImpl sdl = new ShopDemoDAOImpl();
        String name = request.getParameter("name");
        int telphone = Integer.parseInt(request.getParameter("tel"));
        int zopcode = Integer.parseInt(request.getParameter("zopcode"));
        String adress = request.getParameter("address");
        String shopname =(String) request.getAttribute("shopname");
        User user =(User) request.getSession().getAttribute("user");
        Address ads = new Address(name,telphone,adress,zopcode,"否",user.getUsername());
        sdl.AddAddress(ads);
        response.sendRedirect("/ShopDemo_war_exploded/JspPage/AddressPage.jsp");
    }
}
