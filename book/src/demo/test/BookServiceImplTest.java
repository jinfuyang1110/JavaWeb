package demo.test;

import demo.bean.Book;
import demo.bean.Page;
import demo.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Eric
 * @date 2021/1/18 23:11
 */
public class BookServiceImplTest {
    BookServiceImpl bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"沃德天","你怎么",new BigDecimal(1998),998,1,"null"));
    }

    @Test
    public void deleteById() {
        bookService.deleteById(24);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(23,"沃德天","你怎么",new BigDecimal(1998),998,1,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(23));
    }

    @Test
    public void queryBooks() {
        bookService.queryBooks().forEach(System.out::println);
    }
    @Test
    public void page(){
        Page<Book> page = bookService.page(0, 4);
        System.out.println(page);
    }
    @Test
    public void pageByPrice(){
        Page<Book> bookPage = bookService.pageByPrice(10, 50, 0, 4);
        System.out.println(bookPage);
    }
}