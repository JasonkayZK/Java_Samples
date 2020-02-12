package top.jasonkayzk.sso.util;

import java.util.Random;

/**
 * 随机工具类
 *
 * @author zk
 */
public class RandomUtil {

    private static final char[] DICT = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * 生成指定长度的随机字符串
     *
     * @param length 字符串长度
     * @return 字符串
     */
    public static String randomSecret(int length) {
        Random random = new Random();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < length; i++) {
            buffer.append(DICT[random.nextInt(62)]);
        }
        return buffer.toString();
    }

}
