package org.example;

import java.io.IOException;

public class Day2 {
    public static void main(String[] args) throws IOException {
        T1();
        T2();
        T3();
        T4();
        T5();
        T6();
    }
    public static void T1(){
        byte b1=10,b2=20,b3;
        b3= (byte) (b1+b2);
        System.out.println("byte类型的b1和b2的和为:"+"\n"+b3);
        short s1=1000,s2=2000,s3;
        s3= (short) (s1+s2);
        System.out.println("short类型的s1和s2的和为:"+"\n"+s3);
        char c1='a';
        int  i1= 30;
        int ch3= c1-i1;
        System.out.println("char类型的c1和int类型i1的差为:"+"\n"+ch3);
    }
    public static void T2(){
        int i1=150;
        long l1=150;
        long add = i1 + l1;
        System.out.println("add的值"+add);
        long l2=1000000;
        float f2=0.45f;
        float add2 = l2 + f2;
        System.out.println("add2的值"+add2);
        int i3=1000000;
        double d3=0.45f;
        double add3 = i3 + d3;
        System.out.println("add3的值"+add3);
        float f4=1000000;
        double d4=1.2625;
        double add4 = f4 + d4;
        System.out.println("add4的值"+add4);
    }
    public static void T3(){
        char ch = 'J'+32;
        System.out.println(ch);
        char ch2 =  'a';
        ch2-=32;
        System.out.println(ch2);
        double d3 = 0.5;
        int i3 = 103;
        double sum3 = i3 + d3;
        System.out.println("sum3的的值:"+sum3);
        System.out.println("sum3的整数部分的值:"+(int)sum3);
        double d4 = 174;
        int i4 = 10;
        int mul4 = (int)d4*i4;
        System.out.println("mul4的整数部分的值:"+mul4);
    }
    public static void T4(){
        int a1=10,a2=11;
        System.out.println("10是偶数"+(a1%2==0?"true":"flase"));
        System.out.println("11是偶数"+(a2%2==0?"true":"flase"));
        System.out.println("10是奇数"+(a1%2!=0?"true":"flase"));
        System.out.println("11是奇数"+(a2%2!=0?"true":"flase"));
    }
    public static void T5(){
        float dF = 1.58f;
        float lastDs = 235.6f;
        float dS=312.72f;
        System.out.println("小红家这个月的电费是"+(dS-lastDs)*dF);
    }
    private static void T6(){
        int a1=11,a2=12;
        System.out.println("a1与a2的最大数为"+(a1>a2?a1:a2));
    }
}
