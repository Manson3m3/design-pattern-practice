package pers.designPattern.adapter;

/**
 *适配器模式将某个类的接口转换成客户端期望的另一个接口表示，目的是消除由于接口不匹配所造成的类的兼容性问题。
 */

interface Sourceable {
    void method1();
    void method2();
}

/**
 * 目标类
 */
class Source{
    public void method1() {
        System.out.println("original method!");
    }
}

/**
 * 类适配器
 */
class ClassAdapter extends Source implements Sourceable {
    @Override
    public void method2() {
        System.out.println("ClassAdapter method2!");
    }
}

/**
 * 对象适配器
 */
class ObjectAdapter implements Sourceable {
    private Source source;

    public ObjectAdapter(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("ObjectAdapter method2!");
    }
}

/**
 * 接口适配器
 */
abstract class InterfaceAdapter implements Sourceable{
    @Override
    public void method1() {}

    @Override
    public void method2() {}
}

class SourceMethod1 extends InterfaceAdapter {
    @Override
    public void method1() {
        System.out.println("InterfaceAdapter method1!");
    }
}

class SourceMethod2 extends InterfaceAdapter {
    @Override
    public void method2() {
        System.out.println("InterfaceAdapter method2!");
    }
}
public class Adapter {
    public static void main(String[] args) {
        Sourceable source1 = new ClassAdapter();
        source1.method1();
        source1.method2();

        Source source = new Source();
        Sourceable source2 = new ObjectAdapter(source);
        source2.method1();
        source2.method2();

        Sourceable source3 = new SourceMethod1();
        source3.method1();
        source3.method2();

        Sourceable source4 = new SourceMethod2();
        source4.method1();
        source4.method2();

    }
}
