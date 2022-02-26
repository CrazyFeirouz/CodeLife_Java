package dataStructures.tree.threadBinaryTreeDemo;

public class ThreadBinaryTreeDemp {
    public static void main(String[] args) {
        // 测试一把中序线索二叉树的功能
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        // 二叉树, 后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        // 测试中序线索化
        ThreadBinaryTree threadBinaryTree = new ThreadBinaryTree();
        threadBinaryTree.setRoot(root);
        threadBinaryTree.inorderThreadNodes();

        // 测试: 以10号节点测试
        HeroNode leftNode = node5.getLeft();
        System.out.println("10号节点的前驱: " + leftNode);    // 10号节点的前驱: HeroNode{no=3, name='jack'}
        HeroNode rightNode = node5.getRight();
        System.out.println("10号节点的后继: " + rightNode);   // 10号节点的后继: HeroNode{no=1, name='tom'}

        // 使用线索化方式遍历
        System.out.println("===========使用线索化的方式遍历==========");
        threadBinaryTree.threadedList();
    }
}
