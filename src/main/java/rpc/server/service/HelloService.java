package rpc.server.service;

import rpc.api.bean.Person;

// 公共服务接口类
public interface HelloService {
    String sayHello(String name);

    Person getPerson(String name);
}
