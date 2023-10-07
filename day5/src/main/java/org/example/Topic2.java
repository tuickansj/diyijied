package org.example;

import java.util.Scanner;

public class Topic2 {
    public static void main(String[] args) {
         /* 有5家服装专卖店，每家最多购买3件衣服，进入每家店，用户都可以选择离开或者选择购买衣服
                最后打印总共买了几件衣服
        思路：
        外循环进入5家店
	每家店进行内循环操作，最多不超过3次
               考虑专门拿一个变量来计数,统计购买的衣服件数*/
        int clothes = 0;
        for (int i = 1; i <= 5; ++i) {
            System.out.println("进入第"+i+"服装店");
            for (int j = 1;j <= 3;++j){
                Scanner scanner = new Scanner(System.in);
                System.out.println("是否离开:Y/N");
                String isLeave = scanner.next();
                if ("Y".equals(isLeave)) break;
                System.out.println("是否购买衣服:Y/N");
                String isBuy = scanner.next();
                if ("Y".equals(isBuy)) ++clothes;
            }
        }
        System.out.println("购买了"+clothes+"件衣服!");
    }
}
