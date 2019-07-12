package Servlet;

import DAOImpl.ShopDemoDAOImpl;
import Util.ShopInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class PageShopCarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset=utf-8");
        int num = Integer.parseInt(request.getParameter("num"));
        int flag = Integer.parseInt(request.getParameter("flag"));
        System.out.println(flag);
        String owner = (String)request.getSession().getAttribute("username");
        ShopDemoDAOImpl sdl = new ShopDemoDAOImpl();
        ArrayList<ShopInfo> list = sdl.SerachShopCar(owner);
        String shopname = list.get(num-1).getShopname();
        if(flag==1) {
            sdl.UpdateShopCar(shopname,owner);
        }else{
            sdl.UpdatePageShopCar(shopname,owner);
        }
        response.sendRedirect("/ShopDemo_war_exploded/JspPage/ShopCar.jsp");
    }
}
