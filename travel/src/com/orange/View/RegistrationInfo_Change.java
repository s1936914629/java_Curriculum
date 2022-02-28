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
	
	private JTextField nameField;//����
	private JTextField ageField;//����
	private JTextField IDcardField;//���֤����
	private JTextField addressField;//��ַ
	private JTextField phoneField;//�绰
	private JTextField touristNumberField;//�ź�
	private JTextField accompanyField;//��ͬ
	private JTextField foodsField;//ʳ��
	Select select = new Select();
	Updata updata = new Updata();
	String name,sex,age,IDcard,address,phone,touristNumber,accompany,foods;


	public RegistrationInfo_Change(Tourist tourist) {
		super("�޸ı�����Ϣ");
		this.setBounds(0, 0, 800, 600);
		this.setLocationRelativeTo(null);//�ô�������Ļ�м���ʾ
		this.setResizable(false);//�ô��ڴ�С���ɸı�
		getContentPane().setLayout(null);
		
		//���ô���ͼ��
	    Toolkit tk = Toolkit.getDefaultToolkit();
	    Image frameImage=tk.createImage("img/logo.png"); 
	    this.setIconImage(frameImage);
		
	    //ͼƬ���
        JLabel jl = new JLabel();
        jl.setIcon(new ImageIcon("img/brand.png"));//�ļ�·��
        jl.setBounds(453, 10, 800, 300);
        this.add(jl);
	    
        //����
		JLabel nameLabel= new JLabel("��   ����");
		nameLabel.setFont(new Font("΢���ź�", Font.BOLD, 15));
		nameLabel.setBounds(130, 39, 72, 18);
		getContentPane().add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(191, 36, 240, 28);
		getContentPane().add(nameField);
		nameField.setColumns(10);
		
		//�Ա�
		JLabel sexLabel= new JLabel("��   ��");
		sexLabel.setFont(new Font("΢���ź�", Font.BOLD, 15));
		sexLabel.setBounds(130, 90, 72, 18);
		getContentPane().add(sexLabel);
		
		JComboBox sexcomboBox = new JComboBox();
		sexcomboBox.setModel(new DefaultComboBoxModel(new String[] {"��", "Ů"}));
		sexcomboBox.setBounds(191, 87, 240, 28);
		getContentPane().add(sexcomboBox);
		
		//����
		JLabel ageLabel= new JLabel("��   �䣺");
		ageLabel.setFont(new Font("΢���ź�", Font.BOLD, 15));
		ageLabel.setBounds(130, 138, 72, 18);
		getContentPane().add(ageLabel);
		
		ageField = new JTextField();
		ageField.setBounds(191, 135, 240, 28);
		getContentPane().add(ageField);
		ageField.setColumns(10);
		
		//���֤����
		JLabel IDcardLabel= new JLabel("���֤���룺");
		IDcardLabel.setFont(new Font("΢���ź�", Font.BOLD, 15));
		IDcardLabel.setBounds(98, 188, 117, 18);
		getContentPane().add(IDcardLabel);
		
		IDcardField = new JTextField();
		IDcardField.setBounds(191, 185, 240, 28);
		getContentPane().add(IDcardField);
		IDcardField.setColumns(10);
		
		//��ͥסַ
		JLabel addressLabel= new JLabel("��ͥסַ��");
		addressLabel.setFont(new Font("΢���ź�", Font.BOLD, 15));
		addressLabel.setBounds(113, 234, 100, 18);
		getContentPane().add(addressLabel);
		
		addressField = new JTextField();
		addressField.setBounds(191, 231, 240, 28);
		getContentPane().add(addressField);
		addressField.setColumns(10);
		
		//��ϵ�绰
		JLabel phoneLabel= new JLabel("��ϵ�绰��");
		phoneLabel.setFont(new Font("΢���ź�", Font.BOLD, 15));
		phoneLabel.setBounds(113, 280, 100, 18);
		getContentPane().add(phoneLabel);
		
		phoneField = new JTextField();
		phoneField.setBounds(191, 277, 240, 28);
		getContentPane().add(phoneField);
		phoneField.setColumns(10);
		
		//�ź�
		JLabel touristNumberLabel= new JLabel("��   �ţ�");
		touristNumberLabel.setFont(new Font("΢���ź�", Font.BOLD, 15));
		touristNumberLabel.setBounds(130, 325, 72, 18);
		getContentPane().add(touristNumberLabel);
		
		touristNumberField = new JTextField();
		touristNumberField.setBounds(191, 322, 240, 28);
		getContentPane().add(touristNumberField);
		touristNumberField.setColumns(10);
		
		//��ͬ
		JLabel accompanyLabel= new JLabel("�Ƿ���ͬ��");
		accompanyLabel.setFont(new Font("΢���ź�", Font.BOLD, 15));
		accompanyLabel.setBounds(113, 377, 100, 18);
		getContentPane().add(accompanyLabel);
		
		accompanyField = new JTextField();
		accompanyField.setText("�Ƿ�ѡ������ͬ��");
		accompanyField.setToolTipText("");
		accompanyField.setBounds(191, 374, 240, 28);
		getContentPane().add(accompanyField);
		accompanyField.setColumns(10);
		
		JLabel foodsLabel= new JLabel("�Ƿ�ʳ�ޣ�");
		foodsLabel.setFont(new Font("΢���ź�", Font.BOLD, 15));
		foodsLabel.setBounds(113, 427, 100, 18);
		getContentPane().add(foodsLabel);
		
		foodsField = new JTextField();
		foodsField.setText("�Ƿ�ѡ�����ס�ޣ�");
		foodsField.setBounds(191, 424, 240, 28);
		getContentPane().add(foodsField);
		foodsField.setColumns(10);
		
		JButton button_1 = new JButton("�鿴��������Ϣ");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TouristGroup tg = new TouristGroup();
				tg.setVisible(true);
			}
		});
		button_1.setBounds(453, 324, 158, 27);
		button_1.setFocusPainted(false);//ȥ����ť��Χ�Ľ����
		button_1.setFont(new Font("΢���ź�", Font.BOLD, 13));
		button_1.setBackground(new Color(243, 152, 0));
		button_1.setForeground(Color.WHITE);
		getContentPane().add(button_1);
		
		
		JButton button_2 = new JButton("��");
		button_2.setBounds(453, 376, 72, 27);
		button_2.setFocusPainted(false);//ȥ����ť��Χ�Ľ����
		button_2.setFont(new Font("΢���ź�", Font.BOLD, 13));
		button_2.setBackground(new Color(0, 189, 93));
		button_2.setForeground(Color.WHITE);
		getContentPane().add(button_2);
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accompanyField.setText("��");
			}
		});
		
		JButton button_3 = new JButton("��");
		button_3.setBounds(539, 376, 72, 27);
		button_3.setFocusPainted(false);//ȥ����ť��Χ�Ľ����
		button_3.setFont(new Font("΢���ź�", Font.BOLD, 13));
		button_3.setBackground(new Color(238, 10, 36));
		button_3.setForeground(Color.WHITE);
		getContentPane().add(button_3);
		button_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accompanyField.setText("��");
			}
		});
		
		JButton button_4 = new JButton("��");
		button_4.setBounds(453, 424, 72, 27);
		button_4.setFocusPainted(false);//ȥ����ť��Χ�Ľ����
		button_4.setFont(new Font("΢���ź�", Font.BOLD, 13));
		button_4.setBackground(new Color(0, 189, 93));
		button_4.setForeground(Color.WHITE);
		getContentPane().add(button_4);
		button_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				foodsField.setText("��");
			}
		});
		
		JButton button_5 = new JButton("��");
		button_5.setBounds(539, 424, 72, 27);
		button_5.setFocusPainted(false);//ȥ����ť��Χ�Ľ����
		button_5.setFont(new Font("΢���ź�", Font.BOLD, 13));
		button_5.setBackground(new Color(238, 10, 36));
		button_5.setForeground(Color.WHITE);
		getContentPane().add(button_5);
		button_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				foodsField.setText("��");
			}
		});
		
		//�����ı����ʼֵ
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
		
		//ȷ���޸İ�ť
		JButton submitButton = new JButton("ȷ���޸�");
		submitButton.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		submitButton.setBounds(320, 495, 150, 33);
		submitButton.setFocusPainted(false);//ȥ����ť��Χ�Ľ����
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
				if (accompany.equals("�Ƿ�ѡ������ͬ��")) {
					accompany="��";
				}
				foods = foodsField.getText();
				if (foods.equals("�Ƿ�ѡ�����ס�ޣ�")) {
					foods="��";
				}
				//�ж��������Ϣ�Ƿ�Ϊ�գ��Ƿ�����
				if (name.equals("")||sex.equals("")||age.equals("")||IDcard.equals("")||address.equals("")||phone.equals("")||touristNumber.equals("")||accompany.equals("")||foods.equals("")) {
					JOptionPane.showMessageDialog(null, "������������Ϣ��");
				} else {
					//�ж����֤����
					if (!ValidateUtils.IDcard(IDcard)) {
						JOptionPane.showMessageDialog(null, "���֤����������飡");
					} else {
						String i = select.getString("SELECT user_id FROM `user` WHERE user_state='�ѵ�¼'");
						String sql = "UPDATE tourist SET tourist_name='"+name+"',tourist_sex='"+sex+"',tourist_age='"+age+"',tourist_idcard='"+IDcard+"',tourist_address='"+address+"',tourist_phone='"+phone+"',group_num='"+touristNumber+"',accompanied='"+accompany+"',accommodation='"+foods+"' WHERE tourist_num='"+id+"';";
						int result = updata.addData(sql);
						//�ж��ֻ���
						String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
				        if(phone.length() != 11){
				        	JOptionPane.showMessageDialog(null, "�ֻ���ӦΪ11λ����");
				        }else{
				            Pattern p = Pattern.compile(regex);
				            Matcher m = p.matcher(phone);
				            boolean isMatch = m.matches();
				            if(!isMatch){
				                JOptionPane.showMessageDialog(null, "�����ֻ���" + phone + "�Ǵ����ʽ��");
				            }else {
				            	//�жϲ�����
				            	if (result>0) {
				            		JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
				            		dispose();
//				            		Registration_Management r = new Registration_Management();
//									r.dispose();
//									r.setVisible(true);
				            	} else {
				            		JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ��������Ա��ϵ��");
				            	}
							}
				        }
					}
				}
			}
		});
	}
}
