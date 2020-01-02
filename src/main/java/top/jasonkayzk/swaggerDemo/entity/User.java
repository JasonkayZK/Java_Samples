package top.jasonkayzk.swaggerDemo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

/**
 * @author zk
 */
@Data
@Entity(name = "user")
@ApiModel(description = "用户Model")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Null(message = "id必须为空")
    @ApiModelProperty(value = "User ID", name = "id")
    private Integer id;


    @Column
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名", name = "username", required = true, example = "Jasonkay")
    private String username;

    @Column
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码", name = "password", required = true, example = "123456")
    private String password;
}
