package nio.socketChannel;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class OioServer {

    public static void start() {
        ServerSocket serverSocket = null;
        InputStream in = null;

        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Server on!");
            int recvMsgSize = 0;
            byte[] recvBuf = new byte[1024];

            while (true) {
                Socket cintSocket = serverSocket.accept();
                SocketAddress address = cintSocket.getRemoteSocketAddress();
                System.out.println("Handling client at " + address);

                in = cintSocket.getInputStream();
                while ((recvMsgSize = in.read(recvBuf)) != -1) {
                    byte[] temp = new byte[recvMsgSize];
                    System.arraycopy(recvBuf, 0, temp, 0, recvMsgSize);
                    System.out.println(new String(temp));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        OioServer.start();
    }

}
