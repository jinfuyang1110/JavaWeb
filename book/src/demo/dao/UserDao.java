package demo.dao;

import demo.bean.User;

/**
 * @author Eric
 * @date 2021/1/16 18:52
 */
public interface UserDao {
    /**跟据用户名查询
     * @param username 用户名
     * @return 不存在返回null，反之亦然
     */
    public User queryUserByUsername(String username);

    /** 跟据用户名和密码查询用户
     * @param username 用户名
     * @param password 用户密码
     * @return 不存在返回null，反之亦然
     */
    public User queryUserByUsernamePassword(String username,String password);

    /** 保存用户对象
     * @param user 用户对象
     * @return 返回-1操作失败
     */
    public int saveUser(User user);
}
