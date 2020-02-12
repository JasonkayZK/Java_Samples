package top.jasonkayzk.sso.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.jasonkayzk.sso.entity.User;

/**
 * 用户业务层接口
 *
 * @author zk
 */
public interface UserService extends IService<User> {

    /**
     * 添加用户
     *
     * @param user 用户信息
     *
     * @return 当添加成功时返回true
     */
    boolean insertUser(User user);

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 如果用户存在返回user，反之为null
     */
    User login(String username, String password);

}
