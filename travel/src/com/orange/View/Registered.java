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
 * @description: TODO(�û�ע�����)
 */

public class Registered extends JFrame {

	private static final long serialVersionUID = 1L;

	Updata updata = new Updata();
	private JTextField userField;//�˺�
	private JPasswordField passwordField;//����
	private JPasswordField passwordAgainField;//ȷ������
	
	public Registered() {
		super.setTitle("Orange���ι���ϵͳ");
		this.setBounds(0, 0, 700, 450);//���ô�С
		this.setLocationRelativeTo(null);//�ô�������Ļ�м���ʾ
  	    this.setResizable(false);//�ô��ڴ�С���ɸı�
		getContentPane().setLayout(null);
		
		//���ô���ͼ��
	    Toolkit tk = Toolkit.getDefaultToolkit();
	    Image frameImage=tk.createImage("img/logo.png"); 
	    this.setIconImage(frameImage);
		
	    //logo���
        JLabel jl_logo = new JLabel();
        jl_logo.setIcon(new ImageIcon("img/logo2.png"));//�ļ�·��
        jl_logo.setBounds(280, 15, 200, 50);
        this.add(jl_logo);
        
        //�ı���Ϣ��ʾ
        JLabel font = new JLabel();
        font.setFont(new Font("΢���ź�", Font.PLAIN, 25));
        font.setText("��ӭʹ��Orange ����ע��һ���˺Űɣ�");
        font.setBounds(140, 58, 600, 50);
        add(font);
        
        //���ڹر�ʱ��������
//		this.addWindowListener(new WindowAdapter() {
//			 
//			public void windowClosing(WindowEvent e) {
//				super.windowClosing(e);
//				MainJframe m = new MainJframe();
//				m.setVisible(true);
//			 }
//		});
		
        //�˻���
		JLabel usernameLabel = new JLabel("�� �� ����");
		usernameLabel.setFont(new Font("΢���ź�", Font.BOLD, 15));
		usernameLabel.setBounds(165, 138, 72, 18);
		getContentPane().add(usernameLabel);
		
		userField = new JTextField();
		userField.setBounds(248, 130, 255, 34);
		getContentPane().add(userField);
		userField.setColumns(10);
		
		//����
		JLabel passwordLabel = new JLabel("�������룺");
		passwordLabel.setFont(new Font("΢���ź�", Font.BOLD, 15));
		passwordLabel.setBounds(165, 208, 83, 18);
		getContentPane().add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(248, 267, 255, 34);
		getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		JLabel passwordAgainLabel = new JLabel("ȷ�����룺");
		passwordAgainLabel.setFont(new Font("΢���ź�", Font.BOLD, 15));
		passwordAgainLabel.setBounds(165, 275, 92, 18);
		getContentPane().add(passwordAgainLabel);
		
		passwordAgainField = new JPasswordField();
		passwordAgainField.setBounds(248, 200, 255, 34);
		getContentPane().add(passwordAgainField);
		passwordAgainField.setColumns(10);
		
		//ȷ��ע�ᰴť
		JButton button = new JButton("ȷ��ע��");
		button.setFont(new Font("΢���ź�", Font.BOLD, 15));
		button.setBounds(250, 330, 250, 34);
		button.setFocusPainted(false);//ȥ����ť��Χ�Ľ����
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
				
				//ȷ���������Ϣ�Ƿ�Ϊ��
				if (username.equals("")&&password.equals("")&&passwordAgain.equals("")) {
					JOptionPane.showMessageDialog(null, "������������Ϣ��");
				}
				else {
					//�ж����������Ƿ�һ��
					if (password.equals(passwordAgain)) {
						String sql = "INSERT INTO `user` VALUES (null, '" + username + "', '"+password + "', '�ο�', 'δ��¼');";
						int reselt = updata.addData(sql);
						if (reselt>0) {
							JOptionPane.showMessageDialog(null, "ע��ɹ���������ת����¼ҳ�棡");
							//�򿪵�¼����
							Login l = new Login();
							l.setVisible(true);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "ע��ʧ�ܣ�����ϵ����Ա��");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "������������벻һ�£����������룡");
					}
				}
			}
		});
	}

}
