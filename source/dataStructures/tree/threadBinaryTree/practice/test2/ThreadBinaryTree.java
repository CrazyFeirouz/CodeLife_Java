package dataStructures.tree.threadBinaryTree.practice.test2;

import dataStructures.tree.threadBinaryTree.HeroNode;

/**
 * @description: 练习2 - 线索化二叉树
 * @author: Feirouz
 * @date: 2022-03-07 21:32
 */
public class ThreadBinaryTree {
    private HeroNode root;

    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void inorderThreadNode() {
        inorderThreadNode(root);
    }

    public void inorderThreadNode(HeroNode node) {
        if (node == null) {
            return;
        }
        // 线索化左子树
        inorderThreadNode(node.getLeft());
        // 线索化当前节点
        //  1. 处理当前的前驱节点
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        //  2. 处理当前节点的后继节点
        // 线索化右子树
        inorderThreadNode(node.getRight());
    }
}
