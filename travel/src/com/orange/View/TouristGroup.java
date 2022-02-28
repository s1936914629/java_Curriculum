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

        super.setTitle("旅游团信息");
        this.setBounds(0, 0, 900, 600);//设置大小
        this.setLocationRelativeTo(null);//让窗口在屏幕中间显示
        this.setResizable(false);//让窗口大小不可改变
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//用户单击窗口的关闭按钮时程序执行的操作
        //设置窗口图标
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image frameImage = tk.createImage("img/logo.png");
        this.setIconImage(frameImage);

        //广告图片添加
        JLabel jl_logo = new JLabel();
        jl_logo.setIcon(new ImageIcon("img/touristgroup.png"));//文件路径
        jl_logo.setBounds(0, 0, 750, 600);
        this.add(jl_logo);
    }
}
