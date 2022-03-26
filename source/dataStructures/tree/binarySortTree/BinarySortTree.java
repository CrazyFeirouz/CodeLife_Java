package dataStructures.tree.binarySortTree;

/**
 * @description: 二叉排序树
 * @author: Feirouz
 * @date: 2022/3/26 17:18
 */
public class BinarySortTree {
    private Node root;

    /**
     * 添加节点的方法
     * @param node 想要添加的节点
     */
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    /**
     * 中序遍历
     */
    public void inorder() {
        if (root == null) {
            System.out.println("为null,无法遍历");
        } else {
            root.inorder();
        }
    }
}
