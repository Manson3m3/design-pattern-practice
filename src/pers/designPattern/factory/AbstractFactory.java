package pers.designPattern.factory;

/**
 * Created by houli on 2017/8/17.
 */

abstract class Product1 {

}

class Product1A extends Product1 {
    Product1A(){
        System.out.println("Create Product1A!");
    }
}

class Product1B extends Product1 {
    Product1B() {
        System.out.println("Create Product1B!");
    }
}

abstract class Product2 {

}

class Product2A extends Product2 {
    Product2A() {
        System.out.println("Create Product2A!");
    }
}

class Product2B extends Product2 {
    Product2B() {
        System.out.println("Create Product2B!");
    }
}

/**
 * 工厂
 */
public interface AbstractFactory {
    Product1 createProduct1();
    Product2 createProduct2();
}

class Factory_A implements AbstractFactory {
    @Override
    public Product1 createProduct1() {
        return new Product1A();
    }

    @Override
    public Product2 createProduct2() {
        return new Product2A();
    }
}

class Factory_B implements AbstractFactory {
    @Override
    public Product1 createProduct1() {
        return new Product1B();
    }


    @Override
    public Product2 createProduct2() {
        return new Product2B();
    }
}
class TestAbstractFactory{
    public static void main(String[] args) {
        AbstractFactory factory_a = new Factory_A();
        AbstractFactory factory_b = new Factory_B();

        factory_a.createProduct1();
        factory_a.createProduct2();

        factory_b.createProduct1();
        factory_b.createProduct2();
    }
}