package nio.fileChannel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioFileDemo {

    public static void nioFileRead() {
        RandomAccessFile accessFile = null;
        try {
            accessFile = new RandomAccessFile("src/fileIODemo.txt", "rw");
            FileChannel fileChannel = accessFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            int bytesRead = fileChannel.read(buf);
            System.out.println(bytesRead);

            while (bytesRead != -1) {
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.println((char)buf.get());
                }
                buf.compact();
                bytesRead = fileChannel.read(buf);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (accessFile != null) {
                try {
                    accessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        nioFileRead();
    }

}
