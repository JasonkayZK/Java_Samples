package top.jasonkayzk.redismq.pub;

import redis.clients.jedis.Jedis;

/**
 * 发布者
 *
 * @author zk
 */
public class RedisPub {

    public static void main(String[] args) {
        publish();
    }

    public static void publish() {
        System.out.println("发布者");
        Jedis client = null;
        try {
            // redis服务地址和端口号
            client = new Jedis("127.0.0.1", 6379, 0);

            // client客户端配置两个推送channel
            client.publish( "news.share", "新闻分享");
            client.publish( "news.blog", "新闻博客");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (client != null) {
                client.disconnect();
            }
        }
    }

}
