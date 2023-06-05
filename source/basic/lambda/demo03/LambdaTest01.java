package basic.lambda.demo03;

/**
 * @description:
 * @author: Feirouz
 * @date: 2023-06-05 12:00
 */
public class LambdaTest01 {

    // 3. 静态内部类
    static class Like2 implements ILike{

        @Override
        public void lambda() {
            System.out.println("i like lambda2");
        }
    }

    public static void main(String[] args) {
        // 方式一
        ILike l1 = new Like();
        l1.lambda();

        // 方式二
        ILike l2 = new Like2();
        l2.lambda();

        // 方式三
        // 4. 局部内部类
        class Like3 implements ILike{

            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        }
        Like3 l3 = new Like3();
        l3.lambda();

        // 方式四
        // 5. 匿名内部类
        ILike l4 = new ILike() {

            @Override
            public void lambda() {
                System.out.println("i like lambda4");
            }
        };
        l4.lambda();

        // 方式五
        // 6. 用lambda简化
        ILike l5 = () -> {
            System.out.println("i like lambda5");
        };
        l5.lambda();


    }
}

// 1. 定义一个函数式接口
interface ILike{
    void lambda();
}

// 2. 实现类
class Like implements ILike{

    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}


