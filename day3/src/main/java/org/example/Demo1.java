package org.example;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        lianX2();
    }

    public static void lianX1() {
        int ab = 123;
        int g = ab % 10;
        int s = ab / 10 % 10;
        int b = ab / 100;
        int lif = (int) (Math.pow(g, 3) + Math.pow(s, 3) + Math.pow(b, 3));
        System.out.println(lif);
    }

    public static void lianX2() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(number % 2 == 0 ? number + "是偶数" : number + "是奇数");
        int nian = scanner.nextInt();
        System.out.println((nian % 4 == 0 & nian % 100 != 0) || nian % 400 == 0 ? nian + "是润年" : nian + "不是润年");
    }
}