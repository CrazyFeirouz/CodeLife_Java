package dataStructures.linkedlist;

/**
 * @description: 带头结点的单链表应用实例
 * @author: Feirouz
 * @date: 2021-08-18 18:03
 *
 * 实现水浒传英雄排行榜管理
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        // 进行测试
        HeroNode hero1 = new HeroNode(1, "小明", "超人");
        HeroNode hero2 = new HeroNode(2, "小红", "潮人");
        HeroNode hero3 = new HeroNode(3, "小黑", "炒人");
        HeroNode hero4 = new HeroNode(4, "小白", "超忍");

        // 创建要给链表
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.add(hero1);
        linkedList.add(hero2);
        linkedList.add(hero3);
        linkedList.add(hero4);

        // 显示
        linkedList.showList();
    }

}

// 带头结点的单链表，管理我们的英雄
class SingleLinkedList {
    // 先初始化一个头结点，头结点不操作，不存储具体数据
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 添加节点到单向链表
     * 思路：（当不考虑编号顺序时）
     * 1. 找到当前链表的最后节点
     * 2. 将这个节点的next 指向新的节点
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        // 因为 head节点 不能动，因此我们需要一个辅助变量
        HeroNode temp = head;
        // 遍历链表，找到最后
        while (true) {  // 找到链表最后，退出循环
            if (temp.next == null) {
                break;
            }
            // 不是最后，继续temp后移
            temp = temp.next;
        }
        // 这时 temp 指向链表的最后
        // 将 新的 HeroNode 加入链表
        temp.next = heroNode;
    }

    // 显示链表【遍历】
    public void showList() {
        // 判断链表是否为空
        if (head.next == null) {
            return;
        }
        // 不为空，开始遍历
        // 因为头结点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true){
            if (temp == null) { // 判断是否到链表最后
                break;
            }
            // 输出节点信息
            System.out.println(temp);
            // 将temp后移
            temp = temp.next;
        }
    }
}

// 定义HeroNode，每一个HeroNode 对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;   // 指向下一个节点

    // 构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    // 为了显示方法，我们重新toString
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}