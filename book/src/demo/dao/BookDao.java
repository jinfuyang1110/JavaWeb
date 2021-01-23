package demo.dao;

import demo.bean.Book;

import java.util.List;

/**
 * @author Eric
 * @date 2021/1/18 20:30
 */
public interface BookDao {
    /**
     * 添加
     *
     * @param book 书对象
     * @return -1添加失败其他成功
     */
    int addBook(Book book);

    /**
     * 跟据编号删除
     *
     * @param id 编号
     * @return -1失败其他成功
     */
    int deleteBookById(Integer id);

    /**
     * 更新
     *
     * @param book 书对象
     * @return -1更新失败，反之成功
     */
    int updateBook(Book book);

    /**
     * 查询一个
     *
     * @param id 编号
     * @return Book
     */
    Book queryBookById(Integer id);

    /**查询所有
     * @return 结果集
     */
    List<Book> queryBooks();

    /**查询总数据量
     * @return 总数
     */
    Integer queryForTotalCount();

    /**查询每页显示内容
     * @param began    开始索引
     * @param pageSize 页容量
     * @return 每页显示的数据
     */
    List<Book> queryForPageItems(int began, int pageSize);

    /** 根据价格区间查询结果
     * @param min 左区间
     * @param max 右区间
     * @param began 开始
     * @param pageSize 结束
     * @return 结果集
     */
    List<Book> queryForPageItemsByPrice(int min , int max,int began, int pageSize);

    /**根据价格区间查询
     * @return 总数
     */
    Integer queryForTotalCountByPrice(int min,int max);
}
