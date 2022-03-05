package dataStructures.tree.huffmanTree;

/**
 * @description: 赫夫曼树节点 - Node
 * @author: Feirouz
 * @date: 2022-02-18 20:52
 */

/**
 * 为了让Node对象可Collections集合排序
 * 让其实现Comparable接口
 */
public class Node implements Comparable<Node>{
    public int val;        // 节点权值
    public Node left;      // 左子节点
    public Node right;     // 右子节点

    public Node (int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        // 表示从小到大排
        return this.val - o.val;
    }

    // 前序遍历
    public void preorder() {
        System.out.println(val);
        // 向左
        if (left != null) {
            left.preorder();
        }
        // 向右
        if (right != null) {
            right.preorder();
        }
    }
}
