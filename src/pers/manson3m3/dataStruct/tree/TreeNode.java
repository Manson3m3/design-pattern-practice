package pers.manson3m3.dataStruct.tree;

/**
 * 树是一个递归的概念，从根节点开始，每个节点至多只有一个父节点，有多个子节点，每个子节点又是一棵树，以此递归。
 */
public class TreeNode<T> {
    /**
     * 数据和父节点下标
     */
    private T data;
    private int mParent;

    TreeNode(T data, int mParent) {
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
    private TreeNode[] treeNodes;


    @SuppressWarnings("unchecked")
    public Tree(E data) {
        treeSize = DEFFAULT_SIZE;
        this.treeNodes = new TreeNode[treeSize];
        treeNodes[0] = new TreeNode(data,-1);
        nodeNum ++;
    }
    @SuppressWarnings("unchecked")
    public Tree(E data,int treeSize) {
        if (treeSize<=DEFFAULT_SIZE){
            this.treeSize = treeSize;
            this.treeNodes = new TreeNode[treeSize];
            treeNodes[0] = new TreeNode(data,-1);
            nodeNum++;
        }
        throw new RuntimeException("treeSize不能大于10！");
    }

    public void addNode(E data,int mParent) {
        if (this.nodeNum == DEFFAULT_SIZE) {
            throw new RuntimeException("树节点数目超过10！");
        }
    }

    public TreeNode getRoot() {
        return treeNodes[0];
    }

    public void printTree(Tree tree) {
        for (int i = 0; i < tree.nodeNum; i++) {
            System.out.println(tree.treeNodes[i]);
        }
    }

    public int getTreeSize() {
        return treeSize;
    }

    public int getNodeNum() {
        return nodeNum;
    }
}