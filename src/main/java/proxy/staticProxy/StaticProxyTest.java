package proxy.staticProxy;

import proxy.staticProxy.proxy.MovieProxy;
import proxy.staticProxy.service.impl.MovieServiceImpl;

public class StaticProxyTest {

    public static void main(String[] args) {
        new MovieProxy(new MovieServiceImpl()).play();
    }
}
