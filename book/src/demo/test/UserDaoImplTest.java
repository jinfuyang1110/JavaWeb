package demo.test;

import demo.bean.User;
import demo.dao.impl.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Eric
 * @date 2021/1/16 19:18
 */
public class UserDaoImplTest {
    UserDaoImpl userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        User eric = userDao.queryUserByUsername("eric");
        System.out.println(eric);
    }

    @Test
    public void queryUserByUsernamePassword() {
        User eric = userDao.queryUserByUsernamePassword("eric", "2020ad");
        System.out.println(eric);
    }

    @Test
    public void saveUser() {
        User user = new User(null,"凶真","2021asd","ec@play.com");
        userDao.saveUser(user);
    }
}