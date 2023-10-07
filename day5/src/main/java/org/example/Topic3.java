package org.example;

public class Topic3 {
    public static void main(String[] args) {
        //有红，黑，白三种球若干个，其中红、白球共25个，白、黑球共31个，红、黑球共28个，求这三种球各多少个？
        int red,black,white;
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
}
