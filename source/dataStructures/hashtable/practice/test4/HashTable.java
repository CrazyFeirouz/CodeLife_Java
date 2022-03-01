package dataStructures.hashtable.practice.test4;

import dataStructures.hashtable.hashTableDemo.Emp;

/**
 * @description: 哈希表
 * @author: Feirouz
 * @date: 2022-02-16 23:30
 */

// 创建HashTable， 管理多条链表
public class HashTable {
    private EmpLinkedList[] empLinkedLists;
    private int size;

    // 构造器
    public HashTable(int size) {
        this.size = size;
        // 初始化 empLinkedLists
        empLinkedLists = new EmpLinkedList[size];
        // 留一个坑，后面还需要写什么？
        // 上面那样创建，里面其实还是null
        // 引用对象默认值是null，不是int哦，int才有0啊这种默认值
        // so
        for (int i = 0; i < empLinkedLists.length; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    // 添加雇员
    public void add(Emp emp) {
        // 根据员工的id，
        int curIndex = hashFun(emp.id);
        empLinkedLists[curIndex].add(emp);
    }

    // 遍历所有的链表 / 遍历哈希表
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }

    // 查找雇员
    public void find(int id) {
        int index = hashFun(id);
        Emp empById = empLinkedLists[index].findEmpById(id);
        if (empById == null) {
            System.out.println("没有找到该id雇员");
        }else {
            System.out.println("已找到：" + empById);
        }
    }

    // 修改雇员
    public void edit(Emp emp) {
        int index = hashFun(emp.id);
        empLinkedLists[index].editEmpById(emp);
    }

    // 按顺序添加雇员
    public void addByOrder(Emp emp) {
        int index = hashFun(emp.id);
        empLinkedLists[index].addEmpByOrder(emp);
    }

    // 编写散列函数，使用一个简单取模法
    public int hashFun(int id) {
        return id % size;
    }

}
