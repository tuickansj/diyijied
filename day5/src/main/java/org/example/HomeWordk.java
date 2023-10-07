package org.example;

import java.util.Scanner;

public class HomeWordk {
    public static void main(String[] args) {
        T3();

}
public static void T1(){
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
    public static void T2(){
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
    public static void T3(){
        //有红，黑，白三种球若干个，其中红、白球共25个，白、黑球共31个，红、黑球共28个，求这三种球各多少个？
        int red,black=0,white=0;
        for (red = 1;red<=25;++red){
                for (white = 1;white<=25-red;++white){
                    for (black = 1;black<=31-white;++black){
                        if ((red+white)==25&&(white+black)==31&&(red+black)==28){
                            System.out.println("红球有"+red+",白球有"+white+",黑球有"+black);
                            return;
                        }
                    }
                }
        }
    }
    public static void T4(){
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
                        System.out.println("取钱成功");
                        break;
                    }
                }
                System.out.println("是否离开(Y/N)");
                String next = scanner.nextLine().trim();
                if ("Y".equals(next)) break;
            }
            ++frequency;
        }
    }
}
