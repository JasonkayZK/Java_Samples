package top.jasonkayzk.sso.util.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import top.jasonkayzk.sso.util.enums.ResponseCodeEnum;

/**
 * 统一响应结果
 *
 * @author zk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BaseResponse<T> {

    /**
     * 返回枚举代码
     */
    private ResponseCodeEnum responseCodeEnum;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回响应数据
     */
    private T data;

    public BaseResponse(ResponseCodeEnum responseCodeEnum, String message) {
        this.responseCodeEnum = responseCodeEnum;
        this.message = message;
    }

    public BaseResponse(ResponseCodeEnum responseCodeEnum, T data) {
        this.responseCodeEnum = responseCodeEnum;
        this.data = data;
    }

}
