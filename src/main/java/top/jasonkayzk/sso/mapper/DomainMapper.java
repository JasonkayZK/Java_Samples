package top.jasonkayzk.sso.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.jasonkayzk.sso.entity.Domain;

/**
 * 子系统（域名）管理数据接口层
 *
 * @author zk
 */
@Mapper
public interface DomainMapper extends BaseMapper<Domain> {
}
