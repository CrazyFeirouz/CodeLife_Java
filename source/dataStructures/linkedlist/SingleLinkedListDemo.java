package dataStructures.linkedlist;

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

        // 获取倒数第二个节点
        HeroNode lastIndexNode = SingleLinkedList.getLastIndexNode(linkedList.getHead(), 2);
        System.out.println(lastIndexNode);


    }

}

// 带头结点的单链表，管理我们的英雄
class SingleLinkedList {
    // 先初始化一个头结点，头结点不操作，不存储具体数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead(){
        return head;
    }

    /**
     * 添加节点到单向链表 - 1
     * 思路：（当不考虑编号顺序时）
     * 1. 找到当前链表的最后节点
     * 2. 将这个节点的next 指向新的节点
     * 【注意】这种方式不要重复加一个同对象，可能循环走不出来了
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

    /**
     * 添加节点到单向链表 - 2
     * 思路：（考虑编号顺序时）
     * 1. 找到添加位置前一个节点
     * 2. 将 添加的节点.next = 添加位置 前一个节点.next
     * 3. 添加位置 前一个节点.next = 添加的节点
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        // 因为 head节点 不能动，因此我们需要一个辅助变量
        HeroNode temp = head;
        boolean flag = false;   // flag：表示添加的编号是否存在（若重复则为true）
        while (true) {
            if (temp.next == null) {    //判断是否是链尾
                break;
            }
            if (heroNode.no < temp.next.no) {   // 位置判断，heroNode的编号必定要比heroNode.next的编号小
                break;
            } else if(heroNode.no == temp.next.no) {  // 说明想添加的编号已经存在
                flag = true;
                break;
            }
            temp = temp.next;   // 后移，遍历当前链表
        }
        if (flag) { // 说明重复编号
            System.out.printf("编号已存在，编号[%d]\n", heroNode.no);
        } else {    // 说明已找到位置插入
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    // 修改节点的信息，根据no编号来修改，即no编号不能改
    // 说明
    // 1. 根据 newHeroNodde 的 no 来修改即可
    public void update(HeroNode newHeroNode) {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("当前链表为空，请添加数据后再来尝试");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) { // 到头了
                // 找不到的情况
                System.out.printf("没有找到你想要修改的编号[%d]\n", newHeroNode.no);
                break;
            }
            if (temp.no == newHeroNode.no) {    // 找到了当前相同no的节点
                // 开始修改数据
                temp.nickname = newHeroNode.nickname;
                temp.name = newHeroNode.name;
                break;
            }
            temp = temp.next;
        }
    }

    // 删除节点
    public void del(int no) {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("当前链表为空，请添加数据后再来尝试");
            return;
        }
        // 非空，开始遍历
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {    // 到头了
                System.out.printf("找不到您需要删除的节点，编号[%d]\n", no);
                break;
            }
            if (temp.next.no == no) {   // 找到了
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }

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

    /**
     * 获取到单链表的节点的个数（如果是带头结点的链表，不统计头结点）
     * @param heroNode 链表的头结点
     * @return 返回链表有效节点个数
     */
    public static int getLength(HeroNode heroNode) {
        if (heroNode.next == null) {    // 空链表
            return 0;
        }
        int len = 0;
        // 定义一个辅助变量
        HeroNode temp = heroNode.next;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

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
        for (int i = 0; i < len - index + 1; i++){  // 4-2+1=3，从头移动3下，到达第三个节点，即倒数第二个节点
            heroNode = heroNode.next;
        }
        return heroNode;
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