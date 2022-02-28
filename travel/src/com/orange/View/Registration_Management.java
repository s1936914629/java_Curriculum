package com.orange.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

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
import javax.swing.table.TableModel;

import com.orange.Bean.Tourist;
import com.orange.Controller.Select;
import com.orange.Controller.Updata;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

/**
 * @Author: wff
 * @description: TODO(�����������)
 */

public class Registration_Management extends JFrame {

	private static final long serialVersionUID = 1L;

	Select select = new Select();
	Updata updata = new Updata();
	JTable jTable;
	DefaultTableModel dt;
	
	Object[] header = {"�������","�ͻ�����","�Ա�","����","���֤��","��ͥסַ","��ϵ�绰","����������","��ͬ","ʳ��"};
	Object[][] data = select.getTourist("SELECT * FROM tourist");
	private JTextField orderNumberField;//�������
	private JTextField touristNumberField;//�ź�
	private JTextField customernameField;//�ͻ�����
	
	public Registration_Management() {
		super("������Ϣ����");
		this.setBounds(0, 0, 1200, 700);
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
        jl_logo.setBounds(993, 15, 200, 50);
        this.add(jl_logo);
	    
        //��ǰʱ��
	    JLabel dqsj = new JLabel("��ǰʱ�� ��");
		dqsj.setBounds(875, 70, 85, 35);
		dqsj.setFont(new Font("΢���ź�", Font.BOLD, 15));
		dqsj.setForeground(Color.white);
		getContentPane().add(dqsj);
		
		JLabel time1 = new JLabel();
		time1.setBounds(960, 71, 236, 35);
		time1.setFont(new Font("΢���ź�", Font.CENTER_BASELINE, 16));
		time1.setForeground(Color.white);
		getContentPane().add(time1);
		this.setTimer(time1);
		
		//ͼƬ���
        JLabel jl = new JLabel();
        jl.setIcon(new ImageIcon("img/timebg.png"));//�ļ�·��
        jl.setBounds(860, 62, 750, 40);
        this.add(jl);     
	    
        //���ڹر�ʱ�������洰��
		this.addWindowListener(new WindowAdapter() {
			 
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				//���붯��
				MainJframe m = new MainJframe();
				m.setVisible(true);
			 }
		});
		
		//������ģ��
		dt=new DefaultTableModel(data,header){
			private static final long serialVersionUID = 1L;
			//���ñ�����ݲ��ɱ��༭
			   public boolean isCellEditable(int row, int column) {
				    return false;//����true��ʾ�ܱ༭��false��ʾ���ܱ༭
			   }
		};
		jTable=new JTable(dt);//�������
		jTable.getTableHeader().setFont(new Font("΢���ź�", Font.BOLD, 14));//���ñ�ͷ����������ʽ
		jTable.getTableHeader().setForeground(Color.white);//���ñ�ͷ����������ɫ
		jTable.getTableHeader().setReorderingAllowed(false);//���ñ�ͷ�������϶�
		jTable.getTableHeader().setBackground(new Color(68, 114, 196));//���ñ�ͷ����ɫ
		
		//���ñ�ͷ�߶�
		Dimension size = jTable.getTableHeader().getPreferredSize();
		size.height = 40;//�����µı�ͷ�߶�40
		jTable.getTableHeader().setPreferredSize(size);
		
		//�����и�
		jTable.setRowHeight(30);//ָ��ÿһ�е��и�50
		 
		//���ñ���п�
		int[] length = {100 , 100 , 50 , 50 , 200 , 300 , 150 , 100 , 50 , 50 };//�����п�
		TableColumnModel model0 = jTable.getColumnModel();
		for (int i = 0 ; i<model0.getColumnCount() ; i++)
		{
			TableColumn column = model0.getColumn(i);//��ȡ�ж���
			column.setPreferredWidth(length[i]);//�����п�
		}
		
		jTable.setFont(new Font("΢���ź�", Font.PLAIN, 14));//���ñ������
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;//ˮƽ������
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;//��ֱ������
		JScrollPane jsp=new JScrollPane(jTable,v,h);//������������
		jsp.setBounds(20, 120, 1150, 530);
		getContentPane().add(jsp);
		
		//�������
		JLabel orderNumberLabel = new JLabel("�������");
		orderNumberLabel.setFont(new Font("΢���ź�", Font.BOLD, 14));
		orderNumberLabel.setBounds(20, 70, 89, 18);
		getContentPane().add(orderNumberLabel);
		
		orderNumberField = new JTextField();
		orderNumberField.setBounds(90, 70, 120, 24);
		getContentPane().add(orderNumberField);
		orderNumberField.setColumns(10);//������������
		
		//�ź�
		JLabel touristNumberLabel = new JLabel("�ź�");
		touristNumberLabel.setFont(new Font("΢���ź�", Font.BOLD, 14));
		touristNumberLabel.setBounds(240, 70, 52, 18);
		getContentPane().add(touristNumberLabel);
		
