package demo.service.impl;

import demo.bean.User;
import demo.dao.impl.UserDaoImpl;
import demo.service.UserService;

/**
 * @author Eric
 * @date 2021/1/16 20:14
 */
public class UserServiceImpl implements UserService {
    UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public void register(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernamePassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        return userDao.queryUserByUsername(username) != null;
    }
}
