package rpc.server.service.impl;

import rpc.api.bean.Person;
import rpc.server.service.HelloService;

/**
 * RPC服务实现类
 *
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Say hello to " + name;
    }

    @Override
    public Person getPerson(String name) {
        Person person = new Person();
        person.setName(name);
        person.setAge(22);

        return person;
    }
}
