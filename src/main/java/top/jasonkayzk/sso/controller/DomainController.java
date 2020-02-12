package top.jasonkayzk.sso.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jasonkayzk.sso.entity.Domain;
import top.jasonkayzk.sso.service.DomainService;
import top.jasonkayzk.sso.util.entity.BaseResponse;
import top.jasonkayzk.sso.util.enums.ResponseCodeEnum;

import java.util.List;

/**
 * 子系统(域名)管理控制层
 *
 * @author zk
 */
@Slf4j
@RestController
@RequestMapping("/domain")
public class DomainController {

    private final DomainService domainService;

    public DomainController(DomainService domainService) {
        this.domainService = domainService;
    }

    @GetMapping
    public BaseResponse<List<Domain>> getAllDomain() {
        List<Domain> domainList = domainService.selectAll();
        return new BaseResponse<>(ResponseCodeEnum.SUCCESS, null, domainList);
    }

}
