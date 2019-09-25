package nio.mappedByteBuffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBufferDemo {

    public static void readFile() {
        RandomAccessFile file = null;
        FileChannel channel = null;

        try {
            file = new RandomAccessFile("src/fileIODemo.txt", "rw");
            channel = file.getChannel();
            long start = System.currentTimeMillis();
            MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            System.out.println("Read time: " + (System.currentTimeMillis() - start) + "ms");
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
