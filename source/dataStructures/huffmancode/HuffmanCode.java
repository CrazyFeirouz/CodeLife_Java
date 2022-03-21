package dataStructures.huffmancode;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @description: 哈夫曼编码
 * @author: Feirouz
 * @date: 2022/3/21 21:34
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentByte = content.getBytes(StandardCharsets.UTF_8);
        System.out.println(contentByte.length);     // 40

        // 将字节数组对应的 key-value 统计出来放置在 arraylist 中
        List<Node> nodelist = getNodes(contentByte);
        System.out.println(nodelist);

        // 创建赫夫曼树
        Node huffmanTree = createHuffmanTree(nodelist);
        huffmanTree.preorder();

    }

    /**
     * 将字节数组对应的 key-value 统计出来放置在 arraylist 中
     * @param bytes 接收字节数组
     * @return 返回list形式
     */
    private static List<Node> getNodes(byte[] bytes) {
        // 1. 创建一个Arraylist
        ArrayList<Node> list = new ArrayList<>();

        // 遍历 bytes, 统计每一个byte出现的次数 -> map[key, value]
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte aByte : bytes) {
            if (!counts.containsKey(aByte)) {   // 不包含, 说明第一次遇到
                counts.put(aByte, 1);
            } else {
                counts.put(aByte, counts.get(aByte) + 1);
            }
        }

        // 把每个键值对转成一个Node对象并加入list集合
        // 遍历map
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            list.add(node);
        }

        return list;
    }

    /**
     * 创建赫夫曼树
     * @param nodes 具有 数据和权值 的Node数组
     * @return 赫夫曼树的根节点
     */
    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            // 1. 排序
            Collections.sort(nodes);

            // 2. 取出前两个
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            // 3. 创建一颗新的二叉树, 他的根节点没有data, 只有权值
            Node parentNode = new Node(null, leftNode.weight + rightNode.weight);
            parentNode.left = leftNode;
            parentNode.right = rightNode;

            // 4. 重置list
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parentNode);
        }
        // 最后的节点, 就是赫夫曼树的根节点
        return nodes.get(0);
    }
}


