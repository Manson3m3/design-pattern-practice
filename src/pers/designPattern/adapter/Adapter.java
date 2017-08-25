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
 * 当希望将一个类转换成满足另一个新接口的类时，
 * 可以使用类的适配器模式，创建一个新类，继承原有的类，实现新的接口即可
 */
class ClassAdapter extends Source implements Sourceable {
    @Override
    public void method2() {
        System.out.println("ClassAdapter method2!");
    }
}

/**
 * 对象适配器
 * 当希望将一个对象转换成满足另一个新接口的对象时，
 * 可以创建一个ObjectAdapter类，持有原类的一个实例，在ObjectAdapter类的方法中，调用实例的方法就行
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
 * 当不希望实现一个接口中所有的方法时，可以创建一个抽象类InterfaceAdapter，
 * 实现所有方法，我们写别的类的时候，继承抽象类即可
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