		touristNumberField = new JTextField();
		touristNumberField.setColumns(10);
		touristNumberField.setBounds(280, 70, 114, 24);
		getContentPane().add(touristNumberField);
		
		//�ͻ�����
		JLabel customernameLabel = new JLabel("�ͻ�����");
		customernameLabel.setFont(new Font("΢���ź�", Font.BOLD, 14));
		customernameLabel.setBounds(420, 70, 80, 18);
		getContentPane().add(customernameLabel);
		
		customernameField = new JTextField();
		customernameField.setColumns(10);
		customernameField.setBounds(490, 70, 114, 24);
		getContentPane().add(customernameField);
		
		//��ѯ��ť
		JButton queryButton = new JButton("��ѯ");
		queryButton.setBounds(20, 20, 110, 30);
		queryButton.setFocusPainted(false);//ȥ����ť��Χ�Ľ����
		queryButton.setFont(new Font("΢���ź�", Font.BOLD, 14));
		queryButton.setBackground(new Color(78, 110, 242));
		queryButton.setForeground(Color.WHITE);
		getContentPane().add(queryButton);
		
		queryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String touristNumber,th,name,sql;
				touristNumber = orderNumberField.getText();
				th = touristNumberField.getText();
				name = customernameField.getText();
				
				if (touristNumber.equals("")&&th.equals("")&&name.equals("")) {
					sql = "SELECT * FROM tourist";
				}
				else if(touristNumber.equals("")&&th.equals("")){
					sql = "SELECT * FROM tourist WHERE tourist_name='"+name+"';";
				}
				else if(name.equals("")&&th.equals("")){
					sql = "SELECT * FROM tourist WHERE tourist_num='"+touristNumber+"';";
				}
				else if(touristNumber.equals("")&&name.equals("")){
					sql = "SELECT * FROM tourist WHERE group_num='"+th+"';";
				}
				else if(touristNumber.equals("")){
					sql = "SELECT * FROM tourist WHERE group_num='"+th+"' and tourist_name='"+name+"';";
				}
				else if(th.equals("")){
					sql = "SELECT * FROM tourist WHERE tourist_num='"+touristNumber+"' and tourist_name='"+name+"';";
				}
				else if(name.equals("")){
					sql = "SELECT * FROM tourist WHERE tourist_num='"+touristNumber+"' and group_num='"+th+"';";
				}
				else {
					sql = "SELECT * FROM tourist WHERE tourist_num='"+touristNumber+"' and group_num='"+th+"' and tourist_name='"+name+"';";
				}
				data = select.getTourist(sql);
				dt.setDataVector(data,header);
				
				//���ñ���п�
				int[] length = {100 , 100 , 50 , 50 , 200 , 300 , 150 , 100 , 50 , 50 };//�����п�
				TableColumnModel model0 = jTable.getColumnModel();
				for (int i = 0 ; i<model0.getColumnCount() ; i++)
				{
					TableColumn column = model0.getColumn(i);//��ȡ�ж���
					column.setPreferredWidth(length[i]);//�����п�
				}
			}
		});
		
		//�޸İ�ť
		JButton alterButton = new JButton("�޸�");
		alterButton.setBounds(150, 20, 110, 30);
		alterButton.setFocusPainted(false);//ȥ����ť��Χ�Ľ����
		alterButton.setFont(new Font("΢���ź�", Font.BOLD, 14));
		alterButton.setBackground(new Color(101, 113, 175));
		alterButton.setForeground(Color.WHITE);
		getContentPane().add(alterButton);
		alterButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if (jTable.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null, "��δѡ��Ҫ�޸ĵ����ݣ�");
				} 
				else {
					//��ȡ�û�ѡ�������
					String name,sex,age,IDcard,address,phone,touristNumber,accompany,foods;
					String id = jTable.getValueAt(jTable.getSelectedRow(), 0).toString();
					String user_id = select.getString("SELECT user_id FROM `user` WHERE user_state='�ѵ�¼'");
					
					name = jTable.getValueAt(jTable.getSelectedRow(), 1).toString();
					sex = jTable.getValueAt(jTable.getSelectedRow(), 2).toString();
					age = jTable.getValueAt(jTable.getSelectedRow(), 3).toString();
					IDcard = jTable.getValueAt(jTable.getSelectedRow(), 4).toString();
					address = jTable.getValueAt(jTable.getSelectedRow(), 5).toString();
					phone = jTable.getValueAt(jTable.getSelectedRow(), 6).toString();
					touristNumber = jTable.getValueAt(jTable.getSelectedRow(), 7).toString();
					accompany = jTable.getValueAt(jTable.getSelectedRow(), 8).toString();
					foods = jTable.getValueAt(jTable.getSelectedRow(), 9).toString();
					
					Tourist tourist=new Tourist(id, user_id, name, sex, age, IDcard, address, phone, touristNumber, accompany, foods);
					RegistrationInfo_Change frame=new RegistrationInfo_Change(tourist);
					
					frame.setVisible(true);
				}
			}
		});
		
		//��Ӱ�ť
		JButton addButton = new JButton("���");
		addButton.setBounds(280, 20, 110, 30);
		addButton.setFocusPainted(false);//ȥ����ť��Χ�Ľ����
		addButton.setFont(new Font("΢���ź�", Font.BOLD, 14));
		addButton.setBackground(new Color(231, 121, 24));
		addButton.setForeground(Color.WHITE);
		getContentPane().add(addButton);
		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//����ӽ���
				Registration_Info r = new Registration_Info();
				r.setVisible(true);
			}
		});
		
		//ɾ����ť
		JButton deleteButton = new JButton("ɾ��");
		deleteButton.setBounds(410, 20, 110, 30);
		deleteButton.setFocusPainted(false);//ȥ����ť��Χ�Ľ����
		deleteButton.setFont(new Font("΢���ź�", Font.BOLD, 14));
		deleteButton.setBackground(new Color(216, 30, 6));
		deleteButton.setForeground(Color.WHITE);
		getContentPane().add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jTable.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null, "��δѡ��Ҫɾ�������ݣ�");
				} 
				else {
					//��ȡ�û�ѡ�������
					String id = jTable.getValueAt(jTable.getSelectedRow(), 0).toString();
					String name = jTable.getValueAt(jTable.getSelectedRow(), 1).toString();
					int result = JOptionPane.showConfirmDialog(null,"��ȷ��Ҫɾ���û�  ��"+name+"��  �ı�����Ϣ��?","ɾ����ʾ",0,1);
					if(result == JOptionPane.OK_OPTION){
						int i = updata.addData("DELETE FROM tourist WHERE tourist_num='"+id+"';");
						if (i>0){
							JOptionPane.showMessageDialog(null, "�û�  ��"+name+"��  ���ѱ�ɾ���ɹ���");
						} 
						else {
							JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
						}
						data=select.getTourist("SELECT * FROM tourist");
						dt.setDataVector(data,header);
						
						//���ñ���п�
						int[] length = {100 , 100 , 50 , 50 , 200 , 300 , 150 , 100 , 50 , 50 };//�����п�
						TableColumnModel model0 = jTable.getColumnModel();
						for (int i1 = 0 ; i1<model0.getColumnCount() ; i1++)
						{
							TableColumn column = model0.getColumn(i1);//��ȡ�ж���
							column.setPreferredWidth(length[i1]);//�����п�
						}
					}
				}
			}
		});
		
		//��ʾ��ť
		JButton tipsButton = new JButton("��ʾ");
		tipsButton.setBounds(540, 20, 110, 30);
		tipsButton.setFocusPainted(false);//ȥ����ť��Χ�Ľ����
		tipsButton.setFont(new Font("΢���ź�", Font.BOLD, 14));
		tipsButton.setBackground(new Color(78, 110, 242));
		tipsButton.setForeground(Color.WHITE);
		getContentPane().add(tipsButton);
		tipsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "<html>��ѯ��ֱ�ӵ�����г����б�����Ϣ��Ҳ����д�οͱ�š��źź��Ա��ѯ��<br>�޸ģ�����οͽ��Ὣ�οͱ�Ű󶨵��ı����У����ԶԸ��οͱ�Ŷ�Ӧ���οͽ����źź��Ա��޸ġ�<br>ɾ�������Ҫɾ������Ϣ�����ɾ�����ɡ�<br>��ӣ��Ա�����Ϣ������ӡ�</html>");
			}
		});
		
		//ˢ�°�ť
		JButton flushButton = new JButton("ˢ��");
		flushButton.setBounds(670, 20, 110, 30);
		flushButton.setFocusPainted(false);//ȥ����ť��Χ�Ľ����
		flushButton.setFont(new Font("΢���ź�", Font.BOLD, 14));
		flushButton.setBackground(new Color(28, 175, 8));
		flushButton.setForeground(Color.WHITE);
		getContentPane().add(flushButton);
		flushButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				data=select.getTourist("SELECT * FROM tourist");
				dt.setDataVector(data,header);
				
				//���ñ���п�
				int[] length = {100 , 100 , 50 , 50 , 200 , 300 , 150 , 100 , 50 , 50 };//�����п�
				TableColumnModel model0 = jTable.getColumnModel();
				for (int i = 0 ; i<model0.getColumnCount() ; i++)
				{
					TableColumn column = model0.getColumn(i);//��ȡ�ж���
					column.setPreferredWidth(length[i]);//�����п�
				}
			}
		});
		
		//���õ�Ԫ�����ݾ�����ʾ
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER); 
		jTable.setDefaultRenderer(Object.class, r);
	}
    
	//����Timer 1000msʵ��һ�ζ��� ʵ����һ���߳�
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
