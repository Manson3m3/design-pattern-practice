package pers.manson3m3.designPattern.TemplateMethod;

/**
 * 模板方法模式，是指一个抽象类中，有一个主方法，再定义1...n个方法，
 * 可以是抽象的，也可以是实际的方法，定义一个类，继承该抽象类，重写抽象方法，通过调用抽象类，实现对子类的调用
 */
public abstract class AbstractCalculator {

    //主方法，调用子类实现的方法
    public final int calculate(String exp,String opt){
        int array[] = split(exp,opt);
        return calculate(array[0],array[1]);
    }

    //被子类重写的方法
    abstract public int calculate(int num1,int num2);

    public int[] split(String exp,String opt){
        String array[] = exp.split(opt);
        int arrayInt[] = new int[2];
        arrayInt[0] = Integer.parseInt(array[0]);
        arrayInt[1] = Integer.parseInt(array[1]);
        return arrayInt;
    }
}

class Plus extends AbstractCalculator {
    @Override
    public int calculate(int num1, int num2) {
        return num1+num2;
    }
}

class Minus extends AbstractCalculator {
    @Override
    public int calculate(int num1, int num2) {
        return num1-num2;
    }
}

class Test {
    public static void main(String[] args) {
        AbstractCalculator calculator = new Plus();
        System.out.println(calculator.calculate("88+66","\\+"));

        calculator = new Minus();
        System.out.println(calculator.calculate("66-88","-"));
    }
}