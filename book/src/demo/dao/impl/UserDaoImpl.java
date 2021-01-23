package demo.dao.impl;

import demo.bean.User;
import demo.dao.BaseDao;
import demo.dao.UserDao;

/**
 * @author Eric
 * @date 2021/1/16 19:03
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql="SELECT id,`username`,`password`,email FROM t_user WHERE username=?";
        return queryOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernamePassword(String username, String password) {
        String sql="SELECT id,`username`,`password`,email FROM t_user WHERE username=? and password=?";
        return queryOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql="insert INTO t_user(username,`password`,email)VALUES(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
