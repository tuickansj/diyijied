package org.example;

import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) {


        System.out.println("输入打印排数:");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String line = "";
        for (int i = 1;i<=number;++i){
            for (int a = 0;a<(number-i);++a) line+=" ";
            for (int j = 0; j<i*2-1;++j) line+="*";
            line+="\n";
        }
        System.out.println(line);
    }
    public static void T1(){
        int number = 1;
        long jiec=1;
        long sum=0;
        while(number<=20){
            for (int i = 1;i<=number;++i){
                jiec *=i;
            }
            ++number;
            System.out.println(jiec);
            sum+=jiec;
            jiec=1;
        }
        System.out.println(sum);
    }
    public static void T2(){
        String line="";
        for (int i = 1; i <= 9; ++i) {
            for (int j =1;j<=i;++j){
                line+=j+"*"+i+"="+(i*j)+"\t";
            }
            line+="\n";
        }

        System.out.println(line);
    }
    public static void T3(){
        System.out.println("输入打印排数:");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String line = "";
        for (int i=0;i< number*2-1;++i)line+=" ";
        for (int i=0;i< number;++i){
            int index =  (number*2-1)/2;
            StringBuffer stringBuffer = new StringBuffer(line);
            stringBuffer.replace(index-i,index+i+1,line.substring(0,i*2+1).replace(" ","*"));
            System.out.println(stringBuffer);
        }
    }
}
