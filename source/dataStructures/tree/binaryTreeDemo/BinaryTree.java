package dataStructures.tree.binaryTreeDemo;

/**
 * @description: 二叉树
 * @author: Feirouz
 * @date: 2022-02-18 21:00
 */
public class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    // 前序遍历
    public void preorder() {
        if (this.root != null) {
            this.root.preorder();
        } else {
            System.out.println("当前二叉树为空，无法遍历！");
        }
    }

    // 中序遍历
    public void inorder() {
        if (this.root != null) {
            this.root.inorder();
        } else {
            System.out.println("当前二叉树为空，无法遍历！");
        }
    }

    // 后序遍历
    public void postorder() {
        if (this.root != null) {
            this.root.postorder();
        } else {
            System.out.println("当前二叉树为空，无法遍历！");
        }
    }

}
