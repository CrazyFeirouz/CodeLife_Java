package dataStructures.tree.threadBinaryTree.practice.test1;

import dataStructures.tree.binaryTree.BinaryTree;
import dataStructures.tree.threadBinaryTree.HeroNode;

/**
 * @description: 练习1 - 中序线索化二叉树
 * @author: Feirouz
 * @date: 2022-03-05 15:42
 */
public class ThreadBinaryTree extends BinaryTree {
    private HeroNode root;
    private HeroNode preNode = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void inorderThreadNodes() {
        this.inorderThreadNodes(root);
    }

    public void inorderThreadNodes(HeroNode node) {
        // 如果 node == null，不能线索化
        if (node == null) {
            return;
        }

        // 1. 线索化左子树
        inorderThreadNodes(node.getLeft());
        // 2. 线索化当前节点
        //      1. 处理当前节点的前驱节点
        if (node.getLeft() == null) {
            node.setLeft(preNode);
            node.setLeftType(1);
        }
        //      2. 处理当前节点的后继节点
        if (preNode != null && preNode.getRight() == null) {
            preNode.setRight(node);
            preNode.setRightType(1);
        }
        // 3. 让当前节点是下一个前驱结点
        preNode = node;

        // 线索化右子树
        inorderThreadNodes(node.getRight());
    }
}
