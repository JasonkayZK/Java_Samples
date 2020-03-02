package top.jasonkayzk.entity;

import java.util.Date;

/**
 * JavaBean
 *
 * @author zk
 */
public class Person {

    private String name;

    private String password;

    private int age;

    private Date birthday;

    /**
     * 此时gender也是Bean中的一个属性!
     *
     * @return gender
     */
    public String getGender() {
        return "Unknown";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
