package main.java.구성요소;

import main.java.도구.부품;
import main.java.인터페이스.연결기능;
import main.java.인터페이스.전원기능;
import main.java.추상클래스.하드웨어구성요소;

public class 셀룰러모듈 extends 하드웨어구성요소 implements 연결기능, 전원기능 {
    private int 최대다운속도;
    private int 최대업로드속도;
    private String 운영체제지원;

    private boolean 셀룰러연결이되었는가;
    private boolean 전원이_켜져있는가;

    public 셀룰러모듈(String 제조사, String 일련번호, String 제품이름, 부품 제품종류,
                    int 최대다운속도, int 최대업로드속도, String 운영체제지원) {
        super(제조사, 일련번호, 제품이름, 제품종류);
        this.최대다운속도 = 최대다운속도;
        this.최대업로드속도 = 최대업로드속도;
        this.운영체제지원 = 운영체제지원;
        
        셀룰러연결이되었는가 = false;
        전원이_켜져있는가 = false;
    }

    @Override
    public void 기기정보출력() {
        super.기기정보출력();
        
        System.out.println("최대 다운로드 속도: " + 최대다운속도 + " Mbps");
        System.out.println("최대 업로드 속도: " + 최대업로드속도 + " Mbps");
        System.out.println("운영체제 지원: " + 운영체제지원);
    }

    @Override
    public void 연결하기() {
        if (전원이_켜져있는가 && !셀룰러연결이되었는가){
            셀룰러연결이되었는가 = true;
        }
    }

    @Override
    public void 연결끊기() {
        if (전원이_켜져있는가 && 셀룰러연결이되었는가){
            셀룰러연결이되었는가 = false;
        }
    }

    @Override
    public boolean 연결상태() { return 셀룰러연결이되었는가;}

    @Override
    public void 전원켜기() {
        if (!전원이_켜져있는가) {
            전원이_켜져있는가 = true;
        }
    }

    @Override
    public void 전원끄기() {
        if (전원이_켜져있는가) {
            연결끊기();
            전원이_켜져있는가 = false;
        }
    }
}