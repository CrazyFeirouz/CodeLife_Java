package dataStructures.tree.binarySortTree;

/**
 * @description: 二叉排序树的应用
 * @author: Feirouz
 * @date: 2022/3/26 17:18
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        // 循环的添加节点到二叉排序树
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            binarySortTree.add(node);
        }

        // 中序遍历二叉排序树
        binarySortTree.inorder();

        System.out.println("\n----删除----");
        binarySortTree.delNode(10);

        binarySortTree.inorder();
    }
}
