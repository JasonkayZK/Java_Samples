package top.jasonkayzk.redissession.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jasonkayzk.redissession.entity.User;

import javax.servlet.http.HttpServletRequest;

import static top.jasonkayzk.redissession.entity.User.defaultUser;

/**
 * @author zk
 */
@Controller
public class IndexController {

    @ResponseBody
    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            return "index message";
        }
        return "please login first";
    }

    @ResponseBody
    @RequestMapping("/login")
    public String login(HttpServletRequest request, String username, String password) {
        User userFromDB = defaultUser();
        if (username.equals(userFromDB.getUsername())) {
            if (password.equals(userFromDB.getPassword())) {
                request.getSession().setAttribute("user", userFromDB);
                return "login success";
            }
        }
        return "login failure";
    }

    @ResponseBody
    @RequestMapping("/logout")
    public String login(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "has already logout";
    }

}
