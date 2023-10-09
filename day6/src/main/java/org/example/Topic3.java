package org.example;

import java.util.Scanner;

public class Topic3 {
    public static void main(String[] args) {
        int benchHeight = 30;
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入10个100到200的整数分别表示10个苹果到地面的高度(空格隔开)");
        String[] appleHeightS = scanner.nextLine().split(" ");
        System.out.println("输入100到120的整数表示陶陶最大伸手距离:");
        int tHeight = Integer.parseInt(scanner.nextLine().trim());
        int appleNumbers = 0;
        for (String appleHeight:appleHeightS) {
            int height = Integer.parseInt(appleHeight);
            if (height<=     (benchHeight+tHeight)) ++appleNumbers;
        }
        System.out.println("陶陶能够拿的苹果数为"+appleNumbers);

    }
}
