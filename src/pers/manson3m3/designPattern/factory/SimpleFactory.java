package pers.manson3m3.designPattern.factory;

/**
 * 简单工厂模式，根据传入的参数不同制造不同的产品
 */

abstract class Base{
     Base(){

    }
}
class DerivedA extends Base{
    DerivedA(){
        System.out.println("Construct DerivedA!");
    }
}
class DerivedB extends Base{
    DerivedB(){
        System.out.println("Construct DerivedB!");
    }
}
public class SimpleFactory {
    private Base createDerived(char c) {
        switch (c) {
            case 'A':
                return new DerivedA();
            case 'B':
                return new DerivedB();
            default:
                break;
        }
        return null;
    }

    public static void main(String[] args){
        SimpleFactory simpleFactory = new SimpleFactory();
        simpleFactory.createDerived('A');
        simpleFactory.createDerived('B');
    }
}
