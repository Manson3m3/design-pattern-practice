package pers.manson3m3.designPattern.composite;

import java.util.Vector;

/**
 * 将对象组合成树形结构以表示“部分-整体”的层次结构。Composite使得用户对单个对象和组合对象的使用具有一致性。
 * 以下情况下适用Composite模式：
 * 1)．你想表示对象的部分-整体层次结构
 * 2)．你希望用户忽略组合对象与单个对象的不同，用户将统一地使用组合结构中的所有对象。
 */

abstract class Component {
   abstract public void operate(String str);
   void add(Component component){}
   void remove(Component component){}
   Vector<Component> getChild(){return null;}
}

class Leaf extends Component {
    public Leaf(String string) {

        this.operate(string);
    }

    @Override
    public void operate(String string) {
        System.out.println("this is " + string + "!");
    }
}

public class Composite extends Component{

    private Vector<Component> components;
    public Composite(Component component) {
        components = new Vector<>();
        operate(component.toString());
        this.components.add(component);
    }

    @Override
    public void operate(String s) {
        System.out.println("This is a composite!");
    }

    @Override
    public void add(Component component) {
        this.components.add(component);
    }

    @Override
    public void remove(Component component) {
        this.components.remove(component);
    }

    @Override
    public Vector<Component> getChild() {
        return this.components;
    }

    public int getLeafNum() {
        int leafNum = 0;
        Vector<Component> component = this.components;
        for (Component component1 : component) {
            if (component1 instanceof Composite) {
                leafNum += ((Composite) component1).getLeafNum();
            }
            else
                leafNum++;
        }
        return leafNum;
    }
}

class Client {
    public static void main(String[] args) {
        Leaf leaf1 = new Leaf("leaf1");
        Leaf leaf2 = new Leaf("leaf2");
        Component component = new Composite(leaf1);
        component.add(leaf2);
        component.add(new Leaf("leaf3"));

        Composite root = new Composite(component);
        root.add(new Leaf("leaf4"));

        System.out.println(root.getLeafNum());
        component.remove(leaf1);
        System.out.println(root.getLeafNum());

    }
}