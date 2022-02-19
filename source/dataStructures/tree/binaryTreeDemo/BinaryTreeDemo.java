package dataStructures.tree.binaryTreeDemo;

/**
 * @description: 二叉树实例应用
 * @author: Feirouz
 * @date: 2022-02-18 20:49
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        // 先需要创建一棵二叉树
        BinaryTree binaryTree = new BinaryTree();
        HeroNode node1 = new HeroNode(1, "Fei");
        HeroNode node2 = new HeroNode(2, "Tom");
        HeroNode node3 = new HeroNode(3, "Gaiz");
        HeroNode node4 = new HeroNode(4, "Jek");

        // 说明，我们先动手创建该二叉树，后面我们学习递归的方式创建二叉树
        binaryTree.setRoot(node1);
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);

        // 测试

        // 1. 前序遍历
        System.out.println("===========前序===========");
        binaryTree.preorder();      // 1 -> 2 -> 3 -> 4

        // 2. 中序遍历
        System.out.println("===========中序===========");
        binaryTree.inorder();       // 2 -> 1 -> 3 -> 4

        // 3. 后序遍历
        System.out.println("===========后序===========");
        binaryTree.postorder();     // 2 -> 4 -> 3 -> 1

        // 4. 前序查找
        System.out.println("==========前序查找==========");
        HeroNode findVal = binaryTree.preorderSearch(3);
        System.out.println(findVal);

        // 5. 中序查找
        System.out.println("==========中序查找==========");
        HeroNode findVal2 = binaryTree.inorderSearch(31);
        System.out.println(findVal2);

        // 6. 前序查找
        System.out.println("==========后序查找==========");
        HeroNode findVal3 = binaryTree.postorderSearch(3);
        System.out.println(findVal3);
    }
}



