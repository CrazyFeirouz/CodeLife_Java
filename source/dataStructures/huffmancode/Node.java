package dataStructures.huffmancode;

/**
 * @description: 赫夫曼编码的节点
 * @author: Feirouz
 * @date: 2022/3/21 21:36
 */
public class Node implements Comparable<Node>{
    Byte data;      // 存放数据(字符)本身, 比如 "a" => 97, ' ' => 32
    int weight;     // 权值, 表示字符出现的次数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        // 从小到大
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    // 前序遍历
    public void preorder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preorder();
        }
        if (this.right != null) {
            this.right.preorder();
        }
    }
}
