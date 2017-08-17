package pers.designPattern.prototype;

import java.io.*;
import java.util.Date;
import java.util.HashMap;

import sun.dc.pr.PRError;

/**
 * 原型模式
 *
 */

/**
 * 产品，复制目标
 */
class Product implements Cloneable,Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private Date date;

    Product(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public abstract class Prototype {
    Product p;
    Prototype(Product p) {
        this.p = p;
    }
    abstract public Product clone() throws CloneNotSupportedException;
}

/**
 * 浅复制
 */
class ShallowPrototype extends Prototype {
    public ShallowPrototype(Product p) {
        super(p);
    }
    private Product p = super.p;
    @Override
    public Product clone() throws CloneNotSupportedException {
        p =(Product)p.clone();
        return p;
    }
}

/**
 * 深复制
 */
class DeepPrototype extends Prototype{
    public DeepPrototype(Product p) {
        super(p);
    }
    private Product p = super.p;
    @Override
    public Product clone() throws CloneNotSupportedException {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(p);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (Product)ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
}

class PrototypeManager{
    private static HashMap<String,Prototype> map = new HashMap<String, Prototype>();
    private PrototypeManager(){

    }

    /**
     * 添加或者修改原型注册
     * @param prototypeId
     * @param prototype
     */
    public synchronized static void setPrototype(String prototypeId,Prototype prototype) {
        map.put(prototypeId,prototype);
    }

    /**
     * 删除原型注册
     * @param prototypeId
     */
    public synchronized static void removePrototype(String prototypeId) {
        map.remove(prototypeId);
    }

    public synchronized static Prototype getPrototype(String prototypeId) throws Exception {
        Prototype prototype = map.get(prototypeId);
        if (prototype == null) {
            throw new Exception("没有要获取的原型");
        }
        return prototype;
    }
}


class Client {
    public static void main(String[] args) {
        try {
            Product product = new Product("product", new Date());
            Prototype p1 = new ShallowPrototype(product);
            PrototypeManager.setPrototype("1",p1);
            Product product1 =  p1.clone();
            System.out.println("是否同一个product:"+(product1 == product));
            System.out.println("是否同一个Date:"+(product.getDate() == product1.getDate() ));
            Prototype p2 = new DeepPrototype(product);
            PrototypeManager.setPrototype("2",p2);
            Product product2 =  p2.clone();
            System.out.println("是否同一个product:"+(product2 == product));
            System.out.println("是否同一个Date:"+(product.getDate() == product2.getDate() ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}