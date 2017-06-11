package com.github.yl.tree;

/**
 * Created by lei.yang on 17/4/17.
 */
public class BinaryTree {
    private static TreeNode root;

    /**
     * 插入数据到二叉树（构造二叉查找树）
     * @param currentNode
     * @param newNode
     */
    public void insert(TreeNode currentNode,TreeNode newNode){
        if(currentNode == null){
            currentNode = newNode;
            if(root == null){
                root = new TreeNode(newNode.getT());
            }
        }else {
            if(newNode.getT().compareTo(currentNode.getT()) < 0 ){
                if (currentNode.getLeftChild() == null) {
                    currentNode.setLeftChild(newNode);
                } else {
                    insert(currentNode.getLeftChild(), newNode);
                }
            }else {
                if(currentNode.getRightChild() == null){
                    currentNode.setRightChild(newNode);
                }else{
                    insert(currentNode.getRightChild(),newNode);
                }
            }
        }
    }

    public TreeNode findNode(TreeNode node){
        TreeNode current = root;
        while(current.getT().compareTo(node.getT()) != 0){
            if(current.getT().compareTo(node.getT()) < 0){
                current = current.getRightChild();
            }else{
                current = current.getLeftChild();
            }
            if(current == null)
                return null;
        }
        return current;
    }

    public TreeNode findMinNode(){
        TreeNode current = root,minNode = null;
        while (current !=null ){
            minNode = current;
            current = current.getLeftChild();
        }
        return minNode;
    }

    public TreeNode findMaxNode(){
        TreeNode current = root,maxNode = null;
        while (current !=null ){
            maxNode = current;
            current = current.getRightChild();
        }
        return maxNode;
    }

    /**
     * 中序遍历
     * @param root
     */
    public void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.getLeftChild());
            System.out.print(root.getT() + " ");
            inOrder(root.getRightChild());
        }
    }

    /**
     * 先序遍历
     * @param root
     */
    public void preOrder(TreeNode root){
        if(root != null){
            System.out.print(root.getT() + " ");
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    public void postOrder(TreeNode root){
        if(root != null){
            postOrder(root.getLeftChild());
            postOrder(root.getRightChild());
            System.out.print(root.getT() + " ");
        }
    }



    public static void main(String[] args) {
        int[] arr = { 6,1, 3, 9, 7, 0, 4 };
        BinaryTree binaryTree = new BinaryTree();
        for (int i = 0; i < arr.length; i++) {
            TreeNode<Integer> node = new TreeNode<Integer>(arr[i]);
            binaryTree.insert(root, node);
        }
        binaryTree.findMinNode().display();
        binaryTree.findMaxNode().display();
        TreeNode<Integer> findNode = new TreeNode(4);
        binaryTree.findNode(findNode).display();

        System.out.println("先序遍历");
        binaryTree.preOrder(root);
        System.out.println("");
        System.out.println("中序遍历");
        binaryTree.inOrder(root);
        System.out.println("");
        System.out.println("后序遍历");
        binaryTree.postOrder(root);
    }

}
