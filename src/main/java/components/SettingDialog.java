package main.java.components;

import javax.swing.*;
import java.awt.*;

public class SettingDialog extends JDialog {
    public SettingDialog(JFrame parent) {
        super(parent, "Settings", true); // 부모 프레임을 참조하고 모달 다이얼로그로 설정

        // 다이얼로그 크기 및 위치 설정
        setSize(300, 200);
        setLocationRelativeTo(parent);
        
        // 설정 창 내용 구성
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JButton adminRegisterButton = new JButton("관리자 등록");
        JButton adminManagementButton = new JButton("관리자 관리");

        panel.add(adminRegisterButton);
        panel.add(adminManagementButton);

        add(panel, BorderLayout.CENTER);
    }
}
