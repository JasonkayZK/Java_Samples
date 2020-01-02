package top.jasonkayzk.swaggerDemo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import top.jasonkayzk.swaggerDemo.dao.UserDao;
import top.jasonkayzk.swaggerDemo.entity.User;
import top.jasonkayzk.swaggerDemo.service.UserService;

/**
 * 用户Service实现类
 *
 * @author zk
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getById(Integer id) {
        User user = userDao.findById(id).orElse(null);
        LOGGER.debug("ID为：{}，查询用户结果为：{}", id, user);
        return user;
    }

    @Override
    public User addUser(User user) {
        return userDao.save(user);
    }
}
