package demo.service;

import demo.bean.Book;
import demo.bean.Cart;
import demo.bean.CartItem;
import demo.service.impl.BookServiceImpl;
import demo.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author Eric
 * @date 2021/1/22 11:53
 */
@WebServlet(name = "CarServlet", value = "/CarServlet")
public class CarServlet extends BaseServlet {
    BookServiceImpl bookService = new BookServiceImpl();

    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        CartItem cartItem=new CartItem(id,book.getName(),1,book.getPrice(),book.getPrice());
        Cart car=(Cart) request.getSession().getAttribute("cart");
        if (car==null){
             car=new Cart();
             car.addItem(cartItem);
             request.getSession().setAttribute("cart",car);
        }
        car.addItem(cartItem);
        request.getSession().setAttribute("lastName",cartItem.getName());
//        重新定向
        response.sendRedirect(request.getHeader("Referer"));
    }
    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        int count = WebUtils.parseInt(request.getParameter("count"), 1);
        Cart car=(Cart) request.getSession().getAttribute("cart");
        if (count<1){
            car.deleteItem(id);
        }else {
            car.updateCount(id,count);
        }
//        重新定向
        response.sendRedirect(request.getHeader("Referer"));
    }
    protected void clear(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        Cart car=(Cart) request.getSession().getAttribute("cart");
        car.clear();
//        重新定向
        response.sendRedirect(request.getHeader("Referer"));
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cart car=(Cart) request.getSession().getAttribute("cart");
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        car.deleteItem(id);
//        重新定向
        response.sendRedirect(request.getHeader("Referer"));
    }
}
