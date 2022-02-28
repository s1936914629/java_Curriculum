package com.orange.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.orange.Controller.Updata;

/**
 * @Author: wff
 * @description: TODO(用户注册界面)
 */

public class Registered extends JFrame {

	private static final long serialVersionUID = 1L;

	Updata updata = new Updata();
	private JTextField userField;//账号
	private JPasswordField passwordField;//密码
	private JPasswordField passwordAgainField;//确认密码
	
	public Registered() {
		super.setTitle("Orange旅游管理系统");
		this.setBounds(0, 0, 700, 450);//设置大小
		this.setLocationRelativeTo(null);//让窗口在屏幕中间显示
  	    this.setResizable(false);//让窗口大小不可改变
		getContentPane().setLayout(null);
		
		//设置窗口图标
	    Toolkit tk = Toolkit.getDefaultToolkit();
	    Image frameImage=tk.createImage("img/logo.png"); 
	    this.setIconImage(frameImage);
		
	    //logo添加
        JLabel jl_logo = new JLabel();
        jl_logo.setIcon(new ImageIcon("img/logo2.png"));//文件路径
        jl_logo.setBounds(280, 15, 200, 50);
        this.add(jl_logo);
        
        //文本信息显示
        JLabel font = new JLabel();
        font.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        font.setText("欢迎使用Orange 试着注册一个账号吧！");
        font.setBounds(140, 58, 600, 50);
        add(font);
        
        //窗口关闭时打开主界面
//		this.addWindowListener(new WindowAdapter() {
//			 
//			public void windowClosing(WindowEvent e) {
//				super.windowClosing(e);
//				MainJframe m = new MainJframe();
//				m.setVisible(true);
//			 }
//		});
		
        //账户名
		JLabel usernameLabel = new JLabel("账 号 名：");
		usernameLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		usernameLabel.setBounds(165, 138, 72, 18);
		getContentPane().add(usernameLabel);
		
		userField = new JTextField();
		userField.setBounds(248, 130, 255, 34);
		getContentPane().add(userField);
		userField.setColumns(10);
		
		//密码
		JLabel passwordLabel = new JLabel("输入密码：");
		passwordLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		passwordLabel.setBounds(165, 208, 83, 18);
		getContentPane().add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(248, 267, 255, 34);
		getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		JLabel passwordAgainLabel = new JLabel("确认密码：");
		passwordAgainLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		passwordAgainLabel.setBounds(165, 275, 92, 18);
		getContentPane().add(passwordAgainLabel);
		
		passwordAgainField = new JPasswordField();
		passwordAgainField.setBounds(248, 200, 255, 34);
		getContentPane().add(passwordAgainField);
		passwordAgainField.setColumns(10);
		
		//确认注册按钮
		JButton button = new JButton("确定注册");
		button.setFont(new Font("微软雅黑", Font.BOLD, 15));
		button.setBounds(250, 330, 250, 34);
		button.setFocusPainted(false);//去掉按钮周围的焦点框
		button.setBackground(new Color(78, 110, 242));
		button.setForeground(Color.WHITE);
		getContentPane().add(button);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = userField.getText();
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
				@SuppressWarnings("deprecation")
				String passwordAgain = passwordAgainField.getText();
				
				//确认输入的信息是否为空
				if (username.equals("")&&password.equals("")&&passwordAgain.equals("")) {
					JOptionPane.showMessageDialog(null, "请完整输入信息！");
				}
				else {
					//判断两次密码是否一致
					if (password.equals(passwordAgain)) {
						String sql = "INSERT INTO `user` VALUES (null, '" + username + "', '"+password + "', '游客', '未登录');";
						int reselt = updata.addData(sql);
						if (reselt>0) {
							JOptionPane.showMessageDialog(null, "注册成功，即将跳转到登录页面！");
							//打开登录界面
							Login l = new Login();
							l.setVisible(true);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "注册失败，请联系管理员！");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "两次输入的密码不一致，请重新输入！");
					}
				}
			}
		});
	}

}
