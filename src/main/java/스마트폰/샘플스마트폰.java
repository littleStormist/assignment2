package main.java.스마트폰;

import main.java.구성요소.시스템온모듈;
import main.java.구성요소.와이파이블루투스모듈;
import main.java.구성요소.셀룰러모듈;
import main.java.구성요소.카메라;
import main.java.구성요소.디스플레이;
import main.java.구성요소.배터리;
import main.java.도구.부품;

public class 샘플스마트폰 {
    private static 스마트폰 샘플스마트폰 = 샘플스마트폰생성();
    
    private 샘플스마트폰() {
    }
    
    private static 스마트폰 샘플스마트폰생성() {
        카메라 camera = new 카메라("Sony", "0000", "Alpha", 부품.카메라, "5.0 MP", "30fps");
        디스플레이 display = new 디스플레이("Samsung", "0000", "Galaxy Display", 부품.디스플레이, "IPS LCD", "720x1440", "5.7인치");
        배터리 battery = new 배터리("Duracell", "0000", "PowerPlus", 부품.배터리, "Li-ion", 18650);
        시스템온모듈 som = new 시스템온모듈("EMCraft", "1617", "i.MX8M", 부품.시스템온모듈, "32GB", "4GB", "Octa-core", null);
        와이파이블루투스모듈 wifi_bt = new 와이파이블루투스모듈("Redpine", "1819", "RS9999", 부품.와이파이블루투스모듈, "802.11ax", "WPA3");
        셀룰러모듈 cellular = new 셀룰러모듈("SimCom", "2021", "SIM7100", 부품.셀룰러모듈, 100, 50, "Linux, Windows, Android");
        return new 스마트폰(som, wifi_bt, cellular, camera, display, battery);
    }

    public static 스마트폰 샘플스마트폰받기(){
        return 샘플스마트폰;
    }
}