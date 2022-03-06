package jvm.chapter01;

/**
 * @description: 关于栈的架构测试
 * @author: Feirouz
 * @date: 2022-03-06 20:44
 */
public class StackStuTest {
    public static void main(String[] args) {
//        int i = 2 + 3;
        int i = 2;
        int j = 3;
        int k = i + j;
    }
}


/*
反编译命令 - javap -v StackStuTest.class

效果：

Classfile /E:/Space/IdeaSpace/CodeLife_Java/out/production/CodeLife_Java/jvm/chapter01/StackStuTest.class
  Last modified 2022-3-6; size 473 bytes
  MD5 checksum 44d22eb7a5f633120af2c4010cd2b2cf
  Compiled from "StackStuTest.java"
public class jvm.chapter01.StackStuTest
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #3.#21         // java/lang/Object."<init>":()V
   #2 = Class              #22            // jvm/chapter01/StackStuTest
   #3 = Class              #23            // java/lang/Object
   #4 = Utf8               <init>
   #5 = Utf8               ()V
   #6 = Utf8               Code
   #7 = Utf8               LineNumberTable
   #8 = Utf8               LocalVariableTable
   #9 = Utf8               this
  #10 = Utf8               Ljvm/chapter01/StackStuTest;
  #11 = Utf8               main
  #12 = Utf8               ([Ljava/lang/String;)V
  #13 = Utf8               args
  #14 = Utf8               [Ljava/lang/String;
  #15 = Utf8               i
  #16 = Utf8               I
  #17 = Utf8               j
  #18 = Utf8               k
  #19 = Utf8               SourceFile
  #20 = Utf8               StackStuTest.java
  #21 = NameAndType        #4:#5          // "<init>":()V
  #22 = Utf8               jvm/chapter01/StackStuTest
  #23 = Utf8               java/lang/Object
{
  public jvm.chapter01.StackStuTest();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 8: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Ljvm/chapter01/StackStuTest;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=4, args_size=1
         0: iconst_2
         1: istore_1
         2: iconst_3
         3: istore_2
         4: iload_1
         5: iload_2
         6: iadd
         7: istore_3
         8: return
      LineNumberTable:
        line 11: 0
        line 12: 2
        line 13: 4
        line 14: 8
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       9     0  args   [Ljava/lang/String;
            2       7     1     i   I
            4       5     2     j   I
            8       1     3     k   I
}
SourceFile: "StackStuTest.java"

 */
