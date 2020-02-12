package top.jasonkayzk.sso.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 子系统（域名）管理
 *
 * @author zk
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_domain")
public class Domain implements Serializable {

    private static final long serialVersionUID = -1485357379588239539L;

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    /**
     * 域名
     */
    private String domain;

    /**
     * 域名所在系统信息描述
     */
    private String description;

    /**
     * 备注
     */
    private String remark;

}
