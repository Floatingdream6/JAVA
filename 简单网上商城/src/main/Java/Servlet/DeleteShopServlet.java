package Servlet;

import DAOImpl.ShopDemoDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteShopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String shopname = request.getParameter("shopname");
        int n = new ShopDemoDAOImpl().DeleteShop(shopname);
        PrintWriter p =response.getWriter();
        if(n==1){
            p.println("<script>");
            p.println("alert('删除成功!')");
            p.println("location.href='/ShopDemo_war_exploded/JspPage/AdminPersonCenterPage.jsp'");
            p.println("</script>");
            p.flush();
        }else{
            p.println("<script>");
            p.println("alert('删除失败!')");
            p.println("</script>");
            p.flush();
        }
    }
}
