package demo.service;
import com.google.gson.Gson;
import demo.bean.User;
import demo.service.impl.UserServiceImpl;
import demo.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author Eric
 * @date 2021/1/18 15:29
 */
@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends BaseServlet {
    UserServiceImpl userService = new UserServiceImpl();

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());
        if (userService.login(user) == null) {
            request.setAttribute("errorMsg", "用户名或密码错误");
//            回显用户名
            request.setAttribute("username", user.getUsername());
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
//            保存用户登录的信息到session域中
            request.getSession().setAttribute("user",user);
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }
    }

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());
        String code = request.getParameter("code");
        String repwd = request.getParameter("repwd");
//        获取session中的验证码
        String token = (String)request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
//        删除验证码避免重复使用
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
//        验证码是否正确
        if (token.equalsIgnoreCase(code)) {
//            用户名是否存在
            if (userService.existUsername(user.getUsername())) {
                request.setAttribute("errorMsg", "用户名已经存在");
//                回显信息
                request.setAttribute("password", user.getPassword());
                request.setAttribute("repwd", repwd);
                request.setAttribute("email", user.getEmail());
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            } else {
//                用户信息注入数据库
                userService.register(user);
                System.out.println("ok");
//                跳转登录成功界面
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorMsg", "验证码错误");
            System.out.println("验证码错误");
//            回显用户信息
            request.setAttribute("username", user.getUsername());
            request.setAttribute("password", user.getPassword());
            request.setAttribute("repwd", repwd);
            request.setAttribute("email", user.getEmail());
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        销毁session域
        request.getSession().invalidate();
//        重新定向
        response.sendRedirect(request.getContextPath());
    }
    protected void ajaxExistsUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        boolean existUsername = userService.existUsername(username);
        Map<String,Object> resultMap=new HashMap<>(16);
        resultMap.put("existUsername",existUsername);
        Gson gson = new Gson();
        String s = gson.toJson(resultMap);
        response.getWriter().write(s);
    }
}
