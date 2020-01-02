package top.jasonkayzk.swaggerDemo.service;

import top.jasonkayzk.swaggerDemo.entity.User;

/**
 * 用户Service接口
 *
 * @author zk
 */
public interface UserService {

    /**
     * 通过ID获取用户对象
     *
     * @param id 用户ID
     * @return 用户对象
     */
    User getById(Integer id);

    /**
     * 创建用户
     *
     * @param user 用户对象
     * @return 保存后的用户对象
     */
    User addUser(User user);
}
