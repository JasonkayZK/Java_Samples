package proxy.staticProxy.proxy;

import proxy.staticProxy.service.MovieService;
import proxy.staticProxy.service.impl.MovieServiceImpl;

public class MovieProxy implements MovieService {

    MovieServiceImpl movieService;

    public MovieProxy(MovieServiceImpl movieService) {
        super();
        this.movieService = movieService;
    }

    @Override
    public void play() {
        advertise(true);
        movieService.play();
        advertise(false);
    }

    public void advertise(boolean isStart) {
        System.out.println(isStart ? "电影马上开始了，爆米花、可乐、口香糖9.8折，快来买啊！" : "电影马上结束了，爆米花、可乐、口香糖9.8折，买回家吃吧！");
    }


}
