package top.jasonkayzk.swaggerDemo.constant;

import static top.jasonkayzk.swaggerDemo.common.ResponseResult.ResponseParam;
import static top.jasonkayzk.swaggerDemo.common.ResponseResult.ResponseParam.buildParam;

/**
 * Response Code
 *
 * @author zk
 */
public enum ResponseCode {

    SUCCESS(buildParam(0, "SUCCESS"));

    public final ResponseParam PARAM;

    ResponseCode(ResponseParam param) {
        this.PARAM = param;
    }

    public int getCode() {
        return this.PARAM.getCode();
    }

    public String getMsg() {
        return this.PARAM.getMsg();
    }
}
