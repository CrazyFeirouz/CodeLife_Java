package dataStructures.linkedlist.josephuDemo;

/**
 * @description: 环形链表实现类
 * @author: Feirouz
 * @date: 2021-08-21 21:39
 */
public class CircleSingleLinkedList {
    // 创建一个first节点，当前没有编号
    private Boy first = new Boy(-1);

    // 添加小孩节点，构建成一个环形链表
    public void addBoy(int nums) {
        // 做一个数据校验x
        if (nums < 1) {
            System.out.println("nums数值错误，请检查");
            return;
        }
        Boy curBoy = null;
        // 使用for来创建我们的环形链表
        for (int i = 1; i <= nums; i++) {
            // 根据编号，创建小孩节点
            Boy newBoy = new Boy(i);
            if (i == 1) {   // 第一个节点，让它指向自己
                first = newBoy;
                first.next = first; // 构成环
                curBoy = first;     // 让curBoy指向第一个小孩
            } else {
                curBoy.next = newBoy;
                newBoy.next = first;
                curBoy = newBoy;
            }
        }
    }

    // 遍历当前的环形链表
    public void showList() {
        // 判断链表是否为空
        if (first == null) {
            System.out.println("当前链表为空");
            return;
        }
        // 因为first不能动，因此我们仍使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            String noStr = (curBoy.no < 10) ? "0" + curBoy.no : "" + curBoy.no;
            System.out.printf("[%s]\t", noStr);
            if (curBoy.next == first) { // 说明遍历完毕
                break;
            }
            curBoy = curBoy.next;
        }
    }
}
