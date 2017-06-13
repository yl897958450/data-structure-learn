package com.github.yl.tree;

/**
 * Created by lei.yang on 17/4/17.
 * 二叉查找树
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

    /**
     * 删除二叉搜索树节点
     * @param node 要删除的节点
     */
    public boolean deleteNode(TreeNode node){
        if(node == null && root == null){
            return false;
        }
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = true;
        //寻找该节点
        while(current.getT().compareTo(node.getT()) != 0){
            parent = current;
            if(current.getT().compareTo(node.getT()) < 0){
                current = current.getRightChild();
                isLeftChild = false;
            }else{
                current = current.getLeftChild();
                isLeftChild = true;
            }
            if(current == null)
                return false;
        }
        //要删除节点是叶子节点
        if(current.getLeftChild() == null && current.getRightChild() == null){
            if(current == root)
                root = null;
            else if(isLeftChild)
                parent.setLeftChild(null);
            else
                parent.setRightChild(null);
        //要删除的节点只有右孩子节点
        }else if(current.getLeftChild() == null){
            if(current == root) {
                root = current.getRightChild();
            } else if(isLeftChild){
                parent.setLeftChild(current.getRightChild());
            }else{
                parent.setRightChild(current.getRightChild());
            }
        //被删除的节点只有左孩子节点
        }else if(current.getRightChild() == null){
            if(current == root){
                root = null;
            }else if(isLeftChild){
                parent.setLeftChild(current.getLeftChild());
            }else{
                parent.setRightChild(current.getLeftChild());
            }
        //要删除节点左、右孩子都存在
        }else{

        }

        return false;
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
        int[] arr = { 6,1,5, 3, 9, 7, 0, 4,13 };
        BinaryTree binaryTree = new BinaryTree();
        for (int i = 0; i < arr.length; i++) {
            TreeNode<Integer> node = new TreeNode<Integer>(arr[i]);
            binaryTree.insert(root, node);
        }
        binaryTree.findMinNode().display();
        binaryTree.findMaxNode().display();
        TreeNode<Integer> findNode = new TreeNode(9);
        TreeNode<Integer> resultNode = binaryTree.findNode(findNode);
        resultNode.display();
        resultNode.getLeftChild().display();

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
