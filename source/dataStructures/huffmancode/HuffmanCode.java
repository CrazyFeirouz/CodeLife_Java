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
//        huffmanTree.preorder();

        // 测试生成的赫夫曼编码
        Map<Byte, String> codes = getCodes(huffmanTree);
        System.out.println(codes);

    }

    // 为了调用方便, 我们重载 getCodes
    private static Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            return null;
        }
        // 处理root左子树
        getCodes(root.left, "0", new StringBuilder());
        // 处理root右子树
        getCodes(root.right, "1", new StringBuilder());
        return huffmanCodes;
    }

    // 生成赫夫曼树对应的赫夫曼编码
    // 思路:
    // 1. 将赫夫曼编码表存放在Map<Byte, String>
    //  如 32->01 97->100 ...
    static Map<Byte, String> huffmanCodes = new HashMap<>();

    /**
     * 功能: 将传入的node节点, 并且同时获得对应node节点的编码, 放入到huffmanCode集合返回
     * @param node 节点
     * @param code 路径: 左子节点-0 右子节点-1
     * @param stringBuilder 用于拼接路径
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        // 将code加入到stringBuilder2
        stringBuilder2.append(code);
        if (node != null) { // 如果node == null - 不处理
            // 判断当前弄得是叶子节点还是非叶子节点
            if (node.data == null) {    // 非叶子节点
                // 递归处理
                // 向左递归
                getCodes(node.left, "0", stringBuilder2);
                // 向右递归
                getCodes(node.right, "1", stringBuilder2);
            } else {        // 说明是一个叶子节点
                // 就表示找到某个叶子叶子节点的最后
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }



    // ===========================分割===============================

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


