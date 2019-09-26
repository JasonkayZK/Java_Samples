package nio.basic.filelock;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockDemo {

    public static void main(String[] args) {
        File file = new File("src/testFileChannel.txt");
        FileOutputStream output = null;
        FileChannel fout = null;

        try {
            output = new FileOutputStream(file, true);
            fout = output.getChannel(); // 得到通道

            FileLock lock = fout.tryLock(); // 进行独占锁的操作
            if (lock != null) {
                System.out.println(file.getName() + "文件锁定") ;
                Thread.sleep(5000) ;
                lock.release() ;    // 释放
                System.out.println(file.getName() + "文件解除锁定。") ;
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        } finally {
            if(fout!=null){
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(output!=null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
