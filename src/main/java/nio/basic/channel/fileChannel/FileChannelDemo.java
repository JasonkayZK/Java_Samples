package nio.basic.channel.fileChannel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {

    public static void main(String[] args) {
        String[] info = {"Hello ", "world", " by ", "Java", " NIO"};
        File file = new File("src/testFileChannel.txt");
        FileOutputStream output = null;
        FileChannel fout = null;

        try {
            output = new FileOutputStream(file);
            fout = output.getChannel(); // 得到输出的通道
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            for (String s : info) {
                buffer.put(s.getBytes()); // 字符串变为字节数组放进缓冲区之中
            }
            buffer.flip(); // 切换模式准备输出
            fout.write(buffer); // 输出缓冲区的内容
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
