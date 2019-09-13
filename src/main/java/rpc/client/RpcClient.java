package rpc.client;

import rpc.client.proxy.ProxyFactory;
import rpc.api.util.SerializeUtils;
import rpc.server.service.HelloService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * RPC客户端, 使用Socket与服务端通信
 *
 */
public class RpcClient {

    public static Object send(byte[] bs) {
        Socket socket = null;
        OutputStream outputStream = null;
        InputStream in = null;

        try {
            socket = new Socket("127.0.0.1", 9999);

            outputStream = socket.getOutputStream();

            outputStream.write(bs);

            in = socket.getInputStream();
            byte[] buf = new byte[1024];
            in.read(buf);

            Object formatData = SerializeUtils.deserialize(buf);

            return formatData;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        throw new RuntimeException("Fail to send data!");
    }

    /**
     * 运行main, 开启客户端
     *
     * @param args
     */
    public static void main(String[] args) {
        HelloService helloService = ProxyFactory.getInstance(HelloService.class);
        System.out.println("say: " + helloService.sayHello("zhangsan"));
        System.out.println("Person: " + helloService.getPerson("zhangsan"));
    }

}
