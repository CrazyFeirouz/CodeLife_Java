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

    // 前序查找
    public HeroNode preorderSearch(int no) {
        if (this.root != null) {
            return this.root.preorderSearch(no);
        } else {
            System.out.println("当前二叉树为空，无法查找！");
            return null;
        }
    }

    // 中序查找
    public HeroNode inorderSearch(int no) {
        if (this.root != null) {
            return this.root.inorderSearch(no);
        } else {
            System.out.println("当前二叉树为空，无法查找！");
            return null;
        }
    }

    // 后序查找
    public HeroNode postorderSearch(int no) {
        if (this.root != null) {
            return this.root.postorderSearch(no);
        } else {
            System.out.println("当前二叉树为空，无法查找！");
            return null;
        }
    }
}
