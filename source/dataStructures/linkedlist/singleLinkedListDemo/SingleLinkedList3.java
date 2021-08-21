package dataStructures.linkedlist.singleLinkedListDemo;

/**
 * @description: 在之前正常的链表操作上新增功能
 * @author: Feirouz
 * @date: 2021-08-19 21:27
 *
 * 功能新增：将链表反转
 */
public class SingleLinkedList3 extends SingleLinkedList{
    // 将链表反转
    public static void reverseList(HeroNode heroNode) {
        // 如果当前链表为空，或且只有一个节点，无需反转直接返回
        if (heroNode.next == null || heroNode.next.next == null) {
            return;
        }

        // 定义一个辅助的指针（变量），帮助我们遍历原来的链表
        HeroNode temp = heroNode.next;
        // 记录当前节点的下一个节点
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        // 遍历原来的链表，每遍历一个节点，将其取出，并放在新的链表reverseHead 的最前端
        while (temp != null){
            next = temp.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            temp = next;
        }
        // 将 heroNode.next 指向 reverseHead.next ，结束单链表反转
        heroNode.next = reverseHead.next;
    }
}
