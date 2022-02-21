package dataStructures.tree.arrBinaryTree;

public class ArrBinaryTree {
    private int[] arr;  // 存储数据节点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    // 重载该方法
    public void preorder() {
        this.preorder(0);
    }

    // 编写一个方法, 完成顺序存储二叉树的前序遍历
    public void preorder(int index) {
        // 如果数组为空 或者 arr.length = 0;
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空, 不能按照二叉树的前序遍历");
        }
        // 输出当前这个元素
        System.out.println(arr[index]);
        // 向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preorder(2 * index + 1);
        }
        // 向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            preorder(2 * index + 2);
        }
    }

    public void inorder() {
        this.inorder(0);
    }

    // 编写一个方法, 完成顺序存储二叉树的中序遍历
    public void inorder(int index) {
        // 如果数组为空 或者 arr.length = 0;
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空, 不能按照二叉树的前序遍历");
        }
        // 向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            inorder(2 * index + 1);
        }
        // 输出当前这个元素
        System.out.println(arr[index]);
        // 向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            inorder(2 * index + 2);
        }
    }

    public void postorder() {
        this.postorder(0);
    }

    // 编写一个方法, 完成顺序存储二叉树的后序遍历
    public void postorder(int index) {
        // 如果数组为空 或者 arr.length = 0;
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空, 不能按照二叉树的前序遍历");
        }
        // 向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            postorder(2 * index + 1);
        }
        // 向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            postorder(2 * index + 2);
        }
        // 输出当前这个元素
        System.out.println(arr[index]);
    }
}

