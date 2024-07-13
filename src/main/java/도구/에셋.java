package main.java.도구;

import java.util.ArrayList;
import java.util.List;

public class 에셋 {
    public static final List<String> 얼굴_텍스트 = new ArrayList<>();

    public static final String 대기화면 =   "화면이 대기 상태가 되었습니다."+
                                            "\n////////////////////////" +
                                            "\n////////////////////////" + 
                                            "\n////////////////////////" +
                                            "\n////////////////////////" +
                                            "\n////////////////////////" +
                                            "\n////////////////////////";

    public static final String 종료화면 =   "스마트폰의 전원이 꺼졌습니다."+
                                            "\n////////////////////////" +
                                            "\n////////////////////////" + 
                                            "\n////////////////////////" +
                                            "\n////////////////////////" +
                                            "\n////////////////////////" +
                                            "\n////////////////////////";
    public static final String 검은네모 = "■■■■■";
    public static final String 흰네모 = "□□□□□";
    
    static {
        얼굴_텍스트.add("   (^._.^)   \n");
        얼굴_텍스트.add("   (^@_@^)   \n");
        얼굴_텍스트.add("   (^x_x^)   \n");
        얼굴_텍스트.add("   (^O_O^)   \n");
        얼굴_텍스트.add("   (^-_-^)   \n");
    }
}