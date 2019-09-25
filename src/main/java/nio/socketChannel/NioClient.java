package nio.socketChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

public class NioClient {

    public static void start() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        SocketChannel channel = null;
        try {
            channel = SocketChannel.open();
            channel.configureBlocking(false);
            channel.connect(new InetSocketAddress("127.0.0.1", 8080));

            if (channel.finishConnect()) {
                System.out.println("Server connected!");
                int i = 0;
                while (true) {
                    TimeUnit.SECONDS.sleep(1);
                    String info = "I'm " + i++ + "-th information from client";
                    buffer.clear();
                    buffer.put(info.getBytes());
                    buffer.flip();

                    while (buffer.hasRemaining()) {
                        System.out.println(buffer);
                        channel.write(buffer);
                    }
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        NioClient.start();
    }

}
