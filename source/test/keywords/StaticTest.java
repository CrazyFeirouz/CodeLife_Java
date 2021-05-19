package test.keywords;

/**
 * static 的应用场景
 */
public class StaticTest {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(14.5);
        Circle circle3 = new Circle();

        System.out.println("c1的id：" + circle1.getId());
        System.out.println("c2的id：" + circle2.getId());
        System.out.println("c3的id：" + circle3.getId());
        System.out.println("目前圆的个数：" + Circle.getTotal());  //当然，你用对象也能调用，不过我们默认都是类来调用静态方法
    }
}

class Circle {
    private double radius;
    private int id;

    //static 声明的属性被所有对象所共享
    private static int total;   //记录创建圆的个数
    private static int init = 1001;     //使得每次编号递增

    public Circle() {
        id = init++;
        total++;
    }

    public Circle(double radius) {
        this();
        //this() 相当于 ↓
//        id = init++;
//        total++;
        this.radius = radius;
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getTotal() {
        return total;
    }
}
