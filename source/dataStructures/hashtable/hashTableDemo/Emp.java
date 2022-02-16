package dataStructures.hashtable.hashTableDemo;

/**
 * @description: 哈希表 - 链表 - 节点
 * @author: Feirouz
 * @date: 2022-02-16 23:29
 */

// 表示一个雇员
public class Emp{
    public int id;
    public String name;
    public Emp next;        // 默认为null

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
