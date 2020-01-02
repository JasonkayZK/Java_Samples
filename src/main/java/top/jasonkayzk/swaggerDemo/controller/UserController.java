package top.jasonkayzk.swaggerDemo.controller;

import io.swagger.annotations.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.jasonkayzk.swaggerDemo.common.ResponseResult;
import top.jasonkayzk.swaggerDemo.entity.User;
import top.jasonkayzk.swaggerDemo.service.UserService;

/**
 * 用户控制器
 *
 * @author zk
 */
@RestController
@RequestMapping(value = "/user", produces = "application/json")
// @Deprecated @Api(value = "User", tags = {"User"}, description = "用户相关")
@Api(value = "User", tags = {"User", "用户相关"})
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "使用ID查询用户")
    @ApiImplicitParams({
        @ApiImplicitParam(value = "ID", name = "id", dataType = "int",
            paramType = "path", required = true, defaultValue = "1")
    })
    @ApiResponses({
        @ApiResponse(code = 400, message = "请求参数有误"),
        @ApiResponse(code = 401, message = "未授权"),
        @ApiResponse(code = 403, message = "禁止访问"),
        @ApiResponse(code = 404, message = "请求路径不存在"),
        @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<User> getById(@PathVariable("id") Integer id) {
        User user = userService.getById(id);
        return ResponseResult.successWithData(user);
    }

    @PostMapping
    @ApiOperation(value = "创建用户")
    @ApiResponses({
        @ApiResponse(code = 400, message = "请求参数有误"),
        @ApiResponse(code = 401, message = "未授权"),
        @ApiResponse(code = 403, message = "禁止访问"),
        @ApiResponse(code = 404, message = "请求路径不存在"),
        @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<User> addUser(@Validated @RequestBody User user) {
        User dbUser = userService.addUser(user);
        return ResponseResult.successWithData(dbUser);
    }

}
