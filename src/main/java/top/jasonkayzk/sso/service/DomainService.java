package top.jasonkayzk.sso.service;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;
import top.jasonkayzk.sso.entity.Domain;

import java.util.List;

/**
 * 子系统（域名）管理业务层接口
 *
 * @author zk
 */
public interface DomainService extends IService<Domain> {

    /**
     * 查询全部域名
     *
     * @return 域名list
     */
    List<Domain> selectAll();

}
