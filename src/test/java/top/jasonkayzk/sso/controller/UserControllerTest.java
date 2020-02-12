package top.jasonkayzk.sso.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.jasonkayzk.sso.SsoApplication;
import top.jasonkayzk.sso.entity.User;
import top.jasonkayzk.sso.service.UserService;

import java.time.LocalDateTime;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SsoApplication.class)
public class UserControllerTest {

    @Autowired
    private UserService userService;


    @Test
    public void insertUser() {
        User user = new User()
                .setUsername("zk")
                .setPassword("123456")
                .setCreateTime(LocalDateTime.now());

        userService.insertUser(user);
    }

}