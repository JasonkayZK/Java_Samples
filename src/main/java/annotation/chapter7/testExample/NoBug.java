package annotation.chapter7.testExample;

public class NoBug {

    @MyTest
    public void show(){
        System.out.println("1234567890");
    }

    @MyTest
    public void add(){
        System.out.println("1+1="+1+1);
    }

    @MyTest
    public void subtract(){
        System.out.println("1-1="+(1-1));
    }

    @MyTest
    public void multiply(){
        System.out.println("3 x 5="+ 3*5);
    }

    @MyTest
    public void division(){
        System.out.println("6 / 0="+ 6 / 0);
    }

}
