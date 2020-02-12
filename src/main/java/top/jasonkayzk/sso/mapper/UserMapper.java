package top.jasonkayzk.sso.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.jasonkayzk.sso.entity.User;

/**
 * 用户数据接口层
 *
 * @author zk
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
