package nio.mappedByteBuffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ByteBufferDemo {

    public static void readFile() {
        RandomAccessFile file = null;
        FileChannel channel = null;

        try {
            file = new RandomAccessFile("src/fileIODemo.txt", "rw");
            channel = file.getChannel();
            long start = System.currentTimeMillis();
            ByteBuffer buffer = ByteBuffer.allocate((int) file.length());
            buffer.clear();
            channel.read(buffer);

            System.out.format("Read time: %sms", System.currentTimeMillis() - start);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (channel != null) {
                    channel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
