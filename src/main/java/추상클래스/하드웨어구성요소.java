package main.java.추상클래스;

import main.java.도구.부품;

public abstract class 하드웨어구성요소 {
    protected String 제조사;
    protected String 일련번호;
    protected String 제품이름;
    protected 부품 제품종류;

    public 하드웨어구성요소(String 제조사, String 일련번호, 
                             String 제품이름, 부품 제품종류) {
        this.제조사 = 제조사;
        this.일련번호 = 일련번호;
        this.제품이름 = 제품이름;
        this.제품종류 = 제품종류;
    }

    public void 기기정보출력() {
        System.out.println("제조사: " + 제조사);
        System.out.println("일련 번호: " + 일련번호);
        System.out.println("제품 이름: " + 제품이름);
        System.out.println("제품 종류: " + 제품종류.name());
    }

    public String 조회_제조사이름() { return 제조사; }
    public String 조회_일련번호() { return 일련번호; }
    public String 조회_제품이름() { return 제품이름; }
    public String 조회_제품타입() { return 제품종류.name(); }
}
