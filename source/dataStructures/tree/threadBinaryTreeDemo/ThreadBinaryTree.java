package dataStructures.tree.threadBinaryTreeDemo;

import dataStructures.tree.binaryTreeDemo.BinaryTree;

/**
 * @description: 线索二叉树 - 重复利用BinaryTree一下
 * @author: Feirouz
 * @date: 2022-02-18 21:00
 */
public class ThreadBinaryTree extends BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    // 拓展功能
    // 为了实现线索化, 需要创建要给指向当前节点的前驱节点的指针
    // 在递归进行线索化时, pre 总是保留前一个节点
    private HeroNode pre = null;

    // 重载一遍inorderThreadNodes
    public void inorderThreadNodes() {
        this.inorderThreadNodes(root);
    }

    /**
     * 对二叉树进行中序线索化的方法
     * @param node 当前需要线索化的节点
     */
    public void inorderThreadNodes(HeroNode node) {

        // 如果 node == null, 不能线索化
        if (node == null) {
            return;
        }

        // (1) 线索化左子树
        inorderThreadNodes(node.getLeft());
        // (2) 线索化当前节点[有点难度]
        //  1. 处理当前节点的前驱节点
        //      以8节点来理解
        //      8节点的.left = null, 8节点的.leftType = 1
        if (node.getLeft() == null) {
            // 让当前节点的做指针指向前驱节点
            node.setLeft(pre);
            // 修改当前节点的左指针的类型, 表示前驱节点
            node.setLeftType(1);
        }
        // 2. 处理当前节点的后继节点 (下次递归才过来调用)
        if (pre != null && pre.getRight() == null) {
            // 让前驱节点的右指针指向当前节点
            pre.setRight(node);
            // 修改前驱节点的右指针类型
            pre.setRightType(1);
        }
        // 3. !!! 每次处理一个节点后, 让当前节点是下一个节点的前驱节点
        pre = node;

        // (3) 线索化右子树
        inorderThreadNodes(node.getRight());
    }

    // 遍历线索化二叉树的方法
    public void threadedList() {
        // 定义一个变量，存储当前遍历的节点（后面要用），从root开始
        HeroNode node = root;
        while (node != null) {
            // 循环找到的leftType == 1 的节点， 第一个找到的节点时8节点
            // 后面随着遍历而变化，因为当leftType==1时，说明该节点是按照线索化处理后的有效节点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            // 打印当前这个节点
            System.out.println(node);
            // 如果当前节点的右指针指向的是后继节点，就一直输出
            while (node.getRightType() == 1) {
                // 获取到当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }
            // 替换这个遍历的节点
            node = node.getRight();
        }
    }
}
