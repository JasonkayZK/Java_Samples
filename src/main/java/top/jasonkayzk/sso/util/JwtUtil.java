package top.jasonkayzk.sso.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

/**
 * jwt工具类
 *
 * @author zk
 */
@Slf4j
public class JwtUtil {

    /**
     * 密钥
     */
    private static final String SECRET_KEY = "324iu23094u598ndsofhsiufhaf_+0wq-42q421jiosadiusadiasd";

    /**
     * 从jwt中可以直接获取规定的字段，比如issuer, issUsedAt等字段
     */
    public static final String ISSUER = "auth";

    /**
     * 生成jwt
     */
    public static String creatJwt(String message) {
        // 先对信息进行AES加密
        message = SecurityUtil.encrypt(message, null);

        String token = null;
        try {
            token = JWT.create()
                    .withIssuer(ISSUER)
                    .withClaim("user", message)
                    .sign(Algorithm.HMAC256(SECRET_KEY));
        } catch (Exception e) {
            log.info("jwt生成错误: {}", e.getMessage());
        }
        log.info("加密后：" + token);
        return token;
    }

    /**
     * 解密jwt并验证是否正确
     */
    public static boolean deleteJwt(String token) {
        DecodedJWT decodedJWT;

        try {
            // 使用hmac256加密算法
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET_KEY))
                    .withIssuer(ISSUER)
                    .build();
            decodedJWT = verifier.verify(token);
            log.info("签名人: {}, 加密方式: {}, 携带信息: {}", decodedJWT.getIssuer(), decodedJWT.getAlgorithm(), decodedJWT.getClaim("user").asString());
        } catch (Exception e) {
            log.info("jwt解密出现错误，jwt或私钥或签证人不正确");
            return false;
        }

        // 获得token的头部，载荷和签名，只对比头部和载荷
        String[] headPayload = token.split("\\.");

        //获得jwt解密后头部
        String header = decodedJWT.getHeader();

        //获得jwt解密后载荷
        String payload = decodedJWT.getPayload();

        return (header.equals(headPayload[0]) && payload.equals(headPayload[1]));
    }
}
