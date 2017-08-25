package pers.manson3m3.designPattern.proxy;

/**
 * 装饰器模式关注于在一个对象上动态的添加方法，然而代理模式关注于控制对对象的访问
 * 用代理模式，代理类（proxy class）可以对它的客户隐藏一个对象的具体信息
 * 当使用代理模式的时候，在一个代理类中创建一个对象的实例
 * 当我们使用装饰器模 式的时候，通常的做法是将原始对象作为一个参数传给装饰者的构造器
 *
 */

interface Sourceable {
    void method();
}

class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("Original method!");
    }
}
public class Proxy implements Sourceable{
    private Source source;

    Proxy() {
        super();
        this.source = new Source();
    }

    @Override
    public void method() {
        before();
        source.method();
        after();
    }
    private void before() {
        System.out.println("before Proxy!");
    }
    private void after() {
        System.out.println("after Proxy!");
    }

    public static void main(String[] args) {
        Source source = new Source();
        Sourceable proxy = new Proxy();
        source.method();
        proxy.method();
    }
}
