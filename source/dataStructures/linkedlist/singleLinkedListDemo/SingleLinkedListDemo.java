package dataStructures.linkedlist.singleLinkedListDemo;

import org.junit.Test;

/**
 * @description: 带头结点的单链表应用实例
 * @author: Feirouz
 * @date: 2021-08-18 18:03
 *
 * 实现水浒传英雄排行榜管理
 */
public class SingleLinkedListDemo {
    // 基本使用
    public static void main(String[] args) {
        // 进行测试
        HeroNode hero1 = new HeroNode(1, "小明", "超人");
        HeroNode hero2 = new HeroNode(2, "小红", "潮人");
        HeroNode hero3 = new HeroNode(3, "小黑", "炒人");
        HeroNode hero4 = new HeroNode(4, "小白", "超忍");

        // 创建要给链表  【注意】这种方式不要重复加同一个对象，可能循环走不出来了
//        SingleLinkedList linkedList = new SingleLinkedList();
//        linkedList.add(hero2);
//        linkedList.add(hero4);
//        linkedList.add(hero3);
//        linkedList.add(hero1);
////        linkedList.add(hero4);

        /* 运行结果：
            HeroNode{no=2, name='小红', nickname='潮人'}
            HeroNode{no=4, name='小白', nickname='超忍'}
            HeroNode{no=3, name='小黑', nickname='炒人'}
            HeroNode{no=1, name='小明', nickname='超人'}
         */

        // 创建要给链表
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addByOrder(hero2);
        linkedList.addByOrder(hero2);
        linkedList.addByOrder(hero4);
        linkedList.addByOrder(hero3);
        linkedList.addByOrder(hero1);

        // 修改数据
        HeroNode newHeroNode1 = new HeroNode(2, "小李", "超刃");
        HeroNode newHeroNode2 = new HeroNode(5, "小王", "钞人");
        linkedList.update(newHeroNode1);
        linkedList.update(newHeroNode2);

        // 删除数据
        linkedList.del(3);

        /* 运行结果：
            编号已存在，编号[2]
            没有找到你想要修改的编号[5]
            HeroNode{no=1, name='小明', nickname='超人'}
            HeroNode{no=2, name='小李', nickname='超刃'}
            HeroNode{no=4, name='小白', nickname='超忍'}
         */

        // 显示
        linkedList.showList();
    }

    // 练手题目
    @Test
    public void test() {
        // 进行测试
        HeroNode hero1 = new HeroNode(1, "小明", "超人");
        HeroNode hero2 = new HeroNode(2, "小红", "潮人");
        HeroNode hero3 = new HeroNode(3, "小黑", "炒人");
        HeroNode hero4 = new HeroNode(4, "小白", "超忍");

        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addByOrder(hero2);
        linkedList.addByOrder(hero4);
        linkedList.addByOrder(hero3);
        linkedList.addByOrder(hero1);

        linkedList.showList();

        System.out.println("=================================================");

        // 获取链表有效节点个数
        int length = SingleLinkedList.getLength(linkedList.getHead());
        System.out.println(length);

        System.out.println("=================================================");

        // 获取倒数第二个节点
        HeroNode lastIndexNode = SingleLinkedList2.getLastIndexNode(linkedList.getHead(), 2);
        System.out.println(lastIndexNode);

        System.out.println("=================================================");

        // 反转链表
        SingleLinkedList3.reverseList(linkedList.getHead());
        linkedList.showList();

        System.out.println("=================================================");

        // 逆序打印
        SingleLinkedList4.reversePrint(linkedList.getHead());


    }

}

