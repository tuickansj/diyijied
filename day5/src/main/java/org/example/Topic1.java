package org.example;

import java.util.Scanner;

public class Topic1 {
    public static void main(String[] args) {
        //请输入两个数，求出这两个数的最大公约数
        System.out.println("输入两个数(空格隔开):");
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        int number1 = Integer.parseInt(line[0]);
        int number2 = Integer.parseInt(line[1]);
        int min = number1<number2?number1:number2;
        for (int i = min;i>0;--i){
            if (number1%i==0&&number2%i==0){
                System.out.println(number1+"和"+number2+"的最大公约数是"+i);
                break;
            }
        }
    }
}
