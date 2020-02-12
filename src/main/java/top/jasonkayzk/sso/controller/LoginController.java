package top.jasonkayzk.sso.controller;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import top.jasonkayzk.sso.manager.SsoManager;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录控制器
 *
 * @author zk
 */
@Slf4j
@RestController
public class LoginController {

    private final SsoManager ssoManager;

    public LoginController(SsoManager ssoManager) {
        this.ssoManager = ssoManager;
    }

    /**
     * @return 响应界面：login/index
     */
    @GetMapping("/ssoCheck")
    public ModelAndView checkCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                // 统一登录cookie为COOKIE_NAME, 如果存在就认证
                if (SsoManager.COOKIE_NAME.equals(cookie.getName())) {
                    log.info("cookie存在，开始验证");
                    boolean authBoo = ssoManager.checkAuthCookies(cookie.getName(), cookie.getValue());
                    if (authBoo) {
                        log.info("验证通过");
                        return new ModelAndView("public/index");
                    }
                    break;
                }
            }
        }
        return new ModelAndView("index");
    }

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return index/login
     */
    @PostMapping("/login")
    public ModelAndView doLogin(String username, String password) {
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
            var result = ssoManager.checkLogin(username, password);
            int isLogin = result.getResponseCodeEnum().getCode();
            if (isLogin == 1) {
                var param = result.getData();
                return new ModelAndView("public/index", "sendparam", param);
            }
        }
        return new ModelAndView("index");
    }

    /**
     * 退出到登录界面
     *
     * @return 登录界面
     */
    @GetMapping("/logout")
    public ModelAndView loginOut() {
        return new ModelAndView("index");
    }

    /**
     * 清除掉cookie
     *
     * @param request  请求
     * @param response 响应
     */
    @GetMapping("/clear")
    public void clear(HttpServletRequest request, HttpServletResponse response) {
        // 获得域名
        log.info("clear掉ip为: {} 的cookie", request.getRemoteHost());

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (SsoManager.COOKIE_NAME.equals(cookie.getName())) {
                cookie.setValue(null);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }

    /**
     * @param cookieName  cookie名称
     * @param cookieValue cookie值
     * @param response    响应
     */
    @GetMapping("/addCookie")
    public void addCookies(String cookieName, String cookieValue, HttpServletResponse response) {
        log.info("添加cookie");
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setPath("/");
        cookie.setMaxAge(3600);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }

}
