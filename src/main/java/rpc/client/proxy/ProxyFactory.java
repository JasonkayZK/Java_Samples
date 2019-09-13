package rpc.client.proxy;

import rpc.api.bean.NetModel;
import rpc.api.util.SerializeUtils;
import rpc.client.RpcClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    private static InvocationHandler handler = (proxy, method, args) -> {
        NetModel netModel = new NetModel();

        Class<?>[] classes = proxy.getClass().getInterfaces();
        String className = classes[0].getName();

        netModel.setClassName(className);
        netModel.setArgs(args);
        netModel.setMethod(method.getName());
        String[] types = null;

        if (args != null) {
            types = new String[args.length];
            for (int i = 0; i < types.length; i++) {
                types[i] = args[i].getClass().getName();
            }
        }
        netModel.setTypes(types);

        byte[] bytes = SerializeUtils.serialize(netModel);

        return RpcClient.send(bytes);
    };

    @SuppressWarnings("unchecked")
    public static <T> T getInstance(Class<T> serviceClass) {
        return (T) Proxy.newProxyInstance(serviceClass.getClassLoader(), new Class[] {serviceClass}, handler);
    }
}
