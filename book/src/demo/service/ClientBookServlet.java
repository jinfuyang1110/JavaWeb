package demo.service;

import demo.bean.Book;
import demo.bean.Page;
import demo.service.impl.BookServiceImpl;
import demo.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Eric
 * @date 2021/1/21 19:42
 */
@WebServlet(name = "ClientBookServlet", value = "/ClientBookServlet")
public class ClientBookServlet extends BaseServlet {
    private final BookServiceImpl bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
//        2.调用BookService.page（）：Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
//         2.5设置url
        page.setUrl("ClientBookServlet?action=page");
//         3.保存Page对象到Request域中
        req.setAttribute("page", page);
//        4.请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取min和max
        int min=WebUtils.parseInt(req.getParameter("min"),0);
        int max=WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);
//        1.获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
//        2.调用BookService.page（）：Page对象
        Page<Book> page = bookService.pageByPrice(min,max,pageNo,pageSize);
//         2.5设置url
        StringBuffer sb=new StringBuffer("ClientBookServlet?action=pageByPrice");
        if (req.getParameter("min")!=null){
            sb.append("&min=").append(req.getParameter("min"));
        }
        if (req.getParameter("max")!=null){
            sb.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(sb.toString());
//         3.保存Page对象到Request域中
        req.setAttribute("page", page);
//        4.请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
