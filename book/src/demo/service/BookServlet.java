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
import java.util.List;

/**
 * @author Eric
 * @date 2021/1/20 11:22
 */
@WebServlet(name = "BookServlet", value = "/manager/BookServlet")
public class BookServlet extends BaseServlet {
    BookServiceImpl bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        获取请求信息封装到Book对象中
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
//        添加到数据库
        bookService.addBook(book);
        String pageTotal = req.getParameter("pageTotal");
        int i = WebUtils.parseInt(pageTotal, 1);
        //        请求重新定向，显示添加结果
        resp.sendRedirect(req.getContextPath() + "/manager/BookServlet?action=page&pageNo="+i+1);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        bookService.deleteById(Integer.parseInt(id));
        String pageNo = req.getParameter("pageNo");
        int i = WebUtils.parseInt(pageNo, 1);
        //        请求重新定向，显示添加结果
        resp.sendRedirect(req.getContextPath() + "/manager/BookServlet?action=page&pageNo="+i);
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Book book = bookService.queryBookById(Integer.parseInt(id));
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        String pageNo = req.getParameter("pageNo");
        int i = WebUtils.parseInt(pageNo, 1);
        //        请求重新定向，显示添加结果
        resp.sendRedirect(req.getContextPath() + "/manager/BookServlet?action=page&pageNo="+i);

    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        查询全部图书
        List<Book> books = bookService.queryBooks();
//        将图书保存到request域中
        req.setAttribute("books", books);
//        请求转发到/pages/manager/book_manager.jsp页面中
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);

    }
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取请求的参数pageNo和pageSize
        int pageNo=WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
//        2.调用BookService.page（）：Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
//        2.5设置url
        page.setUrl("manager/BookServlet?action=page");
//        3.保存Page对象到Request域中
        req.setAttribute("page",page);
//        4.请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
}
