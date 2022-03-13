package dataStructures.hashtable.practice.test5;

import dataStructures.hashtable.hashTableDemo.Emp;

/**
 * @description: 哈希表 -> 链表
 * @author: Feirouz
 * @date: 2022-03-02 14:34
 */

// 创建一个EmpLinkedList，表示链表
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

    // 根据id删除雇员
    public void delEmpById (int id) {
        Emp curEmp = head;
        // 先判断头
        if (curEmp != null && curEmp.id == id) {
            head = curEmp.next;
        } else {
            while (curEmp != null && curEmp.next != null) {
                if (curEmp.next.id == id) {
                    curEmp.next = curEmp.next.next;
                    break;
                }
                curEmp = curEmp.next;
            }
        }
    }

    // 根据id修改雇员
    public void editEmp(Emp emp) {
        Emp curEmp = head;
        while (curEmp != null) {
            if (curEmp.id == emp.id) {
                curEmp.name = emp.name;
                break;
            }
            curEmp = curEmp.next;
        }
    }

    // 按顺序添加
    public void addByOrder(Emp emp) {
        // 临时值
        Emp curEmp = head;
        // 放在头位置 或者 插在头前面
        if (head == null || emp.id < curEmp.id) {
            emp.next = curEmp;
            head = emp;
        } else {    // 插在头后
            while (curEmp.next != null && curEmp.next.id < emp.id) {
                curEmp = curEmp.next;
            }
            emp.next = curEmp.next;
            curEmp.next = emp;
        }
    }
}
