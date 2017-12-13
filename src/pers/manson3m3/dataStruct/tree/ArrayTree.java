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

    public int getmParent() {
        return mParent;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setmParent(int mParent) {
        this.mParent = mParent;
    }
    @Override
    public String toString() {
        return "Node Data:" + data + ",mParent:" + mParent;
    }
}

class Tree<E> {
    private static final int DEFFAULT_SIZE = 10;
    private int treeSize;
    private int nodeNum;
    private ArrayTree[] treeNodes;


    @SuppressWarnings("unchecked")
    public Tree(E data) {
        treeSize = DEFFAULT_SIZE;
        this.treeNodes = new ArrayTree[treeSize];
        treeNodes[0] = new ArrayTree(data,-1);
        nodeNum ++;
    }
    @SuppressWarnings("unchecked")
    public Tree(E data,int treeSize) {
        if (treeSize<=DEFFAULT_SIZE){
            this.treeSize = treeSize;
            this.treeNodes = new ArrayTree[treeSize];
            treeNodes[0] = new ArrayTree(data,-1);
            nodeNum++;
        }
        else
            throw new RuntimeException("treeSize不能大于10！");
    }

    public void addNode(E data,int mParent) {
        if (this.nodeNum == DEFFAULT_SIZE) {
            throw new RuntimeException("树节点数目超过10！");
        } else {
            this.treeNodes[nodeNum] = new ArrayTree(data,mParent);
            nodeNum++;
        }
    }

    public ArrayTree getRoot() {
        return treeNodes[0];
    }

    public void printTree() {
        for (int i = 0; i < this.nodeNum; i++) {
            System.out.println(this.treeNodes[i]);
        }
    }

    public int getTreeSize() {
        return treeSize;
    }

    public int getNodeNum() {
        return nodeNum;
    }
}

@SuppressWarnings("unchecked")
class Test {
    public static void main(String[] args) {
        Tree tree = new Tree("root",10);
        tree.addNode("left",0);
        tree.addNode("right",0);
        tree.addNode("a",1);
        tree.addNode("b",1);
        tree.printTree();

    }
}