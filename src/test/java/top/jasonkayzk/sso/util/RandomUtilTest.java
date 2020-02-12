package top.jasonkayzk.sso.util;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Random;

@Ignore
public class RandomUtilTest {

    @Test
    public void randomSecret() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int length = random.nextInt(64);
            String secret = RandomUtil.randomSecret(length);
            System.out.println(secret);
            Assertions.assertEquals(secret.length() ,length);
        }
    }
}