package nio.other.transferFromAndTo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class TransferFromAndToDemo {

    public static void main(String[] args) {
        transferToTxt();
//        transferFromXml();
    }

    public static void transferToTxt() {
        RandomAccessFile fromFile = null;
        RandomAccessFile toFile = null;

        try {
            fromFile = new RandomAccessFile("src/fromFile.txt", "rw");
            FileChannel fromChannel = fromFile.getChannel();
            toFile = new RandomAccessFile("src/toFile.txt", "rw");
            FileChannel toChannel = toFile.getChannel();

            long pos = 0, count = fromChannel.size();
            System.out.println(count);
            fromChannel.transferTo(pos, count, toChannel);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fromFile != null) {
                try {
                    fromFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (toFile != null) {
                try {
                    toFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void transferFromXml() {
        RandomAccessFile fromFile = null;
        RandomAccessFile toFile = null;

        try {
            fromFile = new RandomAccessFile("src/fromFile.xml", "rw");
            FileChannel fromChannel = fromFile.getChannel();

            toFile = new RandomAccessFile("src/toFile.xml", "rw");
            FileChannel toChannel = toFile.getChannel();

            long pos = 0, count = fromChannel.size();
            System.out.println(count);
            toChannel.transferFrom(fromChannel, pos, count);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fromFile != null) {
                try {
                    fromFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (toFile != null) {
                try {
                    toFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
