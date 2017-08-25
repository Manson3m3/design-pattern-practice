package pers.manson3m3.designPattern.bridge;

/**
 * 桥接模式就是把事物和其具体实现分开，使他们可以各自独立的变化
 */
interface Sourceable {
    void method();
}
//实现一
class Source1 implements Sourceable {
    @Override
    public void method() {
        System.out.println("Source1!");
    }
}
//实现二
class Source2 implements Sourceable {
    @Override
    public void method() {
        System.out.println("Source2!");
    }
}

//
abstract class Bridge {
    private Sourceable source;

    void method() {
        source.method();
    }

     Sourceable getSource() {
        return source;
    }

     void setSource(Sourceable source) {
        this.source = source;
    }
}

class MyBridge extends Bridge {
    @Override
    void method() {
        getSource().method();
    }
}

class Client{
    public static void main(String[] args) {
     Bridge bridge = new MyBridge();
     Sourceable source1 = new Source1();
     Sourceable source2 = new Source2();

     bridge.setSource(source1);
     bridge.method();

     bridge.setSource(source2);
     bridge.method();
    }
}