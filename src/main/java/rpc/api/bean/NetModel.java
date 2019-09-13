package rpc.api.bean;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 公共网络通信模型类
 *
 * 通过序列化该类, 将客户端调用的接口, 方法, 参数类型封装,
 *
 * 然后服务端反序列化, 再通过反射, 调取相应实现类的方法!
 *
 */
public class NetModel implements Serializable {

    private static final long serialVersionUID = 3152168260407524091L;

    // 接口名
    private String className;

    // 方法命
    private String method;

    // 参数表
    private Object[] args;

    // 参数类型
    private String[] types;


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "NetModel{" +
                "className='" + className + '\'' +
                ", method='" + method + '\'' +
                ", args=" + Arrays.toString(args) +
                ", types=" + Arrays.toString(types) +
                '}';
    }
}
