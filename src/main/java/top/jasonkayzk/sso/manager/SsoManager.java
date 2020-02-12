package top.jasonkayzk.sso.manager;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jasonkayzk.sso.entity.Domain;
import top.jasonkayzk.sso.entity.User;
import top.jasonkayzk.sso.service.DomainService;
import top.jasonkayzk.sso.service.UserService;
import top.jasonkayzk.sso.util.JwtUtil;
import top.jasonkayzk.sso.util.entity.BaseResponse;
import top.jasonkayzk.sso.util.enums.ResponseCodeEnum;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单点登录控制器
 *
 * @author zk
 */
@Slf4j
@RestController
@RequestMapping("/sso")
public class SsoManager {

    private final DomainService domainService;

    private final UserService userService;

    public SsoManager(DomainService domainService, UserService userService) {
        this.domainService = domainService;
        this.userService = userService;
    }

    public static final String COOKIE_NAME = "auth";

    /**
     * 统一处理login请求
     *
     * @param username 用户名
     * @param password 密码
     */
    @PostMapping
    public BaseResponse<Map<String, Object>> checkLogin(String username, String password) {
        log.info("统一登录校验");

        User user = userService.login(username, password);
        if (user != null) {
            // 封装参数
            Map<String, Object> param = new HashMap<>(16);
            List<Domain> domains = domainService.selectAll();
            List<String> domainUrl = new ArrayList<>(domains.size());

            domains.forEach(domain -> domainUrl.add(domain.getDomain() + "/addCookie"));

            // 生成jwt
            String cookieValue = JwtUtil.creatJwt(user.toString());

            param.put("cookieUrl", domainUrl);
            param.put("COOKIE_NAME", SsoManager.COOKIE_NAME);
            param.put("cookieValue", cookieValue);
            return new BaseResponse<>(ResponseCodeEnum.SUCCESS, param);
        }
        return new BaseResponse<>(ResponseCodeEnum.UNAUTHORIZED, "账号或密码错误");
    }

    /**
     * 添加需要清除的cookie, 返回jsonp
     */
    @GetMapping("/logout")
    public String loginOut(HttpServletRequest request) {
        String callbackFunction = request.getParameter("callback");
        log.info("start clear");
        List<Domain> domains = domainService.selectAll();
        List<String> domainUrl = new ArrayList<>(domains.size());
        domains.forEach(domain -> domainUrl.add(domain.getDomain() + "/clear"));

        String resultMsg = JSON.toJSONString(domainUrl);
        return callbackFunction + "(" + resultMsg + ")";
    }

    /**
     * 验证cookie是否通过
     *
     * @param COOKIE_NAME  cookie名称
     * @param cookieValue cookie内容
     * @return 是否认证成功
     */
    @GetMapping("/authCookies")
    public boolean checkAuthCookies(String COOKIE_NAME, String cookieValue) {
        boolean isUpdate = JwtUtil.deleteJwt(cookieValue);
        if (SsoManager.COOKIE_NAME.equals(COOKIE_NAME)) {
            if (isUpdate) {
                log.info("cookie验证通过");
                return true;
            }
        }
        return false;
    }

}
