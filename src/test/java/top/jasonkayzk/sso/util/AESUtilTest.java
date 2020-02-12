package top.jasonkayzk.sso.util;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Objects;

import static top.jasonkayzk.sso.util.SecurityUtil.decrypt;
import static top.jasonkayzk.sso.util.SecurityUtil.encrypt;

@Ignore
public class AESUtilTest {

    @Test
    public void encryptTestWithKey() {
        String content = "test";
        String key = "123456";

        // 指定加密key
        System.out.println("加密前：" + content);
        String encryptResult = encrypt(content, key);
        System.out.println("加密后：" + encryptResult);

        // 指定加密key
        String decryptResult = decrypt(Objects.requireNonNull(encryptResult), key);
        System.out.println("解密后：" + decryptResult);

        Assertions.assertEquals(content, decryptResult);
    }

    @Test
    public void encryptTestWithoutKey() {
        String content = "test";

        // 不指定加密key
        System.out.println("加密前：" + content);
        String encryptResult = encrypt(content, "");
        System.out.println("加密后：" + encryptResult);

        // 不指定加密key
        String decryptResult = decrypt(Objects.requireNonNull(encryptResult), "");
        System.out.println("解密后：" + decryptResult);

        Assertions.assertEquals(content, decryptResult);
    }

}