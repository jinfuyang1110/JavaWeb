package demo.dao.impl;

import demo.bean.Book;
import demo.dao.BaseDao;
import demo.dao.BookDao;

import java.util.List;

/**
 * @author Eric
 * @date 2021/1/18 20:36
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "INSERT INTO t_book(NAME,author,price,sales,stock,img_path)VALUES(?,?,?,?,?,?)";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "DELETE FROM t_book WHERE id=?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set NAME=?,author=?,price=?,sales=?,stock=?,img_path=? where id=?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select * from t_book where id=?";
        return queryOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select * from t_book";
        return queryForList(Book.class, sql);
    }

    @Override
    public Integer queryForTotalCount() {
        String sql = "select count(*) from t_book";
//        Object类不能直接转Integer
        Number o = (Number) querySpecialValue(sql);
        return o.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int began, int pageSize) {
        String sql = "SELECT * FROM t_book LIMIT ?,?";
        return queryForList(Book.class, sql, began, pageSize);
    }

    @Override
    public List<Book> queryForPageItemsByPrice(int min, int max, int began, int pageSize) {
        String sql = "SELECT * FROM t_book where price between ? and ? order by price LIMIT ?,?";
        return queryForList(Book.class, sql, min, max, began, pageSize);
    }

    @Override
    public Integer queryForTotalCountByPrice(int min,int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
//        Object类不能直接转Integer
        Number o = (Number) querySpecialValue(sql,min,max);
        return o.intValue();
    }
}
