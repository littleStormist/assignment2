package main.java.구성요소;

import main.java.인터페이스.화면기능;
import main.java.추상클래스.하드웨어구성요소;
import main.java.도구.부품;

public class 디스플레이 extends 하드웨어구성요소 implements 화면기능 {
    private String 화면종류;
    private String 화면해상도;
    private String 화면크기;
    
    private boolean 화면이_켜져있는가;

    public 디스플레이(String 제조사, String 일련번호, String 제품이름, 부품 제품종류, 
                   String 화면종류, String 화면해상도, String 화면크기) {
        super(제조사, 일련번호, 제품이름, 제품종류);
        this.화면종류 = 화면종류;
        this.화면해상도 = 화면해상도;
        this.화면크기 = 화면크기;
        this.화면이_켜져있는가 = false;
    }

    @Override
    public void 기기정보출력() {
        super.기기정보출력();
        
        System.out.println("화면 종류: " + 화면종류);
        System.out.println("화면 해상도: " + 화면해상도);
        System.out.println("화면 크기: " + 화면크기 + " 인치");
    }

    @Override
    public void 화면켜기() {
        if (!화면이_켜져있는가){
            화면이_켜져있는가 = true;
        }
    }

    @Override
    public void 화면끄기() {
        if (화면이_켜져있는가){
            화면이_켜져있는가 = false;
        }
    }

    public boolean 화면상태() {
        return 화면이_켜져있는가;
    }
}