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
//        String content = "i like like like java do you like a java";
        String content = "hello world";
//        String content = "hello word";
        byte[] contentByte = content.getBytes(StandardCharsets.UTF_8);
//        System.out.println(contentByte.length);     // 40

        // 测试 - 关于 byte 与 str/int 的转换
//        String str = "10000000";
//        Integer integer = Integer.parseInt(str);
//        System.out.println(integer);
//        int intNum = integer;
//        System.out.println(intNum);
//        System.out.println((byte)intNum);
//        System.out.println(Byte.parseByte(str));

        byte[] bytes = huffmanZip(contentByte);
        System.out.println(Arrays.toString(bytes));

        System.out.println(byteToBitString(true, (byte) 0));

        byte[] decodeByte = decode(huffmanCodes, bytes);
        System.out.println("转换 " + Arrays.toString(decodeByte));
        System.out.println(new String(decodeByte));

    }

    // 完成数据的解压
    // 思路
    // 1. 将huffmanCodeBytes [-88, -65, -56...] 重新先转成 赫夫曼编码对应的二进制字符串 "10101000..."
    // 2. 赫夫曼编码对应的二进制的字符串 "1010100..." => 对照 赫夫曼编码 => "i like like..."

    /**
     * 编写一个方法, 完成对压缩数据的解码
     * @param huffmanCodes 赫夫曼编码表map
     * @param huffmanBytes 和魔法编码得到的字节数组
     * @return 原来字符串对应的数组
     */
    public static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        // 1. 先得到 huffmanBytes 对应的二进制的字符串, 形式 10101000...
        StringBuilder stringBuilder = new StringBuilder();
        // 将 byte数组 转成 二进制的字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            // 判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(flag, b));
        }

        // 将map反过来
        HashMap<String, Byte> huffmanDeCodes = new HashMap<>();
        for(Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            huffmanDeCodes.put(entry.getValue(), entry.getKey());
        }
        // 创建集合, 存放byte
        List<Byte> list = new ArrayList<>();
        // i 理解为 索引, 扫描 stringBuilder
        int i = 0;
        String temp = "";
        while (i < stringBuilder.length()) {
            // Map - ' '->01 'a'->100 ...
            while (i < stringBuilder.length() && !huffmanCodes.containsValue(temp)) {
                temp = temp + String.valueOf(stringBuilder.charAt(i));
                i++;
            }
            if (huffmanDeCodes.get(temp) != null) {
                list.add(Byte.valueOf(huffmanDeCodes.get(temp)));
            }
            temp = "";
        }

        // 将list转为byte[]
        byte[] bytes = new byte[list.size()];
        for (int j = 0; j < bytes.length; j++) {
            bytes[j] = list.get(j);
        }

        return bytes;
    }

    /**
     * 将一个byte转成一个二进制的字符串
     * @param flag 标志着是是最后一位. true->是, false->否. 如果是最后一个字节, 无需补高位
     * @param b 传入的 byte
     * @return 该b 对应的二进制的字符串 (按补码返回)
     */
    public static String byteToBitString(boolean flag, byte b) {
        // 使用变量保存b
        int temp = b;           // 将b转成int - 这里的 int 是32位的, 若是负数, 请自行将其缩短至8位

        if (!flag) {            // 非最后一位
            // 如果是正数我们还存在补高位 (负数就算运算也不会受影响)
            temp |= 256;        // 按位或 256=>1 0000 0000 | 0000 0001 => 1 0000 0001
        } else {                // 最后一位,我们只取后8位部分
            temp &= 255;        // 按位与 255=>  1111 1111 & ... 0000 0001 => 0000 0001
        }
        // 将byte值 转成 二进制的str字符串
        String str = Integer.toBinaryString(temp);      // str为temp对应的二进制的"补码"

        if (!flag) {            // 不管正数还是负数, 通通截取后8位
            return str.substring(str.length() - 8);
        } else {                // 最后一位没补, 所以直接过去
            for (int i = 0; i < endCodeZeroStartCount; i++) {
                str = "0" + str;
            }
            return str;
        }
    }

    // ===========================分割===============================

    /**
     * 使用一个方法, 将前面的方法封装起来, 便于我们的调用
     * @param bytes 原始的字符串对应的字节数组
     * @return 经过 赫夫曼编码处理后的字节数组(压缩后的数组)
     */
    public static byte[] huffmanZip(byte[] bytes) {
        // 将字节数组对应的 key-value 统计出来放置在 arraylist 中
        List<Node> nodelist = getNodes(bytes);
        // 根据 nodelist 创建赫夫曼树
        Node huffmanTree = createHuffmanTree(nodelist);
        // 根据对应的赫夫曼树 获取 对应的编码
        Map<Byte, String> codes = getCodes(huffmanTree);
        // 将赫夫曼编码(十进制表示二进制版)转成bute[], 根据生成的赫夫曼编码, 压缩得到压缩后的赫夫曼编码字节数组
        byte[] huffmanCodeBytes = zip(bytes, codes);

        return huffmanCodeBytes;
    }

    // ===========================分割===============================

    private static int endCodeZeroStartCount = 0;  // 结尾字符前面的零个数

    /**
     * 编写一个方法, 将字符串对应byte[] 数组, 通过生成得赫夫曼编码表, 返回一个赫夫曼编码 压缩后得bute[]
     * @param bytes 这时原始得字符串对应得bute[]
     * @param huffmanCodes 生成得赫夫曼编码map
     * @return 返回赫夫曼编码处理后的 byte[]
     * 将字符串 "i like..." => "10101..."
     *      每8位二进制对应一位byte -- "10101000(补码)" => "11011000" => -88
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        // 1. 利用 huffmanCodes 将 bytes 转成 赫夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        // 遍历 bytes 数组
        for (byte aByte : bytes) {
            stringBuilder.append(huffmanCodes.get(aByte));
        }

        // 将 "10101000..." 转成byte[]

        // 统计返回 byte[] huffmanCodeBytes 长度
        int len = (stringBuilder.length() + 7) / 8;

        // 创建 huffmanCodeBytes
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String curStr;
            if (i + 8 > stringBuilder.length()) {       // 不够 8 位
                for (int j = i; j < stringBuilder.length(); j++) {
                    if (stringBuilder.charAt(j) == '0') {
                        endCodeZeroStartCount++;
                    } else {
                        break;
                    }
                }
                curStr = stringBuilder.substring(i);
            } else {                                    // 正好 8 位
                curStr = stringBuilder.substring(i, i + 8);
            }

             // 将 strByte 转成一个byte, 放到huffmanCodeBytes种
//            huffmanCodeBytes[index] = Byte.parseByte(curStr);     // 该种方法会把 你的str数值 完完全全保存成 对应的byte大小数值
            huffmanCodeBytes[index] = (byte) Integer.parseInt(curStr, 2);      // 所以我们需要先把 str 改成 int, 再改成 byte

            index++;
        }
        return huffmanCodeBytes;
    }

    // ===========================分割===============================

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
    public static Map<Byte, String> huffmanCodes = new HashMap<>();
    // 创一个获取该属性的方法, 方便后序调用
    public static Map<Byte, String> getHuffmanCodes() {
        return huffmanCodes;
    }
    // 2. 在生成赫夫曼编码表示, 需要去拼接路径, 定义一个StringBuilder 存放某个叶子节点的路径
//    static StringBuilder stringBuilder = new StringBuilder();

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


