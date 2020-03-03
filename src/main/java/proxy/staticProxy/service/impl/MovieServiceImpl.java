package proxy.staticProxy.service.impl;

import proxy.staticProxy.service.MovieService;

public class MovieServiceImpl implements MovieService {

    @Override
    public void play() {
        System.out.println("您正在观看电影 《肖申克的救赎》");
    }
}
