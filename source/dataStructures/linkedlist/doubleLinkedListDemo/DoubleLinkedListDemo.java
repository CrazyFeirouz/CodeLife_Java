package dataStructures.linkedlist.doubleLinkedListDemo;

import org.junit.Test;

/**
 * @description: 双向链表的测试
 * @author: Feirouz
 * @date: 2021-08-21 17:32
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        // 进行测试
        HeroNode2 hero1 = new HeroNode2(1, "小明", "超人");
        HeroNode2 hero2 = new HeroNode2(2, "小红", "潮人");
        HeroNode2 hero3 = new HeroNode2(3, "小黑", "炒人");
        HeroNode2 hero4 = new HeroNode2(4, "小白", "超忍");

        // 创建要给链表
        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.add(hero2);
        linkedList.add(hero4);
        linkedList.add(hero3);
        linkedList.add(hero1);

        // 显示
        linkedList.showList();

        System.out.println("================修改后=================");
        // 修改
        HeroNode2 newHeroNode = new HeroNode2(4, "小王", "钞人");
        linkedList.update(newHeroNode);

        // 显示
        linkedList.showList();

        // 删除
        System.out.println("================删除后=================");
        linkedList.del(3);

        linkedList.showList();

        /* 运行
            HeroNode{no=2, name='小红', nickname='潮人'}
            HeroNode{no=4, name='小白', nickname='超忍'}
            HeroNode{no=3, name='小黑', nickname='炒人'}
            HeroNode{no=1, name='小明', nickname='超人'}
            ================修改后=================
            HeroNode{no=2, name='小红', nickname='潮人'}
            HeroNode{no=4, name='小王', nickname='钞人'}
            HeroNode{no=3, name='小黑', nickname='炒人'}
            HeroNode{no=1, name='小明', nickname='超人'}
            ================删除后=================
            HeroNode{no=2, name='小红', nickname='潮人'}
            HeroNode{no=4, name='小王', nickname='钞人'}
            HeroNode{no=1, name='小明', nickname='超人'}
         */
    }

    @Test
    public void test1() {
        // 按顺序添加
        // 进行测试
        HeroNode2 hero1 = new HeroNode2(1, "小明", "超人");
        HeroNode2 hero2 = new HeroNode2(2, "小红", "潮人");
        HeroNode2 hero3 = new HeroNode2(3, "小黑", "炒人");
        HeroNode2 hero4 = new HeroNode2(4, "小白", "超忍");

        // 创建要给链表
        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.addByOrder(hero2);
        linkedList.addByOrder(hero4);
        linkedList.addByOrder(hero3);
        linkedList.addByOrder(hero1);
        linkedList.addByOrder(hero1);
        linkedList.addByOrder(hero4);

        /* 运行
            编号已存在，编号[1]
            编号已存在，编号[4]
            HeroNode{no=1, name='小明', nickname='超人'}
            HeroNode{no=2, name='小红', nickname='潮人'}
            HeroNode{no=3, name='小黑', nickname='炒人'}
            HeroNode{no=4, name='小白', nickname='超忍'}

         */



        linkedList.showList();
    }
}
