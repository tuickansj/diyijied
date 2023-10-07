package org.example;

import java.util.Scanner;

public class Topic4 {
    public static void main(String[] args) {
        //银行操作系统，有输密码三次，输3次没对直接跳出程序；输对密码进入取钱系统，输入取钱金额，取得钱数必须是100的倍数，且一次不能超过10000，取完后结束系统。
        int frequency = 1;
        Scanner scanner = new Scanner(System.in);
        String userName ="admin";
        String password= "123456";

        while(frequency<=3){
            System.out.println("第"+frequency+"次输入");
            System.out.println("输入账户");
            boolean equals1 = userName.equals(scanner.nextLine().trim());
            System.out.println("输入密码");
            boolean equals2 = password.equals(scanner.nextLine().trim());
            if (equals1&&equals2){
                while (true){
                    System.out.println("请输入取钱金额:");
                    int money = Integer.parseInt(scanner.nextLine());
                    if (money<10000&&money%100==0){
                        System.out.println("取钱成功!!");

                    }else System.out.println("取钱金额错误!!");
                    System.out.println("继续取钱(Y/N)");
                    String leave = scanner.nextLine().trim();
                    if ("N".equals(leave)) {
                        System.out.println("退出程序!!");
                        break;
                    }
                }
                System.out.println("是否离开(Y/N)");
                String next = scanner.nextLine().trim();
                if ("Y".equals(next)) break;
            }
            ++frequency;
        }
        System.out.println("账户密码输入错误三次!!!!");
    }
}

