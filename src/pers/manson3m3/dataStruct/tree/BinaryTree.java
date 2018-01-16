package pers.manson3m3.dataStruct.tree;


/**
 * Created on 2017/12/13.
 */
public class BinaryTree<T> extends Tree {
    private Node<T> root;

    public BinaryTree(Node<T> root) {
        if (root != null) {
            this.root = root;
        }
    }

    @SuppressWarnings("unchecked")
    public BinaryTree(T[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("传入数组为空！");
        } else {
            Node root = new Node(arr[0]);
            int index = 1;
            Node node = root;
            BinaryTree binaryTree = new BinaryTree(root);
            if (arr.length > 1 && arr.length <= 3) {
                root.setLeft(new Node(arr[1]));
                if (arr.length == 3) {
                    root.setRight(new Node(arr[2]));
                }
            }
            while (index < arr.length / 2) {
                if (index == arr.length / 2 && (arr.length & 1) != 1) {
                    node.setLeft(new Node(arr[2 * index - 1]));
                }
                node.setLeft(new Node(arr[2 * index - 1]));
                node.setLeft(new Node(arr[2 * index]));
                node = searchNode(++index, binaryTree);
            }
        }


    }

    @Override
    public Node getRoot() {
        return root;
    }

    @Override
    void insert(Node node) {

    }

    @Override
    void delete(Node node) {

    }

    @Override
    void print(Tree tree) {

    }

    @Override
    int getHeight(Tree tree) {
        return 0;
    }

    @SuppressWarnings("unchecked")
    public Node<T> searchNode(int index, Tree tree) {
        if (index <= 0) {
            return null;
        } else if (index == 1) {
            return tree.getRoot();
        } else {
            Node node = searchNode(index / 2, tree);
            if ((index & 1) == 1) {
                return node.getRight();
            } else {
                return node.getLeft();
            }
        }
    }

    public Node<T> getLastNode() {
        int size = this.getSize(getRoot());
        return searchNode(size, this);

    }

    public int getSize(Node node) {
        int size = 0;
        if (node != null) {
            size++;
            getSize(node.getLeft());
            getSize(node.getRight());
        }
        return size;
    }

    /**
     * 前序遍历 递归
     */
    void preOrder(Node node) {
        if (node != null) {
            System.out.println(node);
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }
}
