package dataStructures.tree.arrBinaryTree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);

        System.out.println("======前序遍历=======");
        arrBinaryTree.preorder();

        System.out.println("======中序遍历=======");
        arrBinaryTree.inorder();

        System.out.println("======后续遍历=======");
        arrBinaryTree.postorder();
    }
}
