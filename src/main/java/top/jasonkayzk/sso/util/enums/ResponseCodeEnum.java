package top.jasonkayzk.sso.util.enums;

import lombok.Getter;

/**
 * 统一返回响应状态代码
 *
 * @author zk
 */
public enum ResponseCodeEnum {

    /**
     * 成功
     */
    SUCCESS(200, "成功"),

    /**
     * 失败
     */
    FAIL(400, "失败"),

    /**
     * 资源不存在
     */
    NOTFOUND(404, "请求资源不存在"),

    /**
     * 未认证
     */
    UNAUTHORIZED(401, "未认证"),

    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(500, "服务器内部错误");

    @Getter
    private int code;

    @Getter
    private String msg;

    ResponseCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
