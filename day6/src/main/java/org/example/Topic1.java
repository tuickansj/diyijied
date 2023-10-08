package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Topic1 {
    public static void main(String[] args) throws IOException {
        //输入一个含有数字的字符串，并统计数字的出现的个数
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一串包含数字的字符串");
        String line = scanner.nextLine();
        int numbers = 0;
        byte[] chars = line.getBytes();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]>='0'&&chars[i]<='9') ++numbers;
        }
        System.out.println(line+"中数字的个数为"+numbers);
    }
}
