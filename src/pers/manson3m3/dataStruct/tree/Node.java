package pers.manson3m3.dataStruct.tree;

/**
 * Created on 2017/12/13.
 */
public class Node<T> {
    private T val;
    private Node<T> left;
    private Node<T> right;
    private boolean visted;

    public Node(T val) {
        this.val = val;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public boolean isVisted() {
        return visted;
    }

    public void setVisted(boolean visted) {
        this.visted = visted;
    }
}
