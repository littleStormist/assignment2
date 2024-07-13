package main.java.구성요소;

import main.java.도구.부품;
import main.java.인터페이스.연결기능;
import main.java.인터페이스.전원기능;
import main.java.추상클래스.하드웨어구성요소;

public class 와이파이블루투스모듈 extends 하드웨어구성요소 implements 연결기능, 전원기능 {
    private String 와이파이규격;
    private String 블루투스버전;

    private boolean 와이파이연결이되었는가;
    private boolean 블루투스연결이되었는가;
    private boolean 전원이_켜져있는가;

    public 와이파이블루투스모듈(String 제조사, String 일련번호, String 제품이름, 부품 제품종류,
                               String 와이파이규격, String 블루투스버전) {
        super(제조사, 일련번호, 제품이름, 제품종류);
        this.와이파이규격 = 와이파이규격;
        this.블루투스버전 = 블루투스버전;
        this.와이파이연결이되었는가 = false;
        this.블루투스연결이되었는가 = false;
        this.전원이_켜져있는가 = false;
    }

    @Override
    public void 기기정보출력() {
        super.기기정보출력();

        System.out.println("와이파이 규격: " + 와이파이규격);
        System.out.println("블루투스 버전: " + 블루투스버전);
    }

    @Override
    public void 연결하기() {
        if (전원이_켜져있는가){
            if (! 와이파이연결이되었는가){
                와이파이연결이되었는가 = true;
            }            
            if (! 블루투스연결이되었는가){
                블루투스연결이되었는가 = true;
            }
        }
    }

    @Override
    public void 연결끊기() {
        if (전원이_켜져있는가 && 연결상태()){
            if (와이파이연결이되었는가){
                와이파이연결이되었는가 = false;
            }            
            if (블루투스연결이되었는가){
                블루투스연결이되었는가 = false;
            }
        }
    }

    @Override
    public boolean 연결상태() {
        return 와이파이연결이되었는가 || 블루투스연결이되었는가;
    }

    @Override
    public void 전원켜기() {
        if (!전원이_켜져있는가){
            전원이_켜져있는가 = true;
        }
    }

    @Override
    public void 전원끄기() {
        if (전원이_켜져있는가){
            연결끊기();
            전원이_켜져있는가 = false;
        }
    }
}
