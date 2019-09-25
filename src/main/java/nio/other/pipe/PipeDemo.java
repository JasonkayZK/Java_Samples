package nio.other.pipe;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PipeDemo {

    public static void method1() {
        Pipe pipe = null;
        ExecutorService exec = Executors.newFixedThreadPool(2);

        try {
            pipe = Pipe.open();
            final Pipe pipeTemp = pipe;
            exec.submit(() -> {
                Pipe.SinkChannel sinkChannel = pipeTemp.sink(); // 向管道中写数据
                while (true) {
                    TimeUnit.SECONDS.sleep(1);
                    String newData = "Pipe Test At Time " + System.currentTimeMillis();
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    buf.clear();
                    buf.put(newData.getBytes());
                    buf.flip();
                    while(buf.hasRemaining()){
                        System.out.println(buf);
                        sinkChannel.write(buf);
                    }
                }
            });

            exec.submit(() -> {
                Pipe.SourceChannel sourceChannel = pipeTemp.source();//向通道中读数据
                while(true){
                    TimeUnit.SECONDS.sleep(1);
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    buf.clear();
                    int bytesRead = sourceChannel.read(buf);
                    System.out.println("bytesRead= " + bytesRead);
                    while(bytesRead > 0){
                        buf.flip();
                        byte[] b = new byte[bytesRead];
                        int i = 0;
                        while(buf.hasRemaining()) {
                            b[i] = buf.get();
                            System.out.printf("%X", b[i]);
                            i++;
                        }
                        String s = new String(b);
                        System.out.println("=================||"+s);
                        bytesRead = sourceChannel.read(buf);
                    }
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            exec.shutdown();
        }
    }

    public static void main(String[] args) {
        method1();
    }

}
