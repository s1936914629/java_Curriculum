package com.orange.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.orange.Controller.Select;
import com.orange.Controller.Updata;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @Author: wff
 * @description: TODO(登录界面--程序入口)
 */

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	
	Select select = new Select();
	Updata updata = new Updata();
	private JTextField userField;//账号框
	private JPasswordField passwordField;//密码框
	
	public Login() { 
		
		super.setTitle("Orange旅游管理系统");//设置窗口名称
		this.setBounds(0, 0, 630, 450);//设置窗口大小
		this.setLocationRelativeTo(null);//让窗口在屏幕中间显示
  	    this.setResizable(false);//让窗口大小不可改变
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//用户单击窗口的关闭按钮时程序执行的操作
		
		//设置窗口图标
	    Toolkit tk = Toolkit.getDefaultToolkit();
	    Image frameImage=tk.createImage("img/logo.png"); 
	    this.setIconImage(frameImage);
		
	    //logo添加
        JLabel jl_logo = new JLabel();
        jl_logo.setIcon(new ImageIcon("img/logo2.png"));//文件路径
        jl_logo.setBounds(235, 25, 200, 50);
        this.add(jl_logo);
		
        //显示文本信息
        JLabel font = new JLabel();
        font.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        font.setText("欢迎使用Orange 请登录您的账号！");
        font.setBounds(130, 70, 420, 50);
        this.add(font);
        
        //账号输入
		JLabel userLabel = new JLabel("账 号：");
		userLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		userLabel.setBounds(150, 155, 72, 18);
		getContentPane().add(userLabel);
		
		userField = new JTextField();
		userField.setBounds(200, 150, 270, 34);
		getContentPane().add(userField);
		userField.setColumns(10);
		
		//密码输入
		JLabel passwordLabel = new JLabel("密 码：");
		passwordLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		passwordLabel.setBounds(150, 225, 72, 18);
		getContentPane().add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 220, 270, 34);
		getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		//登录按钮
		JButton button = new JButton("登  录");
		button.setFont(new Font("微软雅黑", Font.BOLD, 15));
		button.setBounds(200, 290, 270, 34);
		button.setFocusPainted(false);//去掉按钮周围的焦点框
		button.setBackground(new Color(78, 110, 242));
		button.setForeground(Color.WHITE);
		getContentPane().add(button);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String account=userField.getText();
				@SuppressWarnings("deprecation")
				String password=passwordField.getText();
				if (account.equals("")&&password.equals("")) {
					JOptionPane.showMessageDialog(null, "账户名或密码未填写！");
				} 
				else {
					String sql = "select COUNT(*) from user where user_password='"+password+"' and user_account='"+account+"'";
					int reselt = select.getCount(sql);
					int i = updata.addData("UPDATE user SET user_state='已登录' WHERE user_account='"+account+"';");
					if (reselt>0 && i>0) {
						//打开主界面窗口
						MainJframe m = new MainJframe();
						m.setVisible(true);
						dispose();//关闭旧窗口
					} else {
						JOptionPane.showMessageDialog(null, "账户名或密码不正确！请重新输入！");
					}
				}
			}
		});
		
		//注册跳转
		JLabel registerLabel = new JLabel("没有账号？立即注册!");
		registerLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		registerLabel.setForeground(Color.blue);
		registerLabel.setBounds(260, 340, 168, 27);
		getContentPane().add(registerLabel);
		registerLabel.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				//打开注册界面
				Registered m = new Registered();
				m.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// 鼠标移入更改文字颜色
				registerLabel.setForeground(Color.red);
			}
			public void mouseExited(MouseEvent e) {
				// 鼠标离开更改文字颜色
				registerLabel.setForeground(Color.blue);
			}
			public void mousePressed(MouseEvent e) {
				// 鼠标按下
			}
			public void mouseReleased(MouseEvent e) {
				// 鼠标弹起
			}
		});

	}
}
