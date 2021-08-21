package dataStructures.linkedlist.singleLinkedListDemo;

import java.util.Stack;

/**
 * @description: 在之前正常的链表操作上新增功能
 * @author: Feirouz
 * @date: 2021-08-19 23:36
 *
 * 新增功能：逆序打印
 *  思路一：先将单链表进行反转操作，然后再遍历（会破坏原来的单链表结构，这里不使用）
 *  思路二：可以利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点，实现逆序打印效果
 */
public class SingleLinkedList4 extends SingleLinkedList{
    //逆序打印 - 这里直接使用了api，后面学到栈会重新写个结构来实现
    public static void reversePrint(HeroNode heroNode) {
        if (heroNode.next == null) {
            System.out.println("当前链表为空，请重新确认");
            return; // 空链表，不打印
        }
        // 创建要给一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = heroNode.next;  // 临时（指针）变量
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;   // temp后移，这样就可以压入下一个节点
        }
        // 将栈中的节点进行打印 - pop：出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());    // stack的特点是先进先出
        }
    }
}
