package rpc.api.util;

import java.io.*;

/**
 * @author zk
 */
public class SerializeUtils {

    /**
     * 序列化
     *
     * @param object
     * @return
     */
    public static byte[] serialize(Object object) {
        ByteArrayOutputStream os = null;
        ObjectOutputStream outputStream = null;
        try {
            os = new ByteArrayOutputStream();
            outputStream = new ObjectOutputStream(os);

            outputStream.writeObject(object);
            outputStream.flush();

            byte[] bytes = os.toByteArray();

            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        throw new RuntimeException("Fail to serialize!");
    }


    /**
     * 反序列化
     *
     * @param buf
     * @return
     */
    public static Object deserialize(byte[] buf) {
        ByteArrayInputStream is = null;
        ObjectInputStream inputStream = null;
        try {
            is = new ByteArrayInputStream(buf);
            inputStream = new ObjectInputStream(is);
            Object object = inputStream.readObject();

            return object;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return new RuntimeException("Fail to deserialize!");
    }

}
