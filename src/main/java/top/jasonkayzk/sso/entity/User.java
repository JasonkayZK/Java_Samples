package top.jasonkayzk.sso.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户实体类
 *
 * @author zk
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = -1479978498090674766L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;

    private String secret;

    private LocalDateTime createTime;

    private LocalDateTime lastLoginTime;

}
