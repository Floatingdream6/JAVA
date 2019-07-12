package Servlet;

import DAOImpl.ShopDemoDAOImpl;
import Util.ShopInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddShopCarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String shopname = request.getParameter("shopname");
        String owner = (String)request.getSession().getAttribute("username");
        ShopDemoDAOImpl sdl = new ShopDemoDAOImpl();
        if(sdl.SearchShopcar(shopname,owner)==1){
            sdl.UpdateShopCar(shopname,owner);
        }else{
            ShopInfo shopinfo = new ShopDemoDAOImpl().SerachShop(shopname);
            sdl.AddShopCar(shopinfo,owner);
        }
        response.sendRedirect("/ShopDemo_war_exploded/JspPage/SuccessPage.jsp");
    }
}
