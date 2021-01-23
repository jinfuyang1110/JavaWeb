package demo.service.impl;

import demo.bean.Book;
import demo.bean.Page;
import demo.dao.impl.BookDaoImpl;
import demo.service.BookService;

import java.util.List;

/**
 * @author Eric
 * @date 2021/1/18 23:07
 */
public class BookServiceImpl implements BookService {
    BookDaoImpl bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
//        设置每页显示数量
        page.setPageSize(pageSize);
//        设置总数量
        Integer integer = bookDao.queryForTotalCount();
        page.setPageTotalCount(integer);
//        设置总页码
        Integer pageTotal = integer / pageSize;
        if (integer % pageSize > 0) {
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
//        设置当前页数
        page.setPageNo(pageNo);
//        求当前页开始数据索引
        int begin = (page.getPageNo() - 1) * pageSize;
//        求当前页显示的数据
        List<Book> books = bookDao.queryForPageItems(begin, pageSize);
//        设置当前页的数据
        page.setItems(books);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int min, int max, int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
//        设置每页显示数量
        page.setPageSize(pageSize);
//        设置总数量
        Integer integer = bookDao.queryForTotalCountByPrice(min,max);
        page.setPageTotalCount(integer);
//        设置总页码
        Integer pageTotal = integer / pageSize;
        if (integer % pageSize > 0) {
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
//        设置当前页数
        page.setPageNo(pageNo);
//        求当前页开始数据索引
        int begin = (page.getPageNo() - 1) * pageSize;
//        求当前页显示的数据
        List<Book> books = bookDao.queryForPageItemsByPrice(min,max,begin, pageSize);
//        设置当前页的数据
        page.setItems(books);
        return page;
    }
}
