package top.jasonkayzk.sso.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.jasonkayzk.sso.entity.User;
import top.jasonkayzk.sso.mapper.UserMapper;
import top.jasonkayzk.sso.service.UserService;
import top.jasonkayzk.sso.util.RandomUtil;
import top.jasonkayzk.sso.util.SecurityUtil;

import java.time.LocalDateTime;



/**
 * @author zk
 */
@Slf4j
@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    @Transactional
    public boolean insertUser(User user) {
        user.setSecret(StringUtils.isEmpty(user.getSecret()) ? RandomUtil.randomSecret(16) : user.getSecret())
                .setLastLoginTime(LocalDateTime.now());
        user.setPassword(SecurityUtil.encrypt(user.getPassword(), user.getSecret()));

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 存在相同用户名
        if (this.baseMapper.selectOne(queryWrapper.lambda().eq(User::getUsername, user.getUsername())) != null) {
            return false;
        }

        return this.baseMapper.insert(user) > 0;
    }

    @Override
    public User login(String username, String password) {
        User user = this.baseMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getUsername, username));

        if (user != null) {
            String encryptPassword = SecurityUtil.encrypt(password, user.getSecret());
            if (encryptPassword != null && encryptPassword.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }

}
