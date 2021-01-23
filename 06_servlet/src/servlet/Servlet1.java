package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Eric
 * @date 2021/1/16 15:13
 */

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        System.out.println("servlet1:"+name);
        request.setAttribute("key1","Eric");
//        请求转发，getRequestDispatcher（）转发路径
//        RequestDispatcher类的forward()请求内容和响应传给转发路径
        request.getRequestDispatcher("/Servlet2").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
