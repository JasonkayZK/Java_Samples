package nio.basic.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class Client {

    public static void main(String[] args) throws IOException {
        // 打开socket通道
        SocketChannel socketChannel = SocketChannel.open();
        // 设置为非阻塞方式
        socketChannel.configureBlocking(false);
        // 通过open()方法找到Selector
        Selector selector = Selector.open();
        // 注册连接服务端socket动作
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        // 连接
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8848));

        /* 数据缓冲区 */
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (true) {
            if ((selector.select()) > 0) { // 选择一组键，并且相应的通道已经准备就绪
                Set<SelectionKey> selectedKeys = selector.selectedKeys();// 取出全部生成的key
                Iterator<SelectionKey> iter = selectedKeys.iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next(); // 取出每一个key
                    if (key.isConnectable()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        if (client.isConnectionPending()) {
                            client.finishConnect();
                            byteBuffer.clear();
                            // 向缓冲区中设置内容
                            byteBuffer.put(("isConnect,当前的时间为：" + new Date()).getBytes());
                            byteBuffer.flip();
                            // 输出内容
                            client.write(byteBuffer);
                        }
                        client.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable() && key.isValid()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        byteBuffer.clear();
                        // 读取内容到缓冲区中
                        int readSize = client.read(byteBuffer);
                        if (readSize > 0) {
                            System.out.println("客户端接受服务器端数据:" + new String(byteBuffer.array(), 0, readSize));
                            client.register(selector, SelectionKey.OP_WRITE);
                        }
                    } else if (key.isWritable() && key.isValid()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        byteBuffer.clear();
                        // 向缓冲区中设置内容
                        byteBuffer.put(("nio文章学习很多！").getBytes());
                        byteBuffer.flip();
                        // 输出内容
                        client.write(byteBuffer);
                        client.register(selector, SelectionKey.OP_READ);
                    }
                }
                selectedKeys.clear(); // 清楚全部的key
            }

        }

    }
}
