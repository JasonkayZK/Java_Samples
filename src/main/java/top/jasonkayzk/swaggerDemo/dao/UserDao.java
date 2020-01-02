package top.jasonkayzk.swaggerDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.jasonkayzk.swaggerDemo.entity.User;

/**
 * 用户仓库
 *
 * @author zk
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {

}
