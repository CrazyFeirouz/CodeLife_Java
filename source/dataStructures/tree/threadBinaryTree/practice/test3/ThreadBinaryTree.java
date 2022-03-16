package dataStructures.tree.threadBinaryTree.practice.test3;

import dataStructures.tree.threadBinaryTree.HeroNode;

/**
 * @description: 练习2 - 线索化二叉树
 * @author: Feirouz
 * @date: 2022-03-16 12:51
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
        HeroNode curNode = node;
        if (curNode == null) {
            return;
        }
        // 先左
        inorderThreadNode(curNode.getLeft());

        // 线索化当前节点
        if (curNode.getLeft() == null) {
            curNode.setLeft(pre);
            curNode.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(curNode);
            pre.setRightType(1);
        }
        pre = curNode;

        // 再右
        inorderThreadNode(curNode.getRight());


    }
}
