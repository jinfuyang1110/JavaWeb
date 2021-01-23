package demo.test;

import demo.bean.Book;
import demo.dao.impl.BookDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Eric
 * @date 2021/1/18 20:59
 */
public class BookDaoImplTest {
    BookDaoImpl bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        Book book = new Book(null, "我怎么了", "yjf", new BigDecimal(2368), 12800, 1, "256");
        bookDao.addBook(book);
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        Book book = new Book(23, "失格", "yjf", new BigDecimal(99999), 12800, 1, "256");
        bookDao.updateBook(book);
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(23);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        books.forEach(System.out::println);
    }
    @Test
    public void queryForTotalCount(){
        Integer integer = bookDao.queryForTotalCount();
        System.out.println(integer);
    }
    @Test
    public void queryForPageItems(){
        bookDao.queryForPageItems(4,4).forEach(System.out::println);
    }
    @Test
    public void queryForPageItemsByPrice(){
        bookDao.queryForPageItemsByPrice(10,50,0,4).forEach(System.out::println);
    }
}