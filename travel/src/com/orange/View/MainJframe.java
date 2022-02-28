package com.orange.View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.orange.Controller.Select;
import com.orange.Controller.Updata;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

/**
 * @Author: wff
 * @description: TODO(������)
 */

public class MainJframe extends JFrame {

	private static final long serialVersionUID = 1L;
	
	Select select = new Select();
	Updata updata = new Updata();
	Object[] header = {"��·��","������","Ŀ�ĳ���","�ó�����","��Ҫ����"};//��ͷ
	Object[][] data = select.getLineInfo();
	
	public MainJframe() {
		
		this.setTitle("Orange���ι���ϵͳ");
		this.setBounds(0, 0, 1130, 700);
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
        jl_logo.setBounds(950, 6, 200, 50);
        this.add(jl_logo);
	    
		//������·��ť
		ImageIcon icon1 = new ImageIcon("img/Icon1.png");
		JButton searchButton = new JButton("������·��ѯ",icon1);
		searchButton.setBounds(20, 11, 145, 35);
		searchButton.setFocusPainted(false);//ȥ����ť��Χ�Ľ����
		searchButton.setContentAreaFilled(false);//���ð�ť͸������
		searchButton.setFont(new Font("΢���ź�", Font.BOLD, 14));
//		searchButton.setBackground(new Color(255, 153, 41));
		searchButton.setForeground(Color.black);
		getContentPane().add(searchButton);
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//��ʾ������·����
				HotRoutes_Info hr = new HotRoutes_Info();
				hr.setVisible(true);
//				dispose();�رվɴ���
			}
		});
		
		//�������ΰ�ť
		ImageIcon icon2 = new ImageIcon("img/Icon2.png");
		JButton signButton = new JButton("��������",icon2);
		signButton.setBounds(173, 11, 120, 35);
		signButton.setFocusPainted(false);//ȥ����ť��Χ�Ľ����
		signButton.setContentAreaFilled(false);//���ð�ť͸������
		signButton.setFont(new Font("΢���ź�", Font.BOLD, 14));
//		signButton.setBackground(new Color(255, 153, 41));
		signButton.setForeground(Color.black);
		getContentPane().add(signButton);
		
		signButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//�жϵ�ǰ�Ƿ����û���¼
				String sql = "SELECT COUNT(*) FROM `user` WHERE user_state='�ѵ�¼'";
				int reselt = select.getCount(sql);
				if (reselt>0) {
					//�򿪱�������
					Registration_Info r = new Registration_Info();
					r.setVisible(true);
				} 
				else {
					JOptionPane.showMessageDialog(null, "���ȵ�¼��");
					//�򿪵�¼����
					Login l = new Login();
					l.setVisible(true);
//					dispose();
				}
			}
		});
		
		//��������ť
		ImageIcon icon3 = new ImageIcon("img/Icon3.png");
		JButton orderButton = new JButton("��������",icon3);
		orderButton.setBounds(300, 11, 125, 35);
		orderButton.setFocusPainted(false);//ȥ����ť��Χ�Ľ����
		orderButton.setContentAreaFilled(false);//���ð�ť͸������
		orderButton.setFont(new Font("΢���ź�", Font.BOLD, 14));
//		yhdl.setBackground(new Color(255, 153, 41));
		orderButton.setForeground(Color.black);
		getContentPane().add(orderButton);
		
		orderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//�жϵ�ǰ�Ƿ����û���¼
				String sql = "SELECT COUNT(*) FROM `user` WHERE user_state='�ѵ�¼'";
				int reselt = select.getCount(sql);
				if (reselt>0) {
					//�жϵ�ǰ��¼���û����
					String user_type = select.getString("SELECT user_type FROM `user` WHERE user_state='�ѵ�¼'");
					if (user_type.equals("����Ա")) {
						//�򿪶����������
						Registration_Management r = new Registration_Management();
						r.setVisible(true);
						dispose();
					}else{
						JOptionPane.showMessageDialog(null, "��ǰ�û���Ȩ�ޣ����¼����Ա�˺ţ�");
					}
				} else {
					JOptionPane.showMessageDialog(null, "���ȵ�¼��");
					//�򿪵�¼����
					Login l = new Login();
					l.setVisible(true);
//					dispose();//�رվɴ���
				}
			}
		});
		
		//�û��л���ť
		ImageIcon icon4 = new ImageIcon("img/Icon4.png");
		JButton switchButton = new JButton("�û��л�",icon4);
		switchButton.setBounds(433, 11, 120, 35);
		switchButton.setFocusPainted(false);//ȥ����ť��Χ�Ľ����
		switchButton.setContentAreaFilled(false);//���ð�ť͸������
		switchButton.setFont(new Font("΢���ź�", Font.BOLD, 14));
//		switchButton.setBackground(new Color(255, 153, 41));
		switchButton.setForeground(Color.black);
		getContentPane().add(switchButton);
		
		switchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//�жϵ�ǰ�Ƿ����û���¼
				String sql = "SELECT COUNT(*) FROM `user` WHERE user_state='�ѵ�¼'";
				int reselt = select.getCount(sql);
				if (reselt>0) {
					String i = select.getString("SELECT user_account FROM `user` WHERE user_state='�ѵ�¼'");
					int a = JOptionPane.showConfirmDialog(null,"��ǰ�����û�" + "   ��"+ i +"��   " + "��¼���Ƿ�ע����","ע����ʾ",0,1);
					if(a == JOptionPane.OK_OPTION){
						JOptionPane.showMessageDialog(null, "��ע��ǰ�˻���");
						updata.addData("UPDATE user SET user_state='δ��¼' WHERE user_account='"+ i +"';");
						//�򿪵�¼����
						Login l = new Login();
						l.setVisible(true);
						dispose();//�رվɴ���
	                }
				}else {
					//�򿪵�¼����
					Login l = new Login();
					l.setVisible(true);
					dispose();//�رվɴ���
				}
			}
		});
		
		//����û���ť
		ImageIcon icon5 = new ImageIcon("img/Icon5.png");
		JButton appendButton = new JButton("����û�",icon5);
		appendButton.setBounds(560, 11, 120, 35);
		appendButton.setFocusPainted(false);//ȥ����ť��Χ�Ľ����
		appendButton.setContentAreaFilled(false);//���ð�ť͸������
		appendButton.setFont(new Font("΢���ź�", Font.BOLD, 14));
//		appendButton.setBackground(new Color(255, 153, 41));
		appendButton.setForeground(Color.black);
		getContentPane().add(appendButton);
		
		appendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//�жϵ�ǰ�Ƿ����û���¼
				String sql = "SELECT COUNT(*) FROM `user` WHERE user_state='�ѵ�¼'";
				int reselt = select.getCount(sql);
				if (reselt>0) {
					String i = select.getString("SELECT user_account FROM `user` WHERE user_state='�ѵ�¼'");
//					JOptionPane.showMessageDialog(null, "��ǰ�����û�"+"   ��"+i+"��   "+"��¼���Ƿ�ע����");
					int a = JOptionPane.showConfirmDialog(null,"��ǰ�����û�" + "   ��" + i + "��   " + "��¼���Ƿ�ע����","ע����ʾ",0,1);
					if(a == JOptionPane.OK_OPTION){
						JOptionPane.showMessageDialog(null, "��ע��ǰ�˻���");
						updata.addData("UPDATE user SET user_state='δ��¼' WHERE user_account='" + i + "';");
						//��ע�����
						Registered r = new Registered();
						r.setVisible(true);
						//dispose();//���´��ڵ�ʱ��رվɴ���
	                }
				}else {
					//��ע�����
					Registered r = new Registered();
					r.setVisible(true);
					//dispose();
				}
			}
		});
		
		//�˳�ϵͳ��ť
		ImageIcon icon6 = new ImageIcon("img/Icon6.png");
		JButton exitButton = new JButton("�˳�ϵͳ",icon6);
		exitButton.setBounds(687, 11, 120, 35);
		exitButton.setFocusPainted(false);//ȥ����ť��Χ�Ľ����
		exitButton.setContentAreaFilled(false);//���ð�ť͸������
		exitButton.setFont(new Font("΢���ź�", Font.BOLD, 14));
//		exitButton.setBackground(new Color(255, 153, 41));
		exitButton.setForeground(Color.black);
		getContentPane().add(exitButton);
		
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = JOptionPane.showConfirmDialog(null,"������Ҫ�ر�ϵͳ��?�رպ�ͬʱע���˺�!","�˳���ʾ",0,1);
				if(result == JOptionPane.OK_OPTION){
					JOptionPane.showMessageDialog(null, "���˳�ϵͳ����ӭ�´�ʹ�ã�");
					updata.addData("UPDATE user SET user_state='δ��¼';");
                    System.exit(0);
                }
			}
		});
		
		//ϵͳ������ť
		ImageIcon icon7 = new ImageIcon("img/Icon7.png");
		JButton helpButton = new JButton("ϵͳ����",icon7);
		helpButton.setBounds(815, 11, 120, 35);
		helpButton.setFocusPainted(false);//ȥ����ť��Χ�Ľ����
		helpButton.setContentAreaFilled(false);//���ð�ť͸������
		helpButton.setFont(new Font("΢���ź�", Font.BOLD, 14));
//		helpButton.setBackground(new Color(101, 113, 175));
		helpButton.setForeground(Color.black);
		getContentPane().add(helpButton);
		
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��ϵͳ��������
				About a = new About();
				a.setVisible(true);
			}
		});
		
		//��ǰʱ��
		JLabel dqsj = new JLabel("��ǰʱ�� ��");
		dqsj.setBounds(825, 70, 85, 35);
		dqsj.setFont(new Font("΢���ź�", Font.BOLD, 15));
		dqsj.setForeground(Color.white);
		getContentPane().add(dqsj);
		
		JLabel time1 = new JLabel();
		time1.setBounds(910, 71, 236, 35);
		time1.setFont(new Font("΢���ź�", Font.CENTER_BASELINE, 16));
		time1.setForeground(Color.white);
		getContentPane().add(time1);
		this.setTimer(time1);
		
		//����ͼƬ���
        JLabel jl = new JLabel();
        jl.setIcon(new ImageIcon("img/timebg.png"));//�ļ�·��
        jl.setBounds(810, 62, 750, 40);
        this.add(jl);     
		
        //�ı���Ϣ
		JLabel massageLabel = new JLabel("��������������·�Ƽ�");
		massageLabel.setBounds(20, 65, 200, 35);
		massageLabel.setFont(new Font("΢���ź�", Font.BOLD, 20));
		getContentPane().add(massageLabel);
		
		//������ģ��
		DefaultTableModel dt = new DefaultTableModel(data,header){

			private static final long serialVersionUID = 1L;

			   //���ñ�����ݲ��ɱ��༭
			   public boolean isCellEditable(int row, int column) {
				    return false;//����true��ʾ�ܱ༭��false��ʾ���ܱ༭
			   }
		};
		
		JTable jTable=new JTable(dt);//�������
		jTable.getTableHeader().setFont(new Font("΢���ź�", Font.CENTER_BASELINE, 15));// ���ñ�ͷ����������ʽ
		jTable.getTableHeader().setForeground(Color.white);// ���ñ�ͷ����������ɫ
		jTable.getTableHeader().setResizingAllowed(false);// ���ò������ֶ��ı��п�
		jTable.getTableHeader().setReorderingAllowed(false);//���ñ�ͷ�������϶�
		jTable.getTableHeader().setBackground(new Color(68, 114, 196));//���ñ�ͷ����ɫ
		
		//���ñ�ͷ�߶�
		Dimension size = jTable.getTableHeader().getPreferredSize();
		size.height = 40;//�����µı�ͷ�߶�40
		jTable.getTableHeader().setPreferredSize(size);
		
		//�����и�
		jTable.setRowHeight(30);//ָ��ÿһ�е��и�50
		jTable.setFont(new Font("΢���ź�", Font.PLAIN, 14));//���ñ������
	
		//���ñ���п�
		int[] length = {100 , 200 , 200 , 100 , 400 };//�����п�
		TableColumnModel model0 = jTable.getColumnModel();
		for (int i = 0 ; i<model0.getColumnCount() ; i++)
		{
			TableColumn column = model0.getColumn(i);//��ȡ�ж���
			column.setPreferredWidth(length[i]);//�����п�
		}
		
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;//ˮƽ������
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;//��ֱ������
		JScrollPane jsp=new JScrollPane(jTable,v,h);//������������
		jsp.setBounds(20, 110, 1070, 530);
		getContentPane().add(jsp);
		
		//���õ�Ԫ�����ݾ�����ʾ
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER); 
		jTable.setDefaultRenderer(Object.class, r);
	}
	
	// ����Timer1000msʵ��һ�ζ��� ʵ����һ���߳�
	private void setTimer(JLabel time) {
		final JLabel varTime = time;
		Timer timeAction = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long timemillis = System.currentTimeMillis();
				// ת��������ʾ��ʽ
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				varTime.setText(df.format(new Date(timemillis)));
			}
		});
		timeAction.start();
	}
}
