package dataStructures.tree.binarySortTree;

/**
 * @description: 二叉排序树的节点
 * @author: Feirouz
 * @date: 2022/3/26 17:18
 */
public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 查找要删除节点的父节点
     * @param value 要删除节点的值
     * @return 返回要删除节点的父节点, 没有就返回null
     */
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            // 查找的值小于当前节点的值, 当前节点的左子节点不为null
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);                   // 向左递归
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);                  // 向右递归
            } else {
                return null;    // 没有找到
            }
        }
    }

    /**
     * 查找要删除的节点
     * @param value 希望删除节点的值
     * @return 找到的节点, 若没有返回null
     */
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {    // 查找的值小于当前节点, 向左字数递归查找
            if (this.left != null) {
                return this.left.search(value);
            }
            return null;
        } else {                            // 查找的值大于等于当前节点, 向右递归查找
            if (this.right != null) {
                return this.right.search(value);
            }
            return null;
        }
    }

    /**
     * 添加节点的方式
     * @param newNode 新节点
     * 递归的形式添加节点, 注意要曼珠二叉排序树的要求
     */
    public void add(Node newNode) {
        if (newNode == null) {
            return;
        }

        // 判断传入的节点的值 和 当前字数的根节点值 的 关系
        if (newNode.value < this.value) {
            if (this.left == null) {    // 若左子树为空
                this.left = newNode;
            } else {                    // 若左子树不为空
                this.left.add(newNode);
            }
        } else {
            if (this.right == null) {
                this.right = newNode;
            } else {
                this.right.add(newNode);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void inorder() {
        // 左
        if (this.left != null) {
            this.left.inorder();
        }
        // 中
        System.out.printf(this.value + " ");
        // 后
        if (this.right != null) {
            this.right.inorder();
        }

    }
}
