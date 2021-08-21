package dataStructures.linkedlist.DoubleLinkedListDemo;

/**
 * @description: 双链表节点类
 * @author: Feirouz
 * @date: 2021-08-19 21:23
 */ // 定义HeroNode，每一个HeroNode 对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;      // 指向下一个节点，默认为null
    public HeroNode2 pre;       // 指向前一个节点，默认为null

    // 构造器
    public HeroNode2(int no, String name, String nickname) {
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
