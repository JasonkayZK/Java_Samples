package top.jasonkayzk.sso.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * 加密/解密工具
 *
 * @author zk
 */
@Slf4j
public class SecurityUtil {

    /**
     * 编码格式
     */
    private static final String ENCODING = "UTF-8";
    /**
     * 加密算法
     */
    private static final String KEY_ALGORITHM = "AES";
    /**
     * 签名算法
     */
    private static final String SIGN_ALGORITHMS = "SHA1PRNG";
    /**
     * 默认加密key
     */
    private static final String DEFAULT_SECRET_KEY = "iwofnoadnsa922342mnjaolkdsao9423242niosadopa_a02402sad";

    /**
     * 加密
     *
     * @param content 待加密内容
     * @param key     加密的密钥
     * @return 加密内容
     */
    public static String encrypt(String content, String key) {
        key = StringUtils.isEmpty(key) ? DEFAULT_SECRET_KEY : key;

        try {
            KeyGenerator gen = KeyGenerator.getInstance(KEY_ALGORITHM);
            SecureRandom random = SecureRandom.getInstance(SIGN_ALGORITHMS);
            random.setSeed(key.getBytes(ENCODING));
            gen.init(128, random);
            SecretKey secretKey = gen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            byte[] byteContent = content.getBytes(ENCODING);

            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] byteResult = cipher.doFinal(byteContent);
            StringBuilder sb = new StringBuilder();
            for (byte b : byteResult) {
                String hex = Integer.toHexString(b & 0xFF);
                if (hex.length() == 1) {
                    hex = '0' + hex;
                }
                sb.append(hex.toUpperCase());
            }
            return sb.toString();
        } catch (Exception e) {
            log.error("Fail to encrypt: {}", e.getMessage());
        }
        return null;
    }

    /**
     * 解密
     *
     * @param content 待解密内容
     * @param key     解密的密钥
     * @return 解密内容
     */
    public static String decrypt(String content, String key) {
        key = StringUtils.isEmpty(key) ? key : DEFAULT_SECRET_KEY;

        if (content.length() < 1) {
            return null;
        }

        byte[] byteResult = new byte[content.length() / 2];
        for (int i = 0; i < content.length() / 2; i++) {
            int high = Integer.parseInt(content.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(content.substring(i * 2 + 1, i * 2 + 2), 16);
            byteResult[i] = (byte) (high * 16 + low);
        }
        try {
            KeyGenerator gen = KeyGenerator.getInstance(KEY_ALGORITHM);
            SecureRandom random = SecureRandom.getInstance(SIGN_ALGORITHMS);
            random.setSeed(key.getBytes(ENCODING));
            gen.init(128, random);
            SecretKey secretKey = gen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] result = cipher.doFinal(byteResult);
            return new String(result, ENCODING);
        } catch (Exception e) {
            log.error("Fail to decrypt: {}", e.getMessage());
        }
        return null;
    }

}