package dataStructures.hashtable.practice.test1;

import dataStructures.hashtable.hashTableDemo.Emp;

/**
 * @description: 练习1（添加3个新功能）
 * @author: Feirouz
 * @date: 2022-02-17 14:34
 */
public class EmpLinkedList {
    // 头指针，指向第一个Emp，因此我们这个链表的head是直接指向第一个雇员的
    private Emp head;       // 默认为null

    // 添加雇员到链表
    // 说明
    // 1. 假设当添加雇员时，id是自增长的，即id的分配总是从小到大 -> 因此将该雇员直接加入到本链表的最后即可
    public void add(Emp emp) {
        // 如果是添加第一个雇员
        if (head == null) {
            head = emp;
        } else {
            // 如果不是第一个，需要辅助指针找到最后一个
            Emp curEmp = head;
            while (curEmp.next != null) {
                curEmp = curEmp.next;
            }
            // 说明到链表最后
            curEmp.next = emp;
        }
    }

    // 遍历链表的雇员信息
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + (no+1) + "链表为空");
        } else {
            System.out.print("第" + (no+1) + "链表为: ");
            Emp curEmp = head;
            do{
                System.out.print(curEmp + " ");
                curEmp = curEmp.next;
            }while (curEmp != null);
            System.out.println();
        }
    }

    // 根据id查找雇员
    // 如果查找到，就返回Emp；如果没找到，就返回null
    public Emp findEmpById(int id) {
        // 辅助指针
        Emp curEmp = head;
        while (curEmp != null) {
            if (curEmp.id == id) {
                return curEmp;
            }
            curEmp = curEmp.next;
        }
        // 没找到
        return null;
    }

    // 删除雇员功能
    public void del(int id) {
        if (head == null) {
            return;
        }
        Emp curEmp = head;
        // 头部符合时
        if (head.id == id) {
            if (curEmp.next == null) {  // 后面没指针了
                head = null;
            } else {
                curEmp = curEmp.next;
                head = curEmp;
            }
        } else {    // 非头部
            while (curEmp.next != null) {
                if (curEmp.next.id == id) {
                    curEmp.next = curEmp.next.next;
                    break;
                }
                curEmp = curEmp.next;
            }
        }
    }

    // 修改雇员功能
    public void edit(int id, String name) {
        // 未考虑编号重复问题
        Emp curEmp = head;
        while (curEmp != null) {
            if (curEmp.id == id) {
                curEmp.name = name;
                break;
            }
            curEmp = curEmp.next;
        }
    }

    // 俺顺序添加雇员功能 (哪个杀千刀的想用这玩意写“按顺序”,这玩意没有没用的头指针，还单向)
    public void addByOrder(Emp newEmp) {
        if (head == null) {         // 在头顶
            head = newEmp;
            return;
        }
        // 不考虑编号重复问题
        Emp temp = head;            // 第一个指针
        if (temp.id >= newEmp.id) { // 表示头指针就满足条件
            newEmp.next = temp;
            head = newEmp;
            return;
        }
        // 第二个指针 开始往后
        while (true) {
            if (temp.next == null) {    // 到链尾了
                break;
            }
            if (newEmp.id <= temp.next.id){   // 到位了
                break;
            }
            temp = temp.next;
        }
        // 开始插入
        newEmp.next = temp.next;
        temp.next = newEmp;
    }

}
