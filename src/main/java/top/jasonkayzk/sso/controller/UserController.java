package top.jasonkayzk.sso.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jasonkayzk.sso.entity.User;
import top.jasonkayzk.sso.service.UserService;
import top.jasonkayzk.sso.util.entity.BaseResponse;
import top.jasonkayzk.sso.util.enums.ResponseCodeEnum;

/**
 * 用户控制器
 *
 * @author zk
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping
    public BaseResponse<Void> insertUser(User user) {
        boolean boo = userService.insertUser(user);
        if (boo) {
            return new BaseResponse<>(ResponseCodeEnum.SUCCESS, "添加成功");
        }
        return new BaseResponse<>(ResponseCodeEnum.FAIL, "用户已存在");
    }
}
