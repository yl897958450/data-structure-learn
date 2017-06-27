package com.github.yl.tree;

/**
 * Created by lei.yang on 17/3/26.
 */
public class TreeNode< T extends Comparable<T>> implements Comparable<TreeNode> {
    private TreeNode<T> rightChild;
    private TreeNode<T> leftChild;
    private T t;

    public TreeNode(T t){
        this.rightChild = null;
        this.leftChild = null;
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public int compareTo(TreeNode o) {
        return getT().compareTo((T)o.getT());
    }

    public void display(){
        System.out.println(t.toString()+" ");
    }
}
