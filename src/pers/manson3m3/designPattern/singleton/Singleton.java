package pers.manson3m3.designPattern.singleton;


import java.io.Serializable;

/**
 * 单例模式
 * 保证同一时刻在一个jvm中对于一个类只有一个实例存在
 */

class Singleton1 implements Serializable{
    private static Singleton1 instance = null;
    private Singleton1(){
        System.out.println("Init Singleton1");
    }
    public static synchronized Singleton1 getInstance(){
        if (instance == null){
           instance = new Singleton1();
        }
        return instance;
    }
    //对象在序列化前后保持一致
    public Object readResolve(){
        return instance;
    }
}
class Singleton2{
    private Singleton2() {
        System.out.println("Init Singleton2");
    }
    public static   Singleton2 getInstance(){
        return EnumSingleton.INSTANCE.getInstance();
    }
    private enum EnumSingleton{
        INSTANCE;
        private Singleton2 instance = null;
        EnumSingleton(){
             instance = new Singleton2();
        }
        public Singleton2 getInstance(){
            return  instance;
        }
    }
}
enum Singleton3{
    INSTANCE;
    public void getInstance(){
        System.out.println("Init Singleton3");
    }
}

class Singleton4 implements Serializable{
    private Singleton4(){
        System.out.println("Init Singleton4");
    }
    private static class SingletonFactory{
        private static Singleton4 singleton4 = new Singleton4();
    }
    protected static Singleton4 getInstance(){
        return SingletonFactory.singleton4;
    }
    //序列化前后保持一致
    public Object readResolve(){
        return SingletonFactory.singleton4;
    }
}
public class Singleton {
    public static void main(String[] args) {
        Singleton1.getInstance();
        Singleton2.getInstance();
        Singleton3.INSTANCE.getInstance();
        Singleton4.getInstance();
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton1.getInstance();
                    Singleton2.getInstance();
                    Singleton3.INSTANCE.getInstance();
                    Singleton4.getInstance();
                }
            }).start();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
