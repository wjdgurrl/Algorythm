package study;

import java.util.Collection;
class Singleton{
    private static Singleton one;
    private Singleton(){

    }
    // 객체 생성 후에도 one == null이 아니기에 one을 계속 리턴
    // one이후의 객체를 생성해도 one만 리턴
    // getInstance로 생성한 객체들은 모두 동일
    public static Singleton getInstance() {
        if (one == null){
            one = new Singleton();
        }
        return one;
    }
}

public class Study {
    public static void main(String[] args){
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);

    }
}
