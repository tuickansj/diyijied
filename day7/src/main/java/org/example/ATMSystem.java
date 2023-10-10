package org.example;
import java.util.Arrays;
import java.util.Scanner;
public class ATMSystem {
    public static void main(String[] args) {
        String[][] userInformationS = {};
        String[] adminInformation = {"admin", "admin"};
        boolean enter = false;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入账户:");
            String name = scanner.nextLine().trim();
            System.out.println("请输入密码:");
            String password = scanner.nextLine().trim();
            System.out.println("请输入是否是管理员(Y/N):");
            if ("Y".equals(scanner.nextLine().trim())) {
                enter = adminInformation[0].equals(name) && adminInformation[1].equals(password);
                if (enter) {
                    System.out.println("您好,管理员" + name);
                    while (enter) {
                        System.out.println("请输入操作编号:");
                        System.out.println("\t" + "1  开卡");
                        System.out.println("\t" + "2  注销卡");
                        System.out.println("\t" + "3  查看所有用户列表");
                        System.out.println("\t" + "4  冻结用户");
                        System.out.println("\t" + "5  返回登录界面");
                        System.out.println("\t" + "6  系统退出");
                        String featureNumber = scanner.nextLine().trim();
                        switch (featureNumber) {
                            case "1":
                                System.out.println("新用户注册~");
                                System.out.println("请输入账户:");
                                name = scanner.nextLine().trim();
                                System.out.println("请输入密码:");
                                password = scanner.nextLine().trim();
                                userInformationS = Arrays.copyOf(userInformationS, userInformationS.length + 1);
                                userInformationS[userInformationS.length - 1] = ("账户:" + name + " 密码:" + password
                                        + " 编号:" + userInformationS.length + " 是否冻结:N" + " 金额:0").split(" ");
                                System.out.println("注册结束~");
                                break;
                            case "2":
                                System.out.println("用户注销~");
                                System.out.println("请输入账户:");
                                name = scanner.nextLine().trim();
                                System.out.println("请输入密码:");
                                password = scanner.nextLine().trim();
                                for (String[] userInformation : userInformationS) {
                                    if (userInformation[0].split(":")[1].equals(name) && userInformation[1].split(":")[1].equals(password)) {
                                        System.out.println("注销成功!!!");
                                        int logOutIndex = Integer.parseInt(userInformation[2].split(":")[1]) - 1;
                                        String[][] newU1 = Arrays.copyOf(userInformationS, userInformationS.length - 1);
                                        System.arraycopy(userInformationS,logOutIndex+1,newU1,logOutIndex,userInformationS.length-(logOutIndex+1));
                                        userInformationS = newU1;
                                        for (int i = logOutIndex; i < userInformationS.length; ++i) {
                                            userInformationS[i][2] = "编号:" + (Integer.parseInt(userInformationS[i][2].split(":")[1]) - 1);
                                        }
                                        break;
                                    }
                                }
                                System.out.println("注销结束~");
                                break;
                            case "3":
                                System.out.println("用户列表~");
                                for (String[] userInformation : userInformationS) {
                                    for (int i = 0; i < userInformation.length; i++) {
                                        if (i == 1) continue;
                                        int length = userInformation[i].length();
                                        String printS = userInformation[i];
                                        for (int j = 0; j < 16 - length; j++) {
                                            printS += " ";
                                        }
                                        System.out.print(printS);
                                    }
                                    System.out.println();
                                }
                                System.out.println("查看结束~");
                                break;
                            case "4":

                                System.out.println("输入用户编号:");
                                int userNumber = Integer.parseInt(scanner.nextLine().trim()) - 1;
                                if (userNumber < userInformationS.length && userInformationS[userNumber] != null) {
                                    if (userInformationS[userNumber][3].equals("是否冻结:Y")) {
                                        System.out.println("是否取消冻结?(Y/N)");
                                        String tri = scanner.nextLine().trim();
                                        if (tri.equals("Y")) {
                                            userInformationS[userNumber][3] = "是否冻结:N";
                                            System.out.println("取消冻结!!!");
                                        }
                                        break;
                                    } else {
                                        userInformationS[userNumber][3] = "是否冻结:Y";
                                        System.out.println("编号为" + (userNumber + 1) + "的账户被冻结!!");
                                    }
                                } else System.out.println("用户不存在!!");

                                break;
                            case "5":
                                enter = false;
                                System.out.println("管理员系统退出!!!");
                                break;
                            case "6":
                                return;
                            default:
                                System.out.println("请输入正确编号!!!!");
                                break;
                        }
                    }
                }
            } else {
                if (userInformationS.length > 0) {
                    int loginIndex = 0;
                    for (String[] userInformation : userInformationS) {
                        if ((enter = (userInformation[0].split(":")[1].equals(name) && userInformation[1].split(":")[1].equals(password)))) {
                            loginIndex = Integer.parseInt(userInformation[2].split(":")[1]) - 1;
                            break;
                        }
                    }
                    if (enter) {
                        System.out.println("您好," + name);
                        boolean isFreeze = "Y".equals(userInformationS[loginIndex][3].split(":")[1]);
                        while (enter) {
                            System.out.println("请输入操作编号:");
                            System.out.println("\t" + "1  查看余额");
                            System.out.println("\t" + "2  转账");
                            System.out.println("\t" + "3  取钱");
                            System.out.println("\t" + "4  存钱");
                            System.out.println("\t" + "5  系统退出");
                            System.out.println("\t" + "6  返回登录界面");
                            String featureNumber = scanner.nextLine().trim();
                            switch (featureNumber) {
                                case "1":
                                    System.out.println("账户:" + userInformationS[loginIndex][0].split(":")[1] + "的金额为:" + userInformationS[loginIndex][4].split(":")[1]);
                                    break;
                                case "2":
                                    if (isFreeze) {
                                        System.out.println("该账户已经被冻结,请联系管理员!!!");
                                        break;
                                    }
                                    System.out.println("请输入转账的账户号:");
                                    String userToUserIndex = scanner.nextLine().trim();
                                    for (int i = 0; i < userInformationS.length; i++) {
                                        if (userInformationS[i][0].split(":")[1].equals(userToUserIndex)) {
                                            System.out.println("请输入转账金额:");
                                            int money = Integer.parseInt(scanner.nextLine().trim());
                                            if (money > 0) {
                                                if (Integer.parseInt(userInformationS[loginIndex][4].split(":")[1]) - money < 0)
                                                    System.out.println("转账金额过大!!");
                                                else {
                                                    userInformationS[loginIndex][4] = " 金额:" + (Integer.parseInt(userInformationS[loginIndex][4].split(":")[1]) - money);
                                                    userInformationS[i][4] = " 金额:" + (Integer.parseInt(userInformationS[i][4].split(":")[1]) + money);
                                                    System.out.println("账户:" + userInformationS[loginIndex][0].split(":")[1] + "的金额为:" + userInformationS[loginIndex][4].split(":")[1]);
                                                }
                                            } else {
                                                System.out.println("输入金额有误!!!");
                                            }
                                        }
                                        if ((i + 1) == userInformationS.length) System.out.println("账户不存在!!!");
                                    }
                                    break;
                                case "3":
                                    if (isFreeze) {
                                        System.out.println("该账户已经被冻结,请联系管理员!!!");
                                        break;
                                    }
                                    System.out.println("请输入取钱金额:");
                                    int money = Integer.parseInt(scanner.nextLine().trim());
                                    if (money > 0) {
                                        if (Integer.parseInt(userInformationS[loginIndex][4].split(":")[1]) - money < 0)
                                            System.out.println("取钱金额过大!!");
                                        else {
                                            userInformationS[loginIndex][4] = " 金额:" + (Integer.parseInt(userInformationS[loginIndex][4].split(":")[1]) - money);
                                            System.out.println("账户:" + userInformationS[loginIndex][0].split(":")[1] + "的金额为:" + userInformationS[loginIndex][4].split(":")[1]);
                                        }

                                    } else {
                                        System.out.println("输入金额有误!!!");
                                    }
                                    break;
                                case "4":
                                    System.out.println("请输入存钱金额:");
                                    int money1 = Integer.parseInt(scanner.nextLine().trim());
                                    if (money1 > 0) {
                                        userInformationS[loginIndex][4] = " 金额:" + (Integer.parseInt(userInformationS[loginIndex][4].split(":")[1]) + money1);
                                        System.out.println("账户:" + userInformationS[loginIndex][0].split(":")[1] + "的金额为:" + userInformationS[loginIndex][4].split(":")[1]);
                                    } else {
                                        System.out.println("输入金额有误!!!");
                                    }
                                    break;
                                case "5":
                                    System.out.println("系统退出!!!");
                                    return;
                                case "6":
                                    enter = false;
                                    System.out.println("用户退出!!!");
                                    break;
                                default:
                                    System.out.println("请输入正确编号!!!!");
                                    break;
                            }
                        }
                    }
                } else System.out.println("当前用户池里没有用户,请登录管理员账户进行用户开卡(账户:admin,密码:admin)");
            }
        }
    }
}


