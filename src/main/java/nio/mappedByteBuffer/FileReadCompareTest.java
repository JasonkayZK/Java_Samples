package nio.mappedByteBuffer;

public class FileReadCompareTest {

    public static void main(String[] args) {
        MappedByteBufferDemo.readFile();
        System.out.println("===================");
        ByteBufferDemo.readFile();
    }

}
