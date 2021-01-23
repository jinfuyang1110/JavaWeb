package demo.service;

import demo.bean.User;

/**
 * @author Eric
 * @date 2021/1/16 20:11
 */
public interface UserService {
    /**注册
     * @param user 用户对象
     */
    public void register(User user);

    /**登录
     * @param user 用户对象
     * @return 返回null，登录失败，返之登录成功
     */
    public User login(User user);

    /**检查用户名是否已经存在
     * @param username 用户名
     * @return true存在，false用户名可用
     */
    public boolean existUsername(String username);
}
