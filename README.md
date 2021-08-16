# CodeLife_Java

    Java 学习记录 —— 记录相关学习内容

#### 

***

<details>
<summary style="font-size: medium"><b>个人学习思维导图</b></summary>

***

>   <details>
>   <summary>Java基础</summary>
>   
>   访问密码（feirouz）→ 
>   [点击跳转思维导图](https://www.processon.com/view/link/608194850791293ce80eabce)
>   </details>

</details>

***

<details>
<summary style="font-size: large"><b>一、Java基础（basic）</b></summary>

****
>   <details>
>   <summary><b>1. Java运算符（operator）</b></summary>
>
>   + 常见运算符（general）
>       + Test ： *+= 和 =+ 的区别*
>
>   + 逻辑运算符（logic）
>       + BitwiseXOR ： *三种替换方式
>           重点讲 ^（异或运算）来实现替换方式*
>       + BHDConverter ： *模拟进制转换
>           使用 & 和 位移运算 来实现*
>
>   </details>

>   <details>
>   <summary><b>2. Java结构（选择、循环）（structure）</b></summary>
>
>   + 嵌套循环（nestedloop）
>       + PrimeNumber ： *查找质数(1-100000)
>       使用不同的方式来查找质数*
>      
>   </details>

>   <details>
>   <summary><b>3. Java数组（arrays）</b></summary>
>
>   + 数组赋值（assignment）
>       + PascalTriangle ： *杨辉三角
>           使用二维数组 打印10行 杨辉三角*
>   + 求数组平均值、最大最小值、和等（value）
>   + 数组的复制、反转、查找（线性查找、二分法查找）（crl）
>       + ArrayReverse ： *数组反转*
>       + ArrayLookup ： *数组查找
>           主要写线性查找、二分法查找*
>   + 数组排序（sort）
>       + BubbleSort ： *冒泡排序*
>
>   </details>

>   <details>
>   <summary><b>4. Java 面向对象（oop）</b></summary>
>   
>   + 接口（interface）
>       + Ball ： *接口题目1 - 判断对错*
>       + C ： *接口题目2 - 判断对错*
>       + StudyTest1 ： *JDK8接口改进 - 注意事项*
>   + 多态（polymorphism）
>       + FieldMethodTest ： *多态的简单使用*
>       + InstanceTest ： *测试 instanceof 所满足的情况*
>       + InterviewTest1 ： *多态中特别的注意事项*
>       + PersonTest ： *多态为何存在？*
>   + 混合（mixture）
>      + BankTest ： *对象的属性 赋值的顺序*
>      + LeafTest ： *题目1 - 判断如下代码执行顺序*
>      + SonTest ： *题目2 - 判断如下代码执行顺序？*
>
>   </details>

>   <details>
>   <summary><b>5. Java API（api）</b></summary>
>   
>   + Object（object）
>     + equal ： *== 和 equals() 的区别*
>     + ToStringTest ： *Object类中toString()的使用*
>   + String（strings）
>     + SimpleTest ： *String 与 char[] 之间的转换题目*
>     + StringTest ： *String的实例化方式*
>   + 包装类（wrapper）
>     + WrapperTest ： *类型转换*
>     + InterviewTest1 ： *题目1 - 关于包装类的面试题*
>     + InterviewTest2S ： *题目2 - 关于包装类的面试题*
>     + ScoreTest ： *题目3 - 根据题意实现代码*
>   
>   </details>

>   <details>
>   <summary><b>6. Java 关键字（keywords）</b></summary>
>   
>   + StaticTest ： *static 的应用场景*
>   
>   </details>

>   <details>
>   <summary><b>7. Java 异常（throwable）</b></summary>
>
>   + ReturnExceptionDemo ： *finally的执行顺序测试*
>   + Test1 ： *常见的运行时异常 有什么？*
>
>   </details>

>   <details>
>   <summary><b>8. Java 多线程（thread）</b></summary>
>
>   + ProAndCost ： *线程通信的应用：经典例题：生产者/消费者*
>   + ThreadTest ： *多线程的创建 方式一：继承于Thread类*
>   + ThreadTest2 ： *多线程的创建 方式一：继承于Thread类 使用匿名子类的方式*
>   + ThreadTest3 ： *多线程的创建 方式二：实现Runnable接口*
>   
>   </details>

>   <details>
>   <summary><b>9. Java 集合类（collection）</b></summary>
>
>   + 暂无内容记录
>   </details>

>   <details>
>   <summary><b>10. Java I/O（io）</b></summary>
>
>   + practice1 ： *获取文本上每个字符出现的次数*
>
>   </details>

>   <details>
>   <summary><b>11. Java 网络编程（net）</b></summary>
>   
>   + 网络通信（socket）
>       + TCPTest1 ： *实现TCP的网络编程练习1*
>       + TCPTest2 ： *实现TCP的网络编程练习2*
>       + TCPTest3 ： *实现TCP的网络编程练习3*
>       + UDPTest1 ： *实现UDP协议的网络编程练习1*
>   + URL编程（url）      
>       + URLTest1 ： *URL网络编程练习1*
>       + URLTest2 ： *URL网络编程练习2*
>   
>   </details>

</details>

***
<details>
<summary style="font-size: large"><b>二、设计思想（design）</b></summary>

***

>   <details>
>   <summary><b>1. 设计模式（pattern）</b></summary>
>   
>   + 创建型模式（creational）
>       + 单例模式（Singleton）： *饿汉式、懒汉式*
>   + 结构型模式（structural）
>       + 代理模式（Proxy）：*四个例子（静态代理 /动态代理）*
>   + 行为型模式（behavioral）
>       + 模板方法模式（TemplateMethod） / 模板模式（Template）：*两个例子*
>   
>   </details>

</details>

***

<details>
<summary style="font-size: large"><b>三、数据结构（dataStructures）</b></summary>

</details>

***







