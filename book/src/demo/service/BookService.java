package demo.service;

import demo.bean.Book;
import demo.bean.Page;

import java.util.List;

/**
 * @author Eric
 * @date 2021/1/18 23:01
 */
public interface BookService {
    /**
     * 添加
     *
     * @param book Book
     */
    public void addBook(Book book);

    /**
     * 删除
     *
     * @param id 编号
     */
    public void deleteById(Integer id);

    /**
     * 更新
     *
     * @param book Book
     */
    public void updateBook(Book book);

    /**
     * 查询
     *
     * @param id 编号
     * @return 结果
     */
    public Book queryBookById(Integer id);

    /**
     * 查询全部
     *
     * @return 结果集
     */
    public List<Book> queryBooks();

    /**
     * 获取Page对象
     *
     * @param pageNo   当前页码
     * @param pageSize 每页显示数量
     * @return Page对象
     */
    public Page<Book> page(int pageNo, int pageSize);

    /**
     * 根据价格区间查询结果
     *
     * @param min      左区间
     * @param max      右区间
     * @param pageNo    当前页码
     * @param pageSize  每页显示数量
     * @return 结果集
     */
    Page<Book> pageByPrice(int min, int max, int pageNo, int pageSize);
}
