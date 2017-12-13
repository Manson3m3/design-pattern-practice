package pers.manson3m3.designPattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造者模式：是将一个复杂的对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 */

/**
 * 产品
 */
class Product {
    private List<Object> list = new ArrayList<>();
    void add(Object o) {
        list.add(o);
    }
    void show() {
        for (Object o:list){
            System.out.println(o.toString());
        }
    }
}

/**
 * 抽象建造者
 */
public interface Builder {
    void buildComponent1();
    void buildComponent2();
    void buildComponent3();
    void buildComponent4();
    Product getProduct();
}

/**
 * 具体建造者
 */
class BuilderA implements Builder {
     private Product productA = new Product();
    @Override
    public void buildComponent1() {
        productA.add("build Component1A");
    }

    @Override
    public void buildComponent2() {
        productA.add("build Component2A");
    }

    @Override
    public void buildComponent3() {
        productA.add("build Component3A");
    }

    @Override
    public void buildComponent4() {
        productA.add("build Component4A");
    }

    @Override
    public Product getProduct() {
        return productA;
    }
}

class BuilderB implements Builder {

    private Product productB = new Product();
    @Override
    public void buildComponent1() {
        productB.add("build Component1B");
    }

    @Override
    public void buildComponent2() {
        productB.add("build Component2B");
    }

    @Override
    public void buildComponent3() {
        productB.add("build Component3B");
    }

    @Override
    public void buildComponent4() {
        productB.add("build Component4B");
    }

    @Override
    public Product getProduct() {
        return productB;
    }
}

/**
 * 导演类，决定使用哪个具体的建造者
 */
class Director{
    Product createProduct(Builder builder) {
        builder.buildComponent1();
        builder.buildComponent2();
        builder.buildComponent3();
        builder.buildComponent4();
        return builder.getProduct();
    }
}

class Test {
    public static void main(String[] args) {
        Director director = new Director();
        Product productA = director.createProduct(new BuilderA());
        Product productB = director.createProduct(new BuilderB());

        productA.show();
        productB.show();
    }
}