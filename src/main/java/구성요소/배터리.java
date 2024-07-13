package main.java.구성요소;

import main.java.인터페이스.충전기능;
import main.java.도구.부품;
import main.java.인터페이스.배터리기능;
import main.java.추상클래스.하드웨어구성요소;

public class 배터리 extends 하드웨어구성요소 implements 배터리기능, 충전기능 {
    private String 배터리종류;
    private double 배터리용량; 
    private double 충전된용량; 
    private boolean 충전중인가;

    public 배터리(String 제조사, String 일련번호, String 제품이름, 부품 제품종류,
                   String 배터리종류, double 배터리용량) {
        super(제조사, 일련번호, 제품이름, 제품종류);
        this.배터리종류 = 배터리종류;
        this.배터리용량 = 배터리용량;
        this.충전된용량 = 100; 
        this.충전중인가 = false;
    }   
    
    @Override
    public void 기기정보출력() {
        super.기기정보출력();

        System.out.println("배터리 종류: " + 배터리종류);
        System.out.println("배터리 용량: " + 배터리용량 + " mAh");
        System.out.println("현재 충전된 용량: " + 충전된용량 + " mAh");
        System.out.println("현재 충전 여부: " + 충전중인가);
    }

    @Override
    public double 배터리용량조회() { return 배터리용량;}

    @Override
    public double 충전된용량조회() { return 충전된용량; }

    @Override
    public void 충전시작() { 충전중인가 = true; }

    @Override
    public void 충전중지() { 충전중인가 = false; }

    @Override
    public boolean 충전상태() { return 충전중인가; }

    public void 배터리사용(double 사용량) {
        if (충전된용량 > 0.0) { 충전된용량 -= 사용량; }
        else {충전된용량 = 0.0;}
    }
}