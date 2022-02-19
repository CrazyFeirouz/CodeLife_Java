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

    // 前序遍历查找
    public HeroNode preorderSearch(int no) {
        // 1. 比较当前节点是否是我们需要的
        if (this.no == no) {
            return this;
        }
        // 2. 创建临时值 Temp
        HeroNode resNode = null;
        // 3. 判断该节点的左子节点是否为null
        if (this.left != null) {                        // 不为null，左子节点递归查找
            resNode = this.left.preorderSearch(no);
        }
        if (resNode != null) {                          // 说明找到了
            return resNode;
        }
        // 4. 判断该节点的右子节点是否为null
        if (this.right != null) {
            resNode = this.right.preorderSearch(no);
        }
        // 5. 返回 Temp
        return resNode;
    }

    // 中序查找
    public HeroNode inorderSearch(int no) {
        // 1. 创建临时值 Temp
        HeroNode temp = null;
        // 2. 判断该节点的左子节点是否为null
        if (this.left != null) {
            temp = this.left.inorderSearch(no);
        }
        if (temp != null) {
            return temp;
        }
        // 3. 判断当前节点的no是否等于要查找的
        if (this.no == no) {
            return this;
        }
        // 4. 判断该节点的右子节点是否为null
        if (this.right != null) {
            temp = this.right.inorderSearch(no);
        }
        return temp;
    }

    // 后序查找
    public HeroNode postorderSearch(int no) {
        // 1. 创建临时值 Temp
        HeroNode temp = null;
        // 2. 判断该节点的左子节点是否为null
        if (this.left != null) {
            temp = this.left.postorderSearch(no);
        }
        if (temp != null) {
            return temp;
        }
        // 3. 判断该节点的右子节点是否为null
        if (this.right != null) {
            temp = this.right.postorderSearch(no);
        }
        // 4. 判断当前节点的no是否等于要查找的
        if (this.no == no) {
            return this;
        }
        // 5. 返回 Temp
        return temp;
    }
}
