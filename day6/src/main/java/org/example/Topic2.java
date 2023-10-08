package org.example;

public class Topic2 {
    public static void main(String[] args) {
        //2, 现有一堆英文歌曲，请按照首字母排序
        //String[] musics = {“apple”,"super star","long time",'"yestoday"}；
        String[] musics = {"apple","super star","long time","yestoday"};
        System.out.print("排序前:");
        for (String music:musics) System.out.print(music+", ");
        System.out.println("");
        for (int i = 0; i < musics.length; i++) {
            for (int j = i; j < musics.length-1; j++) {
                   if (musics[j].toLowerCase().charAt(0)>musics[j+1].toLowerCase().charAt(0)){
                       String max = musics[j];
                       musics[j]=musics[j+1];
                       musics[j+1]= max;
                   }
            }
        }
        System.out.println("按照首字母大小排序后:");
        for (String music:musics) System.out.print(music+", ");
    }
}
