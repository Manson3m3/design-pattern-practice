package pers.manson3m3.designPattern.facade;

/**
 * 外观模式是为了解决类与类之家的依赖关系
 * 降低了类类之间的耦合度,该模式中没有涉及到接口
 */
class Component1 {
    void start() {
        System.out.println("Component1 start!");
    }
    void end() {
        System.out.println("Component1 end!");
    }
}

class Component2 {
    void start() {
        System.out.println("Component2 start!");
    }
    void end() {
        System.out.println("Component2 end!");
    }
}

class Component3 {
    void start() {
        System.out.println("Component3 start!");
    }
    void end() {
        System.out.println("Component3 end!");
    }
}

/**
 * 门面角色，根据需求组合不同模块的功能
 */
public class Facade {

    private Component1 component1;
    private Component2 component2;
    private Component3 component3;

    private Facade() {
        component1 = new Component1();
        component2 = new Component2();
        component3 = new Component3();
    }
    private void start() {
        component1.start();
        component2.start();
        component3.start();
    }

    private void end() {
        component1.end();
        component2.end();
        component3.end();
    }

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.start();
        facade.end();
    }
}
