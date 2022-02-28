package com.orange.View;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TouristGroup extends JFrame {

    // public static void main(String[] args) {
    // 	TouristGroup test = new TouristGroup();
    // 	test.setVisible(true);
    // }
    public TouristGroup() {

        super.setTitle("��������Ϣ");
        this.setBounds(0, 0, 900, 600);//���ô�С
        this.setLocationRelativeTo(null);//�ô�������Ļ�м���ʾ
        this.setResizable(false);//�ô��ڴ�С���ɸı�
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�û��������ڵĹرհ�ťʱ����ִ�еĲ���
        //���ô���ͼ��
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image frameImage = tk.createImage("img/logo.png");
        this.setIconImage(frameImage);

        //���ͼƬ���
        JLabel jl_logo = new JLabel();
        jl_logo.setIcon(new ImageIcon("img/touristgroup.png"));//�ļ�·��
        jl_logo.setBounds(0, 0, 750, 600);
        this.add(jl_logo);
    }
}
