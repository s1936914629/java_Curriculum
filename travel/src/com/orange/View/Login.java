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
 * @description: TODO(��¼����--�������)
 */

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	
	Select select = new Select();
	Updata updata = new Updata();
	private JTextField userField;//�˺ſ�
	private JPasswordField passwordField;//�����
	
	public Login() { 
		
		super.setTitle("Orange���ι���ϵͳ");//���ô�������
		this.setBounds(0, 0, 630, 450);//���ô��ڴ�С
		this.setLocationRelativeTo(null);//�ô�������Ļ�м���ʾ
  	    this.setResizable(false);//�ô��ڴ�С���ɸı�
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�û��������ڵĹرհ�ťʱ����ִ�еĲ���
		
		//���ô���ͼ��
	    Toolkit tk = Toolkit.getDefaultToolkit();
	    Image frameImage=tk.createImage("img/logo.png"); 
	    this.setIconImage(frameImage);
		
	    //logo���
        JLabel jl_logo = new JLabel();
        jl_logo.setIcon(new ImageIcon("img/logo2.png"));//�ļ�·��
        jl_logo.setBounds(235, 25, 200, 50);
        this.add(jl_logo);
		
        //��ʾ�ı���Ϣ
        JLabel font = new JLabel();
        font.setFont(new Font("΢���ź�", Font.PLAIN, 25));
        font.setText("��ӭʹ��Orange ���¼�����˺ţ�");
        font.setBounds(130, 70, 420, 50);
        this.add(font);
        
        //�˺�����
		JLabel userLabel = new JLabel("�� �ţ�");
		userLabel.setFont(new Font("΢���ź�", Font.BOLD, 15));
		userLabel.setBounds(150, 155, 72, 18);
		getContentPane().add(userLabel);
		
		userField = new JTextField();
		userField.setBounds(200, 150, 270, 34);
		getContentPane().add(userField);
		userField.setColumns(10);
		
		//��������
		JLabel passwordLabel = new JLabel("�� �룺");
		passwordLabel.setFont(new Font("΢���ź�", Font.BOLD, 15));
		passwordLabel.setBounds(150, 225, 72, 18);
		getContentPane().add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 220, 270, 34);
		getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		//��¼��ť
		JButton button = new JButton("��  ¼");
		button.setFont(new Font("΢���ź�", Font.BOLD, 15));
		button.setBounds(200, 290, 270, 34);
		button.setFocusPainted(false);//ȥ����ť��Χ�Ľ����
		button.setBackground(new Color(78, 110, 242));
		button.setForeground(Color.WHITE);
		getContentPane().add(button);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String account=userField.getText();
				@SuppressWarnings("deprecation")
				String password=passwordField.getText();
				if (account.equals("")&&password.equals("")) {
					JOptionPane.showMessageDialog(null, "�˻���������δ��д��");
				} 
				else {
					String sql = "select COUNT(*) from user where user_password='"+password+"' and user_account='"+account+"'";
					int reselt = select.getCount(sql);
					int i = updata.addData("UPDATE user SET user_state='�ѵ�¼' WHERE user_account='"+account+"';");
					if (reselt>0 && i>0) {
						//�������洰��
						MainJframe m = new MainJframe();
						m.setVisible(true);
						dispose();//�رվɴ���
					} else {
						JOptionPane.showMessageDialog(null, "�˻��������벻��ȷ�����������룡");
					}
				}
			}
		});
		
		//ע����ת
		JLabel registerLabel = new JLabel("û���˺ţ�����ע��!");
		registerLabel.setFont(new Font("΢���ź�", Font.BOLD, 15));
		registerLabel.setForeground(Color.blue);
		registerLabel.setBounds(260, 340, 168, 27);
		getContentPane().add(registerLabel);
		registerLabel.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				//��ע�����
				Registered m = new Registered();
				m.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// ����������������ɫ
				registerLabel.setForeground(Color.red);
			}
			public void mouseExited(MouseEvent e) {
				// ����뿪����������ɫ
				registerLabel.setForeground(Color.blue);
			}
			public void mousePressed(MouseEvent e) {
				// ��갴��
			}
			public void mouseReleased(MouseEvent e) {
				// ��굯��
			}
		});

	}
}
