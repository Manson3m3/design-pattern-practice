package pers.manson3m3.designPattern.flyweight;

/**
 * 享元模式使用场景
 * 1.一个应用程序使用大量相同或者相似的对象，造成很大的存储开销
 * 2.对象的大部分状态都可以外部化，可以将这些外部状态传入对象中
 * 3.如果删除对象的外部状态，那么可以用相对较少的共享对象取代很多组对象
 * 4.应用程序不依赖于对象标识。由于Flyweight对象可以被共享，对于概念上明显有别的对象，标识测试将返回真值
 * 5.使用享元模式需要维护一个存储享元对象的享元池，而这需要耗费资源
 *   因此，应当在多次重复使用享元对象时才值得使用享元模式
 */
public interface Flyweight {
    void operate(int state);
}

class ConcreteFlyweight implements Flyweight {
    private int state;

    public ConcreteFlyweight(int state) {
        this.state = state;
    }

    @Override
    public void operate(int state) {
        System.out.println("Shard ConcreteFlyweight!");
    }
}

class UnsharedFlyweight implements Flyweight {

    private int unsharedState;

    public UnsharedFlyweight(int unsharedState) {
        this.unsharedState = unsharedState;
    }

    @Override
    public void operate(int state) {
        System.out.println("UnsharedConcreteFlyweight!!");
    }

}

class FlyweightFactory implements Flyweight {
    private static final int SHARED_STATE = 0;
    private static final int UNSHARED_STATE = 1;
    private static final Flyweight sharedInstance = new ConcreteFlyweight(SHARED_STATE);
    private FlyweightFactory() {

    }

    @Override
    public void operate(int state) {

    }
    static Flyweight getInstance(boolean isShared){
        if (isShared) {
            return sharedInstance;
        } else {
            return new UnsharedFlyweight(UNSHARED_STATE);
        }
    }
}

class Client {
    public static void main(String[] args) {
        Flyweight sharedFlyweight1 = FlyweightFactory.getInstance(true);
        Flyweight sharedFlyweight2 = FlyweightFactory.getInstance(true);

        System.out.println("Is Same Instance:"+ (sharedFlyweight1==sharedFlyweight2));

        Flyweight flyweight1 = FlyweightFactory.getInstance(false);
        Flyweight flyweight2 = FlyweightFactory.getInstance(false);
        System.out.println("Is Same Instance:"+ (flyweight1==flyweight2));
    }
}