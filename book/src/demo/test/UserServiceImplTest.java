package demo.test;

import demo.bean.User;
import demo.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author Eric
 * @date 2021/1/16 20:19
 */
public class UserServiceImplTest {
    UserServiceImpl userService = new UserServiceImpl();

    @Test
    public void register() {
        userService.register(new User(null, "petter3", "2021ad", "p@128.com"));
    }

    @Test
    public void login() {
        if (userService.login(new User(null,"eri","2020ad",null))==null){
            System.out.println("false");
        }else {
            System.out.println("true");
        }
    }

    @Test
    public void existUsername() {
       if(userService.existUsername("eri")){
           System.out.println("用户名已经存在");
       }else {
           System.out.println("用户名可用");
       }
    }
}