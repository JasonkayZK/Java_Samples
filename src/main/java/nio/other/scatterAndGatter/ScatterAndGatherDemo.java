package nio.other.scatterAndGatter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class ScatterAndGatherDemo {


    public static void main(String[] args) throws IOException {
        gather();
    }

    private static void gather() throws IOException {
        ByteBuffer header = ByteBuffer.allocate(10);
        ByteBuffer body = ByteBuffer.allocate(10);

        byte[] b1 = {'0', '1'};
        byte[] b2 = {'2', '3'};

        header.put(b1);
        body.put(b2);

        ByteBuffer[] buffers = {header, body};

        FileOutputStream outputStream = new FileOutputStream("src/scatterAndGather.txt");
        FileChannel channel = outputStream.getChannel();
        channel.write(buffers);

        outputStream.close();
    }


}
