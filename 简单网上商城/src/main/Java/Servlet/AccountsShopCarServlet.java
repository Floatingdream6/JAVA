package Servlet;

import DAOImpl.ShopDemoDAOImpl;
import Util.ShopInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AccountsShopCarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String list1 = request.getParameter("list");
        String list2 = request.getParameter("number");
        String[] names =list1.split(",");
        String[] numbers = list2.split(",");
        ShopDemoDAOImpl sdl = new ShopDemoDAOImpl();
        PrintWriter p = response.getWriter();
        String owner = (String) request.getSession().getAttribute("username");
        int[] number=new int[numbers.length];
        int[] stock=new int[(sdl.SerachShopCar(owner)).size()];
        for(int i=0;i<numbers.length;i++){
            number[i] = Integer.parseInt(numbers[i]);
        }
        for(int i=0;i<names.length;i++){
            stock[i]=sdl.SerachShop(names[i]).getShopnumber();
        }
        String msg = "购买失败！";
        for(int i=0;i<number.length;i++){
            if(number[i]>stock[i]){
                p.println("<script>");
                p.println("alert('"+msg+names[i]+"库存不足！"+"')");
                p.println("location.href='/ShopDemo_war_exploded/JspPage/ShopCar.jsp'");
                p.println("</script>");
                p.flush();
                break;
            }else{
                sdl.CutShopInfoNumber(names[i],number[i]);
                sdl.ShopCarClear(names[i],owner);
                response.sendRedirect("/ShopDemo_war_exploded/JspPage/PurchaseSuccessPage.jsp");
                break;
            }
        }
    }
}
