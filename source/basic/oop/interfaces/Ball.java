package basic.oop.interfaces;

/**
 * 接口题目2
 * 请判断以下代码是否正确
 */

interface Playable {
    void play();
}

interface Bounceable {
    void play();
}

/**
 * 理论上，上面两个接口在实现时以后会报错，
 *      但实际上，只有一开始 继承接口但未重写方法时 显示play()方法定义模糊，重写方法后啥事也没发生了，也没报错
 * PS：JDK8及以后：
 *      知识点4（1-3或其他我写思维导图上了，这里只写对应知识点）：
 *          如果实现类实现了多个接口（无 继承 含同名方法的父类 情况），而这多个接口中定义了同名同参数的默认方法，
 *          那么在实现类没有重写此方法的情况下，报错。--> 接口冲突
 *          解决方式：在实现类中重写此方法
 */
interface Rollable extends Playable, Bounceable{
    Ball ball = new Ball("PingPang");
}

public class Ball implements Rollable {
    private String name;

    public String getName() {
        return name;
    }

    public Ball(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        // 请判断以下代码是否正确
//        ball = new Ball("Football");  // 错误的，接口中声明为 static final，final是不能被修改的
        System.out.println(ball.getName());
    }

    public static void main(String[] args) {
        Ball pingPang = new Ball("Basketball");
        pingPang.play();        // PingPang
    }
}
