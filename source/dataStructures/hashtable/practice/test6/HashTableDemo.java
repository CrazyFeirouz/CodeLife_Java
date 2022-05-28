package dataStructures.hashtable.practice.test6;


import dataStructures.hashtable.hashTableDemo.Emp;

import java.util.Scanner;

/**
 * @description: 哈希表（散列）应用实例
 * @author: Feirouz
 * @date: 2022-02-16 20:41
 */

public class HashTableDemo {
    public static void main(String[] args) {
        // 创建哈希表
        HashTable hashTable = new HashTable(7);

        // 写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("edit: 修改雇员");
            System.out.println("del: 删除雇员");
            System.out.println("exit: 退出系统");
            System.out.print("请输入你的操作：");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.print("输入用户id：");
                    int id = scanner.nextInt();
                    System.out.print("输入用户名称：");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTable.addByOrder(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.print("输入用户id：");
                    int findId = scanner.nextInt();
                    hashTable.find(findId);
                    break;
                case "del":
                    System.out.print("输入用户id：");
                    int delId = scanner.nextInt();
                    hashTable.del(delId);
                    break;
                case "edit":
                    System.out.print("输入用户id：");
                    int editId = scanner.nextInt();
                    System.out.print("输入用户名称：");
                    String editName = scanner.next();
                    Emp editEmp = new Emp(editId, editName);
                    hashTable.edit(editEmp);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
            }


        }
    }
}




