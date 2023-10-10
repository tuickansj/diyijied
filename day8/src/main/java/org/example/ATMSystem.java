package org.example;
import java.util.Arrays;
import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {
        String[][] userInformationS = {};
        String[] adminInformation = {"admin", "admin"};
        boolean enter;
        while (true) {
            System.out.println("是否退出ATM系统(Y/N):");
            Scanner scanner = new Scanner(System.in);
            if ("Y".equals(scanner.nextLine().trim())) {
                System.out.println("系统退出!!!");
                System.exit(1);
            }
            System.out.println("请输入账户:");
            String name = scanner.nextLine().trim();
            System.out.println("请输入密码:");
            String password = scanner.nextLine().trim();
            System.out.println("请输入是否是管理员(Y/N):");
            if ("Y".equals(scanner.nextLine().trim())) {
                enter = adminInformation[0].equals(name) && adminInformation[1].equals(password);
                if (enter) {
                    System.out.println("您好,管理员" + name);
                    userInformationS=AdminFunction(userInformationS,enter,scanner);
                }else  System.out.println("管理员账号密码输入错误!!!");
            } else {
                if (userInformationS.length > 0) {
                    userInformationS = UserFeatures(userInformationS,name,password,scanner);
                } else System.out.println("当前用户池里没有用户,请登录管理员账户进行用户开卡(账户:admin,密码:admin)");

            }
        }
    }

    /**
     * 查询用户池里的用户编号
     * @param userInformationS
     * @param name
     * @param password
     * @return
     */
    public static int FindUser(String[][] userInformationS,String name,String password){
        if (userInformationS.length==0) return -1;
        for (String[] userInformation: userInformationS) {
            if (userInformation[0].split(":")[1].equals(name) && userInformation[1].split(":")[1].equals(password)){
                return  Integer.parseInt(userInformation[2].split(":")[1])-1;
            }
        }
        return -1;
    }

    /**
     * 为用户池添加用户
     * @param userInformationS
     * @param scanner
     * @return
     */

    public static String[][] EnrollUser(String[][] userInformationS,Scanner scanner){
        System.out.println("新用户注册~");
        System.out.println("请输入账户:");
        String name = scanner.nextLine().trim();
        System.out.println("请输入密码:");
        String password = scanner.nextLine().trim();
        int oldUserIndex = FindUser(userInformationS,name,password);
        if (oldUserIndex==-1){
            userInformationS = Arrays.copyOf(userInformationS, userInformationS.length + 1);
            userInformationS[userInformationS.length - 1] = ("账户:" + name + " 密码:" + password
                    + " 编号:" + userInformationS.length + " 是否冻结:N" + " 金额:0").split(" ");
            System.out.println("注册结束~");
        }else System.out.println("输入内容有误!!!");
        return userInformationS;
    }

    /**
     * 为用户池删除用户
     * @param userInformationS
     * @param scanner
     * @return
     */
   public static String[][] LogoutUser(String[][] userInformationS,Scanner scanner){
        System.out.println("用户注销~");
        System.out.println("请输入账户:");
        String name = scanner.nextLine().trim();
        System.out.println("请输入密码:");
        String password = scanner.nextLine().trim();
        int logOutIndex = FindUser(userInformationS,name,password);
          if (logOutIndex>-1){
              System.out.println("注销成功!!!");
              String[][] newU1 = Arrays.copyOf(userInformationS, userInformationS.length - 1);
              System.arraycopy(userInformationS,logOutIndex+1,newU1,logOutIndex,userInformationS.length-(logOutIndex+1));
              userInformationS = newU1;
              for (int i = logOutIndex; i < userInformationS.length; ++i) {
                  userInformationS[i][2] = "编号:" + (Integer.parseInt(userInformationS[i][2].split(":")[1]) - 1);
              }
          }else System.out.println("注销失败!!!");
        System.out.println("注销结束~");
        return userInformationS;
    }

    /**
     * 查看用户池所有的用户信息
     * @param userInformationS
     */
    public static void ViewUser(String[][] userInformationS){
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
    }

    /**
     * 冻结用户池里面的某个用户
     * @param userInformationS
     * @param scanner
     */
    public static void FreezeUser(String[][] userInformationS,Scanner scanner){
        System.out.println("输入用户编号:");
        int userNumber = 0;
        try {
            userNumber = Integer.parseInt(scanner.nextLine().trim()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("输入数据有误!!!");
            return;
        }
        if (userNumber < userInformationS.length && userInformationS[userNumber] != null) {
            if (userInformationS[userNumber][3].equals("是否冻结:Y")) {
                System.out.println("是否取消冻结?(Y/N)");
                String tri = scanner.nextLine().trim();
                if (tri.equals("Y")) {
                    userInformationS[userNumber][3] = "是否冻结:N";
                    System.out.println("取消冻结!!!");
                }
            } else {
                userInformationS[userNumber][3] = "是否冻结:Y";
                System.out.println("编号为" + (userNumber + 1) + "的账户被冻结!!");
            }
        } else System.out.println("用户不存在!!");
    }

    /**
     * 管理员功能集合
     * @param userInformationS
     * @param enter
     * @param scanner
     * @return
     */
    public static String[][] AdminFunction(String[][] userInformationS,boolean enter,Scanner scanner){
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
                    userInformationS = EnrollUser(userInformationS,scanner);
                    break;
                case "2":
                    userInformationS = LogoutUser(userInformationS,scanner);
                    break;
                case "3":
                    ViewUser(userInformationS);
                    break;
                case "4":
                    FreezeUser(userInformationS,scanner);
                    break;
                case "5":
                    enter = false;
                    System.out.println("管理员系统退出!!!");
                    break;
                case "6":
                    System.out.println("ATM系统退出!!!");
                    System.exit(1);
                    break;
                default:
                    System.out.println("请输入正确编号!!!!");
                    break;
            }
        }
        return userInformationS;
    }

    /**
     * 查询用户池的某个用户编号
     * @param userInformationS
     * @param name
     * @param password
     * @return
     */
    public static int ReturnUserIndex(String[][] userInformationS,String name,String password){
        for (String[] userInformation : userInformationS) {
            if ((userInformation[0].split(":")[1].equals(name) && userInformation[1].split(":")[1].equals(password))) {
                return Integer.parseInt(userInformation[2].split(":")[1]) - 1;
            }
        }
        return -1;
    }

    /**
     * 展示用户的信息
     * @param userInformationS
     * @param loginIndex
     */
    public static void ShowMoney(String[][] userInformationS,int loginIndex){
        System.out.println("账户:" + userInformationS[loginIndex][0].split(":")[1] + "的金额为:" + userInformationS[loginIndex][4].split(":")[1]);
    }

    /**
     * 转账
     * @param userInformationS
     * @param loginIndex
     * @param isFreeze
     * @param scanner
     * @return
     */
    public static String[][] TransferMoney(String[][] userInformationS,int loginIndex,boolean isFreeze,Scanner scanner){
        if (isFreeze) {
            System.out.println("该账户已经被冻结,请联系管理员!!!");
            return userInformationS;
        }
        System.out.println("请输入转账的账户号:");
        String userToUserIndex = scanner.nextLine().trim();
        for (int i = 0; i < userInformationS.length; i++) {
            if (userInformationS[i][0].split(":")[1].equals(userToUserIndex)) {
                System.out.println("请输入转账金额:");
                int money = 0;
                try {
                    money = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("输入有误!!!");
                }
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
                break;
            }
            if ((i + 1) == userInformationS.length) System.out.println("账户不存在!!!");
        }
        return userInformationS;
    }

    /**
     * 取钱
     * @param userInformationS
     * @param loginIndex
     * @param isFreeze
     * @param scanner
     * @return
     */
    public static String[][] WithdrawMoney(String[][] userInformationS,int loginIndex,boolean isFreeze,Scanner scanner){
        if (isFreeze) {
            System.out.println("该账户已经被冻结,请联系管理员!!!");
            return userInformationS;
        }
        System.out.println("请输入取钱金额:");
        int money = 0;
        try {
            money = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("输入数据有误!!!");
        }
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
        return userInformationS;
    }

    /**
     * 存钱
     * @param userInformationS
     * @param loginIndex
     * @param scanner
     * @return
     */
    public static String[][] SavingMoney(String[][] userInformationS,int loginIndex,Scanner scanner){
        System.out.println("请输入存钱金额:");
        int money1 = 0;
        try {
            money1 = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("输入数据有误!!!");
        }
        if (money1 > 0) {
            userInformationS[loginIndex][4] = " 金额:" + (Integer.parseInt(userInformationS[loginIndex][4].split(":")[1]) + money1);
            System.out.println("账户:" + userInformationS[loginIndex][0].split(":")[1] + "的金额为:" + userInformationS[loginIndex][4].split(":")[1]);
        } else {
            System.out.println("输入金额有误!!!");
        }
        return userInformationS;
    }

    /**
     * 用户功能集合
     * @param userInformationS
     * @param name
     * @param password
     * @param scanner
     * @return
     */
    public static String[][] UserFeatures(String[][] userInformationS,String name,String password,Scanner scanner){
        int loginIndex ;
        loginIndex = ReturnUserIndex(userInformationS,name,password);
        boolean enter = loginIndex>=0;
        if (enter) {
            System.out.println("您好," + name);
            boolean isFreeze = "Y".equals(userInformationS[loginIndex][3].split(":")[1]);
            while (enter) {
                System.out.println("请输入操作编号:");
                System.out.println("\t" + "1  查看余额");
                System.out.println("\t" + "2  转账");
                System.out.println("\t" + "3  取钱");
                System.out.println("\t" + "4  存钱");
                System.out.println("\t" + "5  返回登录界面");
                System.out.println("\t" + "6  系统退出");
                String featureNumber = scanner.nextLine().trim();
                switch (featureNumber) {
                    case "1":
                        ShowMoney(userInformationS,loginIndex);
                        break;
                    case "2":
                        userInformationS = TransferMoney(userInformationS,loginIndex,isFreeze,scanner);
                        break;
                    case "3":
                        userInformationS = WithdrawMoney(userInformationS,loginIndex,isFreeze,scanner);
                        break;
                    case "4":
                        userInformationS = SavingMoney(userInformationS,loginIndex,scanner);
                        break;
                    case "5":
                        enter = false;
                        System.out.println("用户退出!!!");
                        break;
                    case "6":
                        System.out.println("ATM系统退出!!!");
                        System.exit(1);
                    default:
                        System.out.println("请输入正确编号!!!!");
                        break;
                }
            }
        }else System.out.println("账户密码错误!!!");
        return userInformationS;
    }
}

