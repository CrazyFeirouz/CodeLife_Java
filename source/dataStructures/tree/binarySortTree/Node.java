package dataStructures.tree.binarySortTree;

/**
 * @description: 二叉排序树的节点
 * @author: Feirouz
 * @date: 2022/3/26 17:18
 */
public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
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
