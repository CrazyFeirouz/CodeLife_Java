package dataStructures.linkedlist.SingleLinkedListDemo;

/**
 * @description: 在之前正常的链表操作上新增功能
 * @author: Feirouz
 * @date: 2021-08-19 21:25
 *
 * 功能新增：查找单链表中的倒数第k个节点
 */
public class SingleLinkedList2 extends SingleLinkedList {
    // 查找单链表中的倒数第k个节点
    public static HeroNode getLastIndexNode(HeroNode heroNode, int index) {
        if (heroNode.next == null) {    // 空链表
            return null;
        }
        // 第一次遍历得到链表的长度
        int len = SingleLinkedList.getLength(heroNode);
        // 第二次遍历
        // 先做index的校验
        if (index <= 0 || index > len) {
            System.out.println("输入下标不合理，请重新确认后输入");
            return null;
        }
        for (int i = 0; i < len - index + 1; i++) {  // 4-2+1=3，从头移动3下，到达第三个节点，即倒数第二个节点
            heroNode = heroNode.next;
        }
        return heroNode;
    }
}
