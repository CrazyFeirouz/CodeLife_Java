package dataStructures.linkedlist.DoubleLinkedListDemo;

/**
 * @description: 双链表类
 * @author: Feirouz
 * @date: 2021-08-21 16:58
 */
public class DoubleLinkedList {
    // 先初始化一个头结点，头结点不操作，不存储具体数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 添加节点到单向链表 - 1 - 与单链表基本一致，添加步骤多了一步
     * 思路：（当不考虑编号顺序时）
     * 1. 找到当前链表的最后节点
     * 2. 将这个节点的next 指向新的节点
     * 3. 将新的节点的pre 指向 这个节点
     * 【注意】这种方式不要重复加一个同对象，可能循环走不出来了
     *
     * @param heroNode
     */
    public void add(HeroNode2 heroNode) {
        // 因为 head节点 不能动，因此我们需要一个辅助变量
        HeroNode2 temp = head;
        // 遍历链表，找到最后
        while (true) {  // 找到链表最后，退出循环
            if (temp.next == null) {
                break;
            }
            // 不是最后，继续temp后移
            temp = temp.next;
        }
        // 这时 temp 指向链表的最后
        // 形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    /* 删除节点 - 与单链表基本一致，删除逻辑需要注意
     * 1. 对于双向链表，我们可以直接找到要删除的这个节点
     * 2. 找到后，自我删除即可
     */
    public void del(int no) {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("当前链表为空，请添加数据后再来尝试");
            return;
        }
        // 非空，开始遍历
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {    // 到头了
                System.out.printf("找不到您需要删除的节点，编号[%d]\n", no);
                break;
            }
            if (temp.no == no) {   // 找到了
                temp.pre.next = temp.next;
                // 如果是最后一个节点，就不需要执行下面这一句话，否则会出现空指针
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
                break;
            }
            temp = temp.next;
        }
    }

    // 修改节点的信息，根据no编号来修改，即no编号不能改 - 与单链表一致，单纯 HeroNode 改为 HeroNode2
    // 说明
    // 1. 根据 newHeroNodde 的 no 来修改即可
    public void update(HeroNode2 newHeroNode) {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("当前链表为空，请添加数据后再来尝试");
            return;
        }
        HeroNode2 temp = head.next;
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

    // 显示链表【遍历】 - 与单链表一致，单纯 HeroNode 改为 HeroNode2
    public void showList() {
        // 判断链表是否为空
        if (head.next == null) {
            return;
        }
        // 不为空，开始遍历
        // 因为头结点不能动，因此我们需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
        while (true) {
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
