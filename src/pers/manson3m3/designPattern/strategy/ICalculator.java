package pers.manson3m3.designPattern.strategy;

/**
 * 策略模式定义了一系列算法，并将每个算法封装起来，使他们可以相互替换，且算法的变化不会影响到使用算法的客户
 */

/**
 * 算法提供的接口
 */
public interface ICalculator {
    int calculate(String exp);
}

/**
 * 辅助抽象类
 */
abstract class AbstractCalculator {

    public int[] split(String exp,String opt){
        String array[] = exp.split(opt);
        int arrayInt[] = new int[2];
        arrayInt[0] = Integer.parseInt(array[0]);
        arrayInt[1] = Integer.parseInt(array[1]);
        return arrayInt;
    }
}

/**
 * 具体实现类
 */
class Plus extends AbstractCalculator implements ICalculator {
    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp,"\\+");
        return arrayInt[0]+arrayInt[1];
    }
}

class Minus extends AbstractCalculator implements ICalculator {

    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp,"-");
        return arrayInt[0]-arrayInt[1];
    }
}

class Multiply extends AbstractCalculator implements ICalculator {

    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp,"\\*");
        return arrayInt[0]*arrayInt[1];
    }
}

class Test {
    public static void main(String[] args) {
        ICalculator iCalculator = new Multiply();
        System.out.println(iCalculator.calculate("10*6"));
        iCalculator = new Plus();
        System.out.println(iCalculator.calculate("55+666"));

        iCalculator = new Minus();
        System.out.println(iCalculator.calculate("10-66"));

    }
}