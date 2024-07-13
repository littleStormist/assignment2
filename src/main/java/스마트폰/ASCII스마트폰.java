package main.java.스마트폰;

import javax.swing.*;

import main.java.구성요소.배터리;
import main.java.도구.부품;
import main.java.도구.에셋;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ASCII스마트폰 extends JFrame {
    private JTextArea 텍스트화면;
    private JPanel 버튼패널;
    private Timer 애니메이션타이머;
    private int 얼굴_시작점 = 0;
    private int 위치_시작점 = 0;  

    private boolean 오른쪽이동중 = true;  
    private boolean 애니메이션활성상태 = true;  

    private 스마트폰 나의_스마트폰;
    private 배터리 battery;

    public ASCII스마트폰() {
        나의_스마트폰 = 샘플스마트폰.샘플스마트폰받기();
        나의_스마트폰.전원켜기();

        텍스트화면 = new JTextArea(15, 30);
        텍스트화면.setFont(new Font("monospaced", Font.PLAIN, 12));
        텍스트화면.setEditable(false);
        add(텍스트화면, BorderLayout.CENTER);

        버튼패널 = new JPanel(new GridLayout(6, 1));  
        버튼추가("화면 전원", e -> { 화면전원클릭();});
        버튼추가("셀룰러 스위치", e -> { 셀룰러스위치(); });
        버튼추가("와이파이/블루투스 스위치", e -> {와이파이블루투스스위치();});
        버튼추가("배터리 교체", e -> {배터리교체클릭();});
        버튼추가("사진 찍기", e -> {사진찍기클릭();});
        버튼추가("전원", e -> { 스마트폰전원클릭();});
        add(버튼패널, BorderLayout.EAST);

        화면업데이트();
        애니메이션타이머 = new Timer(300, e -> 캐릭터이동());
        애니메이션타이머.start();

        setTitle("ASCII 스마트폰");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void 애니메이션속도변경() {
        int 딜레이시간 = 300;  
        int 속도빠르기 = (샐룰러상태() ? 1 : 0) + (와이파이블루투스상태() ? 3 : 0);  
        애니메이션타이머.setDelay(딜레이시간 / (1 + 속도빠르기));
    }

    private void 캐릭터이동() {
        if (!전원상태()) return;
        if (애니메이션활성상태 && 충전된용량조회() > 0) {
            if (오른쪽이동중) {
                if (위치_시작점 < 10) {
                    위치_시작점++;
                } else {
                    오른쪽이동중 = false;
                }
            } else {
                if (위치_시작점 > 0) {
                    위치_시작점--;
                } else {
                    오른쪽이동중 = true;
                }
            }
            
            if (화면상태()) {
                배터리소모(1.0);
                화면업데이트();
            }else{
                배터리소모(0.5);
            }
        }
    }

    private void 버튼추가(String label, ActionListener action) {
        JButton button = new JButton(label);
        button.addActionListener(action);
        버튼패널.add(button);
    }

    private void 화면전원클릭() {
        if (화면상태()){화면끄기();} else { 화면켜기();}
        if (전원상태() && !화면상태()) {
            텍스트화면.setText(에셋.대기화면);
        } else {
            화면업데이트();
        }
    }

    private void 스마트폰전원클릭() {
        if (전원상태()) {화면끄기(); 전원끄기();} else {전원켜기(); 화면켜기();}
       
        if (!전원상태()) {
            애니메이션속도변경();

            애니메이션타이머.stop();  
            텍스트화면.setText(에셋.종료화면);
        } else {
            애니메이션타이머.start(); 
            화면업데이트();
        }
    }
    
    private void 화면업데이트() {
        if (전원상태() && 화면상태()) {
            String 공백문자 = " ".repeat(Math.max(0, 위치_시작점));
            String 캐릭터그림 = 공백문자 + 에셋.얼굴_텍스트.get(얼굴_시작점);

            String status = "셀룰러: " + (샐룰러상태() ? 에셋.검은네모 : 에셋.흰네모) +
                            "\n와이파이/블루투스: " + (와이파이블루투스상태() ? 에셋.검은네모 : 에셋.흰네모) +
                            "\n배터리: " + 충전된용량조회() + "%";

            텍스트화면.setText(캐릭터그림 + "\n\n" + status);
        }
    }

    public void 사진찍기클릭(){
        if (전원상태() && 화면상태()) {
            얼굴_시작점 = (얼굴_시작점 + 1) % 에셋.얼굴_텍스트.size();
            JOptionPane.showMessageDialog(this, "찰칵!", "카메라", JOptionPane.INFORMATION_MESSAGE);
            배터리소모(5.0);
        } 
    }

    public void 배터리교체클릭(){
        if (!애니메이션활성상태 && 충전된용량조회() <= 0){
            애니메이션활성상태 = true;
            애니메이션타이머.start();
        }
        battery = new 배터리("Duracell", "0000", "PowerPlus", 부품.배터리, "Li-ion", 18650);
        배터리교체(battery);
        화면업데이트();
    }

    public void 셀룰러스위치(){
        if (!전원상태() || !화면상태()) return;
        if (샐룰러상태()) {
            셀룰러연결끊기();
        }else{
            셀룰러연결하기();
        }
        애니메이션속도변경();
    }

    public void 와이파이블루투스스위치(){
        if (!전원상태() || !화면상태()) return;
        if (와이파이블루투스상태()) {
            와이파이블루투스연결끊기();
        }else{
            와이파이블루투스연결하기();
        }
        애니메이션속도변경();
    }

    private boolean 전원상태() {return 나의_스마트폰.전원상태();};
    private boolean 화면상태() {return 나의_스마트폰.화면상태();};
    private boolean 샐룰러상태() { return 나의_스마트폰.셀룰러연결확인();};
    private boolean 와이파이블루투스상태() { return 나의_스마트폰.와이파이블루투스연결확인();};
    private double 충전된용량조회(){ return 나의_스마트폰.충전된용량조회();};
    private void 배터리교체(배터리 battery){나의_스마트폰.배터리교체(battery);};
    private void 화면켜기() {나의_스마트폰.화면켜기();};
    private void 화면끄기() {나의_스마트폰.화면끄기();};
    private void 전원켜기() {나의_스마트폰.전원켜기();};
    private void 전원끄기() {나의_스마트폰.전원끄기();};
    private void 와이파이블루투스연결끊기() {나의_스마트폰.와이파이블루투스연결끊기();};
    private void 셀룰러연결끊기() {나의_스마트폰.셀룰러연결끊기();};
    private void 와이파이블루투스연결하기() {나의_스마트폰.와이파이블루투스연결하기();};   
    private void 셀룰러연결하기() {나의_스마트폰.셀룰러연결하기();};

    private void 배터리소모(double 소모량) {
        나의_스마트폰.배터리사용(소모량);
        if (나의_스마트폰.충전된용량조회() <= 0.0) {
            애니메이션활성상태 = false;
            애니메이션타이머.stop();
            JOptionPane.showMessageDialog(this, "배터리를 교체해주세요!", "배터리 부족", JOptionPane.WARNING_MESSAGE);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ASCII스마트폰::new);
    }
}