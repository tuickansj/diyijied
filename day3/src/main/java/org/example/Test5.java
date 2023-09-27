package org.example;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
     T1();
     T2();
     T3();
     T4();
     T5();
    }

    public static void T1(){
        int a=20,b=20;
        boolean bo= (++a)%3==0&&(a++)%7==0;
        System.out.println("bo的值"+bo);
        System.out.println("a的值"+a);
        System.out.println("------------");
        boolean bo2 = (b++)%3==0&&(++b)%7==0;
        System.out.println("bo2的值"+bo2);
        System.out.println("b的值"+b);
    }
    public static void T2(){
        System.out.println("请输入一个数来判断是不是5的倍数");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(number%5==0?number+"是5的倍数":number+"不是5的倍数");
    }
    public static void T3(){
        System.out.println("请请输入月份");
        Scanner scanner = new Scanner(System.in);
        int[] tians = {31,28,31,30,31,30,31,31,30,31,30,31,29};
        int yueF = scanner.nextInt();
        System.out.println("请请输入年份");
        int nianF = scanner.nextInt();
        if (yueF==2){
            yueF=(nianF % 4 == 0 & nianF % 100 != 0) || nianF % 400 == 0 ?13:2;
        }
        System.out.println((yueF==13?2:yueF)+"月有"+tians[yueF-1]+"天");
    }
    public static void T4(){
        System.out.println("请输入狗的年龄");
        Scanner scanner = new Scanner(System.in);
        int dogNianL = scanner.nextInt();
        if (dogNianL>0){
            if (dogNianL<=2){
                System.out.println("当前狗的年龄是"+dogNianL*10.5);
            }else {
                System.out.println("当前狗的年龄是"+(21+((dogNianL-2)*4)));
            }
        }else {
            System.out.println("输入数据不正确!");
        }

    }
    public static void T5(){
        System.out.println("输入#1");
        Scanner scanner = new Scanner(System.in);
        String time = scanner.nextLine();
        String[] timeS = time.split(" ");
        int hour = Integer.parseInt(timeS[2])-Integer.parseInt(timeS[0]);
        int minute = 0;
        if ((minute=Integer.parseInt(timeS[3])-Integer.parseInt(timeS[1]))<0){
            hour--;
            minute+=60;
        }
        System.out.println("输出#2");
        System.out.println(hour+" "+minute);
    }
}
