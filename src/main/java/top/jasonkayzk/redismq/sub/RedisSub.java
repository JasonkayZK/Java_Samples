package top.jasonkayzk.redismq.sub;

import redis.clients.jedis.Jedis;
import top.jasonkayzk.redismq.listener.RedisMsgPubSubListener;

/**
 * 订阅者
 *
 * @author zk
 */
public class RedisSub {

    public static void main(String[] args) {
        subscribe();
    }

    public static void subscribe() {
        System.out.println("订阅者");
        Jedis client = null;
        try {
            // redis服务地址和端口号
            client = new Jedis("127.0.0.1", 6379, 0);
            // 创建一个Listener
            RedisMsgPubSubListener listener = new RedisMsgPubSubListener();
            // 客户端配置监听两个channel: news.share和news.blog
            // 真正收到推送后在listener中处理回调逻辑
            client.subscribe(listener, "news.share", "news.blog");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (client != null) {
                client.disconnect();
            }
        }
    }

}
