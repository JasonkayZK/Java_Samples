package nio.fileChannel;

import java.io.*;
import java.util.Objects;

public class OioFileDemo {

    public static void oioReadFile() {
        InputStream in = null;
        try {

            in = new BufferedInputStream(new FileInputStream("src/fileIODemo.txt"));
            byte[] buf = new byte[1024];
            int byteRead = in.read(buf);
            while (byteRead != -1) {
                for (int i = 0; i < byteRead; ++i)
                    System.out.println((char) buf[i]);
                byteRead = in.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        oioReadFile();
    }

}
