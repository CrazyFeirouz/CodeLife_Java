package dataStructures.tree.huffmanTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description: 赫夫曼树
 * @author: Feirouz
 * @date: 2022-03-05 19:17
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node huffmanTree = createHuffmanTree(arr);

        // 测试
        preorder(huffmanTree);
    }

    // 前序遍历的方法
    public static void preorder(Node root) {
        if (root != null) {
            root.preorder();
        } else {
            System.out.println("当前为null");
        }
    }

    /**
     * 创建赫夫曼树的方法
     * @param arr 需要创建成赫夫曼树的数组
     * @return 创建好后赫夫曼树的根节点
     */
    public static Node createHuffmanTree(int[] arr) {
        // 一. 为了操作方便
        //  1. 遍历arr数组
        //  2. 将arr的每一个元素构成一个Node
        //  3. 将Node放入到ArrayList中
        List<Node> nodes = new ArrayList<>();
        for (int val : arr) {
            nodes.add(new Node(val));
        }

        while (nodes.size() > 1) {
            // 4.排序 - 从小到大
            Collections.sort(nodes);

            System.out.println("处理：" + nodes);

            // 二.取出根节点权值最小的两棵二叉树
            //  1. 取出权值最小的节点（二叉树）
            Node leftNode = nodes.get(0);
            //  2. 取出第二小的节点（二叉树）
            Node rightNode = nodes.get(1);
            //  3. 构建一棵新的二叉树
            Node parent = new Node(leftNode.val + rightNode.val);
            parent.left = leftNode;
            parent.right = rightNode;

            //  4. 从ArrayList中删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            //  5. 将parent加入nodes
            nodes.add(parent);
        }
        System.out.println("处理：" + nodes);
        return nodes.get(0);
    }
}
