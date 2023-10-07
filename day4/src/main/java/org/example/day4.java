package org.example;

import java.util.Scanner;

public class day4 {
    public static void main(String[] args) {

           T4();

    }
    public static void T1(){
        System.out.println("输入整形数:");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int sum = 1;
        while (number>0){
            sum *=number--;
        }
        System.out.println(number+"的阶乘为"+sum);
    }
    public static void T2(){
        int number1 = 1;
        int number2 = 2;
        int number3;
        int frequency = 3;
        System.out.print(number1+", "+number2+", ");
        while(frequency++<=20){
            number3 = number1+number2;
            number1 = number2 ;
            number2 = number3;
            System.out.print(number3+", ");
        }
    }
    public static void T3(){
        int days = 10;
        int peach = 1;
        while (days-->1){
            peach = (peach+peach)*2;
        }
        System.out.println("共有"+peach+"个桃子");
    }
    public static void T4(){
        System.out.println("请输入年，月，日(用空格隔开)");
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int year = Integer.parseInt(data[0]);
        int month = Integer.parseInt(data[1]);
        int day = Integer.parseInt(data[2]);
        switch (month-1){
            case 11:day+=30;
            case 10:day+=31;
            case 9:day+=30;
            case 8:day+=31;
            case 7:day+=31;
            case 6:day+=30;
            case 5:day+=31;
            case 4:day+=30;
            case 3:day+=31;
            case 2:day+=28;
            case 1:day+=31;break;
            case 0:
                System.out.println("该天是"+year+"的第"+day+"天");
                return;
        }
        if ((year%4==0 && year%100!=0 || year%400==0)&&month>2) day++;
        System.out.println("该天是"+year+"年的第"+day+"天");
    }
    public static void T5(){
        System.out.println("输入小红的入职星期数（1-5");
        Scanner scanner = new Scanner(System.in);
        int weeks = scanner.nextInt();
        int days=0;
        while (weeks-->0){
            days+=5;
        }
        System.out.println("小红工资:"+(days*200));
    }
}
