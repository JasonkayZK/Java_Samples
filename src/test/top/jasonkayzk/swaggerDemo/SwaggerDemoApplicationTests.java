package top.jasonkayzk.swaggerDemo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.jasonkayzk.swaggerDemo.entity.User;
import top.jasonkayzk.swaggerDemo.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SwaggerDemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void configTest() {}

    @Test
    public void getUser() {
        User user = userService.getById(1);
        Assert.assertEquals("Jasonkay1", user.getUsername());
    }

}
