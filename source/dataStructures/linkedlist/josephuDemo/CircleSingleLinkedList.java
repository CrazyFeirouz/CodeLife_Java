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
        System.out.println();
    }

    // 求长度
    public int len() {
        if (first.next == null) {
            return 0;
        }
        int len = 1;
        Boy helper = first;
        // 计算有多少个小孩
        while (true) {
            if (helper.next == first) {
                break;
            }
            helper = helper.next;
            len++;
        }
        return len;
    }

    /**
     * 根据用户的输入，计算小孩出圈的顺序
     * @param startNo   表示从第几个小孩开始数
     * @param countNum  表示数几下
     */
    public void countBoy(int startNo, int countNum) {
        // 先对数据进行校验
        if(first == null || startNo < 1 || countNum > len()) {
            System.out.println("参数有误，请重新输入");
        }
        // 中间变量 helper，指向 first后面
        Boy helper = null;
        // 小孩报数前，先让first 移动 (startNo-1) + (countNum-1) 次 （即开始位置+数数位置）
        for (int i = 0; i < (startNo - 1) + (countNum - 1); i++) {
            if ( i == (startNo - 1) + (countNum - 1) - 1) {    // helper位于first后面
                // 中间变量 helper
                helper = first;
            }
            first = first.next;
        }
        if (helper == null) {
            System.out.println("程序错误");
            return;
        }
        // 当小孩报数时，让first和helper指针同时移动 countNum-1 次，然后出圈
        while (true) {
            if (helper == first) {  // 判断是否为最后一个
                System.out.printf("最后%d小孩出圈\n", first.no);
                break;
            }
            // 这时 first 指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n", first.no);
            // 开始取出
            first = first.next;
            helper.next = first;


            // 开始移动
            for (int i = 0; i < countNum - 1; i++) {
                first = first.next;
                helper = helper.next;
            }

        }
        System.out.println();
    }
}
