package top.jasonkayzk.redissession.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author zk
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = -5838756847926488707L;

    private Long id;

    private String username;

    private String password;

    public static User defaultUser() {
        return User.builder().id(1L).username("zk").password("123456").build();
    }

}
