package dataStructures.linkedlist.DoubleLinkedListDemo;

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
    }
}
