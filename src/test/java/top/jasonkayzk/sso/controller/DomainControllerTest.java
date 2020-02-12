package top.jasonkayzk.sso.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.jasonkayzk.sso.SsoApplication;
import top.jasonkayzk.sso.service.DomainService;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SsoApplication.class)
public class DomainControllerTest {

    @Autowired
    private DomainService domainService;

    @Test
    public void getAllDomain() {
        System.out.println(domainService.selectAll());
    }
}