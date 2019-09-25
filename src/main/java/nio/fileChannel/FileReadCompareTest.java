package nio.fileChannel;

public class FileReadCompareTest {

    public static void main(String[] args) {
        long cur = System.currentTimeMillis();
        OioFileDemo.oioReadFile();
        long oioCost = System.currentTimeMillis() - cur;

        cur = System.currentTimeMillis();
        NioFileDemo.nioFileRead();
        long nioCost = System.currentTimeMillis() - cur;

        System.out.format("Oio Cost: %sms, Nio Cost: %sms.", oioCost, nioCost);
    }
}
