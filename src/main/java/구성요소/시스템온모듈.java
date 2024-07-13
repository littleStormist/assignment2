package main.java.구성요소;

import main.java.도구.부품;
import main.java.인터페이스.연결기능;
import main.java.인터페이스.전원기능;
import main.java.추상클래스.하드웨어구성요소;

public class 시스템온모듈 extends 하드웨어구성요소 implements 연결기능, 전원기능 {
    private String 저장공간;
    private String 램메모리;
    private String 중앙연산장치;
    
    private 와이파이블루투스모듈 와이파이_블루투스_모듈;
    private boolean 전원이_켜져있는가;

    public 시스템온모듈(String 제조사, String 일련번호, String 제품이름, 부품 제품종류, 
                     String 저장공간, String 램메모리, String 중앙연산장치, 
                     와이파이블루투스모듈 와이파이_블루투스_모듈) {
        super(제조사, 일련번호, 제품이름, 제품종류);
        this.저장공간 = 저장공간;
        this.램메모리 = 램메모리;
        this.중앙연산장치 = 중앙연산장치;
        this.와이파이_블루투스_모듈 = 와이파이_블루투스_모듈;
        this.전원이_켜져있는가 = false;
    }

    @Override
    public void 기기정보출력() {
        super.기기정보출력();
        
        System.out.println("저장공간: " + 저장공간);
        System.out.println("램 메모리: " + 램메모리);
        System.out.println("중앙연산장치: " + 중앙연산장치);
        if (와이파이_블루투스_모듈 != null) {
            와이파이_블루투스_모듈.기기정보출력();
        } 
    }

    @Override
    public void 연결하기() {
        if (와이파이_블루투스_모듈 != null) {
            와이파이_블루투스_모듈.연결하기();
        } 
    }

    @Override
    public void 연결끊기() {
        if (와이파이_블루투스_모듈 != null) {
            와이파이_블루투스_모듈.연결끊기();
        }
    } 

    @Override
    public boolean 연결상태() {
        if (와이파이_블루투스_모듈 != null) {
            return 와이파이_블루투스_모듈.연결상태();
        }
        return false;
    }

    @Override
    public void 전원켜기() {
        if (!전원이_켜져있는가){
            전원이_켜져있는가 = true;
        }

        if (와이파이_블루투스_모듈 != null) {
            와이파이_블루투스_모듈.전원켜기();
        }
    }

    @Override
    public void 전원끄기() {
        if (와이파이_블루투스_모듈 != null) {
            와이파이_블루투스_모듈.전원끄기();
        }
        if (전원이_켜져있는가){
            전원이_켜져있는가 = false;
        }
    }

    public boolean 와이파이블루투스모듈이있는가(){
        return 와이파이_블루투스_모듈 != null;
    }
}
