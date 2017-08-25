package pers.designPattern.decorate;

/**
 * 装饰模式可以在不创造更多的子类的模式下，将对象的功能加以扩展
 */

interface Sourceable {
    void method();
}

class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("Original Method");
    }
}

class Decorator implements Sourceable {
    private Sourceable sourceable;

    Decorator(Sourceable sourceable) {
        super();
        this.sourceable = sourceable;
    }

    @Override
    public void method() {
        sourceable.method();
    }
}

class ConcreteDecorator1 extends Decorator {
    ConcreteDecorator1(Sourceable sourceable) {
        super(sourceable);
    }

    @Override
    public void method() {
        super.method();
        method1();
    }

     private void method1() {
        System.out.println("ConcreteDecorator lmethod1!");
    }
}

class ConcreteDecorator2 extends Decorator {
    public ConcreteDecorator2(Sourceable sourceable) {
        super(sourceable);
    }

    @Override
    public void method() {
        super.method();
        method2();
    }

    void method2() {
        System.out.println("ConcreteDecorator method2!");
    }
}
public class Decorate {
    public static void main(String[] args) {
        Sourceable source = new Source();
        Sourceable source1 = new ConcreteDecorator1(source);
        Sourceable source2 = new ConcreteDecorator2(source1);

        source.method();
        source1.method();
        source2.method();
    }
}
