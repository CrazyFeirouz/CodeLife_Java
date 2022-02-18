package dataStructures.tree.binaryTreeDemo;

/**
 * @description: 二叉树的节点 - HerNode节点
 * @author: Feirouz
 * @date: 2022-02-18 20:52
 */
public class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    // 左子节点 和 右子节点 默认为 null
    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    // 前序遍历的方法
    public void preorder() {
        // 1. 先输出父节点
        System.out.println(this);
        // 2. 递归向左子树
        if (this.left != null) {
            this.left.preorder();
        }
        // 3. 递归向右子树
        if (this.right != null) {
            this.right.preorder();
        }
    }

    // 中序遍历的方法
    public void inorder() {
        // 1. 递归向左子树
        if (this.left != null) {
            this.left.inorder();
        }
        // 2. 输出父节点
        System.out.println(this);
        // 3. 递归向右子树
        if (this.right != null) {
            this.right.inorder();
        }
    }

    // 后序遍历的方法
    public void postorder() {
        // 1. 递归向左子树
        if (this.left != null) {
            this.left.postorder();
        }
        // 2. 递归向右子树
        if (this.right != null) {
            this.right.postorder();
        }
        // 3. 输出父节点
        System.out.println(this);
    }
}
