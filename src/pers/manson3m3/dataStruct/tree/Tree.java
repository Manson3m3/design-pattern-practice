package pers.manson3m3.dataStruct.tree;

/**
 * Created on 2017/12/13.
 */
abstract class Tree {

    abstract void insert(Node node);

    abstract void delete(Node node);

    abstract void print(Tree tree);

    abstract int getHeight(Tree tree);

    abstract Node getRoot();
}
