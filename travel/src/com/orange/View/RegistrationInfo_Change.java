package com.orange.View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.orange.Bean.Tourist;
import com.orange.Controller.Select;
import com.orange.Controller.Updata;
import com.orange.Utils.ValidateUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class RegistrationInfo_Change extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JTextField nameField;//姓名
	private JTextField ageField;//年龄
	private JTextField IDcardField;//身份证号码
	private JTextField addressField;//地址
	private JTextField phoneField;//电话
	private JTextField touristNumberField;//团号
	private JTextField accompanyField;//陪同
	private JTextField foodsField;//食宿
	Select select = new Select();
	Updata updata = new Updata();
	String name,sex,age,IDcard,address,phone,touristNumber,accompany,foods;


	public RegistrationInfo_Change(Tourist tourist) {
		super("修改报名信息");
		this.setBounds(0, 0, 800, 600);
		this.setLocationRelativeTo(null);//让窗口在屏幕中间显示
		this.setResizable(false);//让窗口大小不可改变
		getContentPane().setLayout(null);
		
		//设置窗口图标
	    Toolkit tk = Toolkit.getDefaultToolkit();
	    Image frameImage=tk.createImage("img/logo.png"); 
	    this.setIconImage(frameImage);
		
	    //图片添加
        JLabel jl = new JLabel();
        jl.setIcon(new ImageIcon("img/brand.png"));//文件路径
        jl.setBounds(453, 10, 800, 300);
        this.add(jl);
	    
        //姓名
		JLabel nameLabel= new JLabel("姓   名：");
		nameLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		nameLabel.setBounds(130, 39, 72, 18);
		getContentPane().add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(191, 36, 240, 28);
		getContentPane().add(nameField);
		nameField.setColumns(10);
		
		//性别
		JLabel sexLabel= new JLabel("性   别：");
		sexLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		sexLabel.setBounds(130, 90, 72, 18);
		getContentPane().add(sexLabel);
		
		JComboBox sexcomboBox = new JComboBox();
		sexcomboBox.setModel(new DefaultComboBoxModel(new String[] {"男", "女"}));
		sexcomboBox.setBounds(191, 87, 240, 28);
		getContentPane().add(sexcomboBox);
		
		//年龄
		JLabel ageLabel= new JLabel("年   龄：");
		ageLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		ageLabel.setBounds(130, 138, 72, 18);
		getContentPane().add(ageLabel);
		
		ageField = new JTextField();
		ageField.setBounds(191, 135, 240, 28);
		getContentPane().add(ageField);
		ageField.setColumns(10);
		
		//身份证号码
		JLabel IDcardLabel= new JLabel("身份证号码：");
		IDcardLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		IDcardLabel.setBounds(98, 188, 117, 18);
		getContentPane().add(IDcardLabel);
		
		IDcardField = new JTextField();
		IDcardField.setBounds(191, 185, 240, 28);
		getContentPane().add(IDcardField);
		IDcardField.setColumns(10);
		
		//家庭住址
		JLabel addressLabel= new JLabel("家庭住址：");
		addressLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		addressLabel.setBounds(113, 234, 100, 18);
		getContentPane().add(addressLabel);
		
		addressField = new JTextField();
		addressField.setBounds(191, 231, 240, 28);
		getContentPane().add(addressField);
		addressField.setColumns(10);
		
		//联系电话
		JLabel phoneLabel= new JLabel("联系电话：");
		phoneLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		phoneLabel.setBounds(113, 280, 100, 18);
		getContentPane().add(phoneLabel);
		
		phoneField = new JTextField();
		phoneField.setBounds(191, 277, 240, 28);
		getContentPane().add(phoneField);
		phoneField.setColumns(10);
		
		//团号
		JLabel touristNumberLabel= new JLabel("团   号：");
		touristNumberLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		touristNumberLabel.setBounds(130, 325, 72, 18);
		getContentPane().add(touristNumberLabel);
		
		touristNumberField = new JTextField();
		touristNumberField.setBounds(191, 322, 240, 28);
		getContentPane().add(touristNumberField);
		touristNumberField.setColumns(10);
		
		//陪同
		JLabel accompanyLabel= new JLabel("是否陪同：");
		accompanyLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		accompanyLabel.setBounds(113, 377, 100, 18);
		getContentPane().add(accompanyLabel);
		
		accompanyField = new JTextField();
		accompanyField.setText("是否选择导游陪同？");
		accompanyField.setToolTipText("");
		accompanyField.setBounds(191, 374, 240, 28);
		getContentPane().add(accompanyField);
		accompanyField.setColumns(10);
		
		JLabel foodsLabel= new JLabel("是否食宿：");
		foodsLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		foodsLabel.setBounds(113, 427, 100, 18);
		getContentPane().add(foodsLabel);
		
		foodsField = new JTextField();
		foodsField.setText("是否选择宾馆住宿？");
		foodsField.setBounds(191, 424, 240, 28);
		getContentPane().add(foodsField);
		foodsField.setColumns(10);
		
		JButton button_1 = new JButton("查看旅游团信息");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TouristGroup tg = new TouristGroup();
				tg.setVisible(true);
			}
		});
		button_1.setBounds(453, 324, 158, 27);
		button_1.setFocusPainted(false);//去掉按钮周围的焦点框
		button_1.setFont(new Font("微软雅黑", Font.BOLD, 13));
		button_1.setBackground(new Color(243, 152, 0));
		button_1.setForeground(Color.WHITE);
		getContentPane().add(button_1);
		
		
		JButton button_2 = new JButton("是");
		button_2.setBounds(453, 376, 72, 27);
		button_2.setFocusPainted(false);//去掉按钮周围的焦点框
		button_2.setFont(new Font("微软雅黑", Font.BOLD, 13));
		button_2.setBackground(new Color(0, 189, 93));
		button_2.setForeground(Color.WHITE);
		getContentPane().add(button_2);
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accompanyField.setText("是");
			}
		});
		
		JButton button_3 = new JButton("否");
		button_3.setBounds(539, 376, 72, 27);
		button_3.setFocusPainted(false);//去掉按钮周围的焦点框
		button_3.setFont(new Font("微软雅黑", Font.BOLD, 13));
		button_3.setBackground(new Color(238, 10, 36));
		button_3.setForeground(Color.WHITE);
		getContentPane().add(button_3);
		button_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accompanyField.setText("无");
			}
		});
		
		JButton button_4 = new JButton("是");
		button_4.setBounds(453, 424, 72, 27);
		button_4.setFocusPainted(false);//去掉按钮周围的焦点框
		button_4.setFont(new Font("微软雅黑", Font.BOLD, 13));
		button_4.setBackground(new Color(0, 189, 93));
		button_4.setForeground(Color.WHITE);
		getContentPane().add(button_4);
		button_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				foodsField.setText("是");
			}
		});
		
		JButton button_5 = new JButton("否");
		button_5.setBounds(539, 424, 72, 27);
		button_5.setFocusPainted(false);//去掉按钮周围的焦点框
		button_5.setFont(new Font("微软雅黑", Font.BOLD, 13));
		button_5.setBackground(new Color(238, 10, 36));
		button_5.setForeground(Color.WHITE);
		getContentPane().add(button_5);
		button_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				foodsField.setText("无");
			}
		});
		
		//设置文本框初始值
		nameField.setText(tourist.getTourist_name());
		String t = tourist.getTourist_sex();
		sexcomboBox.setSelectedItem(t);
		ageField.setText(tourist.getTourist_age());
		IDcardField.setText(tourist.getTourist_idCard());
		addressField.setText(tourist.getTourist_address());
		phoneField.setText(tourist.getTourist_phone());
		touristNumberField.setText(tourist.getGroup_num());
		accompanyField.setText(tourist.getAccompanied());
		foodsField.setText(tourist.getAccommodation());
		
		//确认修改按钮
		JButton submitButton = new JButton("确认修改");
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		submitButton.setBounds(320, 495, 150, 33);
		submitButton.setFocusPainted(false);//去掉按钮周围的焦点框
		submitButton.setBackground(new Color(78, 110, 242));
		submitButton.setForeground(Color.WHITE);
		getContentPane().add(submitButton);
		
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = tourist.getTourist_num();
				name = nameField.getText();
				sex = sexcomboBox.getSelectedItem().toString();
				age = ageField.getText();
				IDcard = IDcardField.getText();
				address = addressField.getText();
				phone = phoneField.getText();
				touristNumber = touristNumberField.getText();
				accompany = accompanyField.getText();
				if (accompany.equals("是否选择导游陪同？")) {
					accompany="无";
				}
				foods = foodsField.getText();
				if (foods.equals("是否选择宾馆住宿？")) {
					foods="无";
				}
				//判断输入的信息是否为空，是否完整
				if (name.equals("")||sex.equals("")||age.equals("")||IDcard.equals("")||address.equals("")||phone.equals("")||touristNumber.equals("")||accompany.equals("")||foods.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入完整信息！");
				} else {
					//判断身份证号码
					if (!ValidateUtils.IDcard(IDcard)) {
						JOptionPane.showMessageDialog(null, "身份证号码错误！请检查！");
					} else {
						String i = select.getString("SELECT user_id FROM `user` WHERE user_state='已登录'");
						String sql = "UPDATE tourist SET tourist_name='"+name+"',tourist_sex='"+sex+"',tourist_age='"+age+"',tourist_idcard='"+IDcard+"',tourist_address='"+address+"',tourist_phone='"+phone+"',group_num='"+touristNumber+"',accompanied='"+accompany+"',accommodation='"+foods+"' WHERE tourist_num='"+id+"';";
						int result = updata.addData(sql);
						//判断手机号
						String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
				        if(phone.length() != 11){
				        	JOptionPane.showMessageDialog(null, "手机号应为11位数！");
				        }else{
				            Pattern p = Pattern.compile(regex);
				            Matcher m = p.matcher(phone);
				            boolean isMatch = m.matches();
				            if(!isMatch){
				                JOptionPane.showMessageDialog(null, "您的手机号" + phone + "是错误格式！");
				            }else {
				            	//判断插入结果
				            	if (result>0) {
				            		JOptionPane.showMessageDialog(null, "修改成功！");
				            		dispose();
//				            		Registration_Management r = new Registration_Management();
//									r.dispose();
//									r.setVisible(true);
				            	} else {
				            		JOptionPane.showMessageDialog(null, "修改失败，请与管理员联系！");
				            	}
							}
				        }
					}
				}
			}
		});
	}
}
