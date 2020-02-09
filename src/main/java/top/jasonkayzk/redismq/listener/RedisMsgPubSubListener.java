package top.jasonkayzk.redismq.listener;

import redis.clients.jedis.JedisPubSub;

/**
 * Redis发布订阅消息监听器
 *
 * @author zk
 */
public class RedisMsgPubSubListener extends JedisPubSub {

    @Override
    public void unsubscribe() {
        super.unsubscribe();
    }

    @Override
    public void unsubscribe(String... channels) {
        super.unsubscribe(channels);
    }

    @Override
    public void subscribe(String... channels) {
        super.subscribe(channels);
    }

    @Override
    public void psubscribe(String... patterns) {
        super.psubscribe(patterns);
    }

    @Override
    public void punsubscribe() {
        super.punsubscribe();
    }

    @Override
    public void punsubscribe(String... patterns) {
        super.punsubscribe(patterns);
    }

    /**
     * 订阅频道时的回调
     *
     * @param channel            频道
     * @param subscribedChannels 订阅成功的频道
     */
    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println(String.format("subscribe redis channel success, channel %s, subscribedChannels %d",
                channel, subscribedChannels));
    }

    /**
     * 监听到订阅频道接受到消息时的回调
     *
     * @param channel 订阅频道
     * @param message 频道推送
     */
    @Override
    public void onMessage(String channel, String message) {
        System.out.println(String.format("receive redis published message, channel %s, message %s", channel, message));
    }

    /**
     * 取消订阅频道时的回调
     *
     * @param channel            频道
     * @param subscribedChannels 订阅成功的频道
     */
    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println(String.format("unsubscribe redis channel, channel %s, subscribedChannels %d",
                channel, subscribedChannels));
    }

    /**
     * 监听到订阅模式接受到消息时的回调
     *
     * @param pattern 订阅模式
     * @param channel 订阅频道
     * @param message 频道推送
     */
    @Override
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println(String.format("onPMessage: pattern[%s], channel[%s], message[%s]", pattern, channel, message));
    }

    /**
     * 取消订阅模式时的回调
     *
     * @param pattern            订阅模式
     * @param subscribedChannels 订阅的频道
     */
    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        System.out.println(String.format("onPUnsubscribe: pattern[%s], subscribedChannels[%s]", pattern, subscribedChannels));
    }

    /**
     * 订阅频道模式时的回调
     *
     * @param pattern            订阅模式
     * @param subscribedChannels 订阅的频道
     */
    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        System.out.println(String.format("onPSubscribe: pattern[%s], subscribedChannels[%s]", pattern, subscribedChannels));
    }

}
