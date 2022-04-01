package dataStructures.tree.binarySortTree;

/**
 * @description: 二叉排序树
 * @author: Feirouz
 * @date: 2022/3/26 17:18
 */
public class BinarySortTree {
    private Node root;

    /**
     * 删除节点
     * @param value 要删除的节点值
     */
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            // 1. 先去找要删除的节点 targetNode
            Node targetNode = search(value);
            // 如果没又找到要删除的节点
            if (targetNode == null) {
                return;
            }
            // 如果我们发下您当前这颗二叉排序树只有一个根节点 且根节点是我们要删的
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            // 找到 targeNode 的 父节点
            Node parent = searchParent(value);
            // 情况一: 如果要删除的节点是叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                // 判断 targetNode 是 父节点的 左/右子节点
                if (parent.left != null && parent.left.value == value) {            // 是左子节点
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {   // 是右子节点
                    parent.right = null;
                }
            // 情况三: targetNode 有左右子节点
            } else if (targetNode.left != null && targetNode.right != null) {
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            // 情况二: targeNode 有一条子节点
            } else {
                // 如果要删除的 节点 是 左子节点
                if (targetNode.left != null) {
                    // 如果 targetNode 是 parent 的左子节点
                    if (parent.left.value == value) {
                        parent.left = targetNode.left;
                    } else {
                        parent.right = targetNode.left;
                    }
                } else {    // 如果要删除 的 节点 只有 右子节点
                    // 如果 targetNode 是 parent 的左子节点
                    if (parent.left.value == value) {
                        parent.left = targetNode.right;
                    } else {
                        parent.right = targetNode.right;
                    }
                }
            }
        }
    }

    // 编写
    // 1. 返回的 以node 为根节点的二叉排序树的最小节点的值
    // 2. 删除node 为根节点的 二叉排序树的最小节点
    public int delRightTreeMin(Node node) {
        Node target = node;
        // 循环的查找左子节点, 就会找到最小值
        while (target.left != null) {
            target = target.left;
        }
        // 这时target到达最小节点
        // 删除最小节点
        delNode(target.value);
        return target.value;
    }

    /**
     * 查找父节点
     * @param value 查找的节点值
     * @return 返回找到的父节点
     */
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * 查找节点
     * @param value 查找的节点值
     * @return 返回找到的节点
     */
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

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
