package main.java.구성요소;

import main.java.인터페이스.촬영기능;
import main.java.도구.부품;
import main.java.인터페이스.전원기능;
import main.java.추상클래스.하드웨어구성요소;

public class 카메라 extends 하드웨어구성요소 implements 촬영기능, 전원기능 {
    private String 센서해상도;
    private String 프레임레이트;

    private boolean 촬영중인가;
    private boolean 전원이_켜져있는가;

    public 카메라(String 제조사, String 일련번호, String 제품이름, 부품 제품종류, 
                        String 센서해상도, String 프레임레이트) {
        super(제조사, 일련번호, 제품이름, 제품종류);
        this.센서해상도 = 센서해상도;
        this.프레임레이트 = 프레임레이트;
        this.촬영중인가 = false;
        this.전원이_켜져있는가 = false;
    }
    
    @Override
    public void 기기정보출력() {
        super.기기정보출력();
        
        System.out.println("센서해상도: " + 센서해상도);
        System.out.println("프레임레이트: " + 프레임레이트);
    }

    @Override
    public void 촬영시작() {
        if (전원이_켜져있는가 && !촬영중인가) {
            촬영중인가 = true;
        }
    }

    @Override
    public void 촬영중지() {
        if (전원이_켜져있는가 && 촬영중인가) {
            촬영중인가 = false;
        } 
    }
    
    @Override
    public void 전원켜기() {
        if (!전원이_켜져있는가) {
            전원이_켜져있는가 = true;
        }
    }

    @Override
    public void 전원끄기() {
        if (전원이_켜져있는가) {
            촬영중지();
            전원이_켜져있는가 = false;
        }
    }
}