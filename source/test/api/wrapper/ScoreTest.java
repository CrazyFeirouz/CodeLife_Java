package test.api.wrapper;


import java.util.Scanner;
import java.util.Vector;

/**
 * 题目：
 * 利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束）,找出最高分，并输出学生成绩等级。
 * 提示：数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的长度。
 * 而向量类java.util.Vector可以根据需要动态伸缩。
 * 创建Vector对象：Vector v=new Vector();
 * 给向量添加元素：V.addElement(Object obj);//obj必须是对象
 * 取出向量中的元素：Object obj=v.elementAt(0);
 * 注意第一个元素的下标是0,返回值是Object类型的。
 * 计算向量的长度：V.size();
 * 若与最高分相差10分内：A等；20分内：B等；
 *            30分内：C等；其它：D等
 */
public class ScoreTest {
    public static void main(String[] args) {
        // 1. 实例化Scanner，用于从键盘获取学生成绩
        Scanner scanner = new Scanner(System.in);

        // 2. 创建Vector对象
        Vector v = new Vector();

        // 3. 开始录入
        boolean isFlag = true;
        int max = 0;
        while (isFlag) {
            int score = scanner.nextInt();
            // 3.1 负数停止录入
            if (score < 0) {
                isFlag = false;
            // 3.2 成绩不能大于100
            }else if(score > 100) {
                System.out.println("录入成绩非法，请重写输入");
            }else {
                // 3.3 得到学生成绩最大值
                max = max > score ? max : score;

                // 3.4 录入成绩到Vector
                // JDK5.0之前
//                Integer inScore = new Integer(score);
//                v.addElement(inScore);
                // JDK5.0以后
                v.addElement(score);
            }
        }

        // 5. 遍历 Vector，得到每一个学生的成绩，并且与最大值比较，得到每个学生的等级
        char level;
        for (int i = 0; i < v.size(); i++) {
            Object o = v.elementAt(i);
            // JDK5.0之前
//            Integer inScore = (Integer)o;
//            int score = inScore.intValue();
            // JDK5.0之后
//            int score = (Integer) o;    //方法1
            int score = (int) o;          //方法2

            int diff = max - score;

            if(diff <= 10) {
                level = 'A';
            }else if (diff <= 20) {
                level = 'B';
            }else if (diff <= 30) {
                level = 'C';
            }else {
                level = 'D';
            }
            System.out.println("学生-" + (i+1) + "，分数：" + score + "，成绩级别：" + level );
        }

    }
}
