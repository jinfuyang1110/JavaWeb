package servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
/**
 * @author Eric
 * @date 2021/1/16 10:26
 */
public class HelloServlet02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post");
    }
}
