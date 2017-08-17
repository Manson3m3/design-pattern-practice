package pers.designPattern.factory;


/**
 * 产品抽象
 */
abstract class Product{
}
class ProductA extends Product{
    ProductA(){
        System.out.println("produce ProductA!");
    }
}
class ProductB extends Product{
    ProductB(){
        System.out.println("produce ProductB!");
    }
}

/**
 *工厂抽象
 */
public interface Factory{
    Product createProduct();
}

class FactoryA implements Factory{
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}

class FactoryB implements Factory {
    @Override
    public Product createProduct() {
        return new ProductB();
    }
}
class Test {
    public static void main(String[] agrs){
        Factory A = new FactoryA();
        Product producta = A.createProduct();

        Factory B = new FactoryB();
        Product productb = B.createProduct();
    }
}
