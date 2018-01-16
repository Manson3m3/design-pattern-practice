package pers.manson3m3.dataStruct.tree;

/**
 * 树是一个递归的概念，从根节点开始，每个节点至多只有一个父节点，有多个子节点，每个子节点又是一棵树，以此递归。
 */
public class ArrayTree<T> {
    /**
     * 数据和父节点下标
     */
    private T data;
    private int mParent;

    ArrayTree(T data, int mParent) {
        this.data = data;
        this.mParent = mParent;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getmParent() {
        return mParent;
    }

    public void setmParent(int mParent) {
        this.mParent = mParent;
    }
    @Override
    public String toString() {
        return "Node Data:" + data + ",mParent:" + mParent;
    }
}


//class Test {
//    public static void main(String[] args) {
//        Tree tree = new Tree("root",10);
//        tree.addNode("left",0);
//        tree.addNode("right",0);
//        tree.addNode("a",1);
//        tree.addNode("b",1);
//        tree.printTree();
//
//    }
//}