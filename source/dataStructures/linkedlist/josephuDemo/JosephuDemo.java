package dataStructures.linkedlist.josephuDemo;

/**
 * @description: 双向链表的应用实例
 * @author: Feirouz
 * @date: 2021-08-21 23:40
 */
public class JosephuDemo {
    public static void main(String[] args) {
        // 测试
        CircleSingleLinkedList linkedList = new CircleSingleLinkedList();
        linkedList.addBoy(25);
        linkedList.showList();

        int len = linkedList.len();
        System.out.println(len);

        // 约瑟夫问题的实现
        linkedList.countBoy(1,2);
    }
}
