package servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author Eric
 * @date 2021/1/16 10:26
 */
public class HelloServlet02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get");
        System.out.println("ip:"+request.getRemoteHost());
        System.out.println("username:"+request.getParameter("username"));
        System.out.println("password:"+request.getParameter("password"));
        System.out.println("兴趣爱好："+ Arrays.asList(request.getParameterValues("hobby")));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置请求体的字符集，解决乱码问题
        request.setCharacterEncoding("UTF-8");
        System.out.println("post");
        System.out.println("ip:"+request.getRemoteHost());
        System.out.println("username:"+request.getParameter("username"));
        System.out.println("password:"+request.getParameter("password"));
        System.out.println("兴趣爱好："+ Arrays.asList(request.getParameterValues("hobby")));
    }
}
