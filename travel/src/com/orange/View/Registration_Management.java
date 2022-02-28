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
 * @description: TODO(订单管理界面)
 */

public class Registration_Management extends JFrame {

	private static final long serialVersionUID = 1L;

	Select select = new Select();
	Updata updata = new Updata();
	JTable jTable;
	DefaultTableModel dt;
	
	Object[] header = {"订单编号","客户姓名","性别","年龄","身份证号","家庭住址","联系电话","所属旅游团","陪同","食宿"};
	Object[][] data = select.getTourist("SELECT * FROM tourist");
	private JTextField orderNumberField;//订单编号
	private JTextField touristNumberField;//团号
	private JTextField customernameField;//客户姓名
	
	public Registration_Management() {
		super("订单信息管理");
		this.setBounds(0, 0, 1200, 700);
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
        jl_logo.setBounds(993, 15, 200, 50);
        this.add(jl_logo);
	    
        //当前时间
	    JLabel dqsj = new JLabel("当前时间 ：");
		dqsj.setBounds(875, 70, 85, 35);
		dqsj.setFont(new Font("微软雅黑", Font.BOLD, 15));
		dqsj.setForeground(Color.white);
		getContentPane().add(dqsj);
		
		JLabel time1 = new JLabel();
		time1.setBounds(960, 71, 236, 35);
		time1.setFont(new Font("微软雅黑", Font.CENTER_BASELINE, 16));
		time1.setForeground(Color.white);
		getContentPane().add(time1);
		this.setTimer(time1);
		
		//图片添加
        JLabel jl = new JLabel();
        jl.setIcon(new ImageIcon("img/timebg.png"));//文件路径
        jl.setBounds(860, 62, 750, 40);
        this.add(jl);     
	    
        //窗口关闭时打开主界面窗口
		this.addWindowListener(new WindowAdapter() {
			 
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				//加入动作
				MainJframe m = new MainJframe();
				m.setVisible(true);
			 }
		});
		
		//创建表模型
		dt=new DefaultTableModel(data,header){
			private static final long serialVersionUID = 1L;
			//设置表格内容不可被编辑
			   public boolean isCellEditable(int row, int column) {
				    return false;//返回true表示能编辑，false表示不能编辑
			   }
		};
		jTable=new JTable(dt);//创建表格
		jTable.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 14));//设置表头名称字体样式
		jTable.getTableHeader().setForeground(Color.white);//设置表头名称字体颜色
		jTable.getTableHeader().setReorderingAllowed(false);//设置表头不允许拖动
		jTable.getTableHeader().setBackground(new Color(68, 114, 196));//设置表头背景色
		
		//设置表头高度
		Dimension size = jTable.getTableHeader().getPreferredSize();
		size.height = 40;//设置新的表头高度40
		jTable.getTableHeader().setPreferredSize(size);
		
		//设置行高
		jTable.setRowHeight(30);//指定每一行的行高50
		 
		//设置表格列宽
		int[] length = {100 , 100 , 50 , 50 , 200 , 300 , 150 , 100 , 50 , 50 };//表格的列宽
		TableColumnModel model0 = jTable.getColumnModel();
		for (int i = 0 ; i<model0.getColumnCount() ; i++)
		{
			TableColumn column = model0.getColumn(i);//获取列对象
			column.setPreferredWidth(length[i]);//设置列宽
		}
		
		jTable.setFont(new Font("微软雅黑", Font.PLAIN, 14));//设置表格字体
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;//水平滚动条
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;//垂直滚动条
		JScrollPane jsp=new JScrollPane(jTable,v,h);//创建滚动容器
		jsp.setBounds(20, 120, 1150, 530);
		getContentPane().add(jsp);
		
		//订单编号
		JLabel orderNumberLabel = new JLabel("订单编号");
		orderNumberLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
		orderNumberLabel.setBounds(20, 70, 89, 18);
		getContentPane().add(orderNumberLabel);
		
		orderNumberField = new JTextField();
		orderNumberField.setBounds(90, 70, 120, 24);
		getContentPane().add(orderNumberField);
		orderNumberField.setColumns(10);//设置内容容量
		
		//团号
		JLabel touristNumberLabel = new JLabel("团号");
		touristNumberLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
		touristNumberLabel.setBounds(240, 70, 52, 18);
		getContentPane().add(touristNumberLabel);
		
		touristNumberField = new JTextField();
		touristNumberField.setColumns(10);
		touristNumberField.setBounds(280, 70, 114, 24);
		getContentPane().add(touristNumberField);
		
		//客户姓名
		JLabel customernameLabel = new JLabel("客户姓名");
		customernameLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
		customernameLabel.setBounds(420, 70, 80, 18);
		getContentPane().add(customernameLabel);
		
		customernameField = new JTextField();
		customernameField.setColumns(10);
		customernameField.setBounds(490, 70, 114, 24);
		getContentPane().add(customernameField);
		
		//查询按钮
		JButton queryButton = new JButton("查询");
		queryButton.setBounds(20, 20, 110, 30);
		queryButton.setFocusPainted(false);//去掉按钮周围的焦点框
		queryButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
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
				
				//设置表格列宽
				int[] length = {100 , 100 , 50 , 50 , 200 , 300 , 150 , 100 , 50 , 50 };//表格的列宽
				TableColumnModel model0 = jTable.getColumnModel();
				for (int i = 0 ; i<model0.getColumnCount() ; i++)
				{
					TableColumn column = model0.getColumn(i);//获取列对象
					column.setPreferredWidth(length[i]);//设置列宽
				}
			}
		});
		
		//修改按钮
		JButton alterButton = new JButton("修改");
		alterButton.setBounds(150, 20, 110, 30);
		alterButton.setFocusPainted(false);//去掉按钮周围的焦点框
		alterButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
		alterButton.setBackground(new Color(101, 113, 175));
		alterButton.setForeground(Color.WHITE);
		getContentPane().add(alterButton);
		alterButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if (jTable.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null, "您未选中要修改的数据！");
				} 
				else {
					//获取用户选择的数据
					String name,sex,age,IDcard,address,phone,touristNumber,accompany,foods;
					String id = jTable.getValueAt(jTable.getSelectedRow(), 0).toString();
					String user_id = select.getString("SELECT user_id FROM `user` WHERE user_state='已登录'");
					
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
		
		//添加按钮
		JButton addButton = new JButton("添加");
		addButton.setBounds(280, 20, 110, 30);
		addButton.setFocusPainted(false);//去掉按钮周围的焦点框
		addButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
		addButton.setBackground(new Color(231, 121, 24));
		addButton.setForeground(Color.WHITE);
		getContentPane().add(addButton);
		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//打开添加界面
				Registration_Info r = new Registration_Info();
				r.setVisible(true);
			}
		});
		
		//删除按钮
		JButton deleteButton = new JButton("删除");
		deleteButton.setBounds(410, 20, 110, 30);
		deleteButton.setFocusPainted(false);//去掉按钮周围的焦点框
		deleteButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
		deleteButton.setBackground(new Color(216, 30, 6));
		deleteButton.setForeground(Color.WHITE);
		getContentPane().add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jTable.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null, "您未选中要删除的数据！");
				} 
				else {
					//获取用户选择的数据
					String id = jTable.getValueAt(jTable.getSelectedRow(), 0).toString();
					String name = jTable.getValueAt(jTable.getSelectedRow(), 1).toString();
					int result = JOptionPane.showConfirmDialog(null,"您确定要删除用户  “"+name+"”  的报名信息吗?","删除提示",0,1);
					if(result == JOptionPane.OK_OPTION){
						int i = updata.addData("DELETE FROM tourist WHERE tourist_num='"+id+"';");
						if (i>0){
							JOptionPane.showMessageDialog(null, "用户  “"+name+"”  ，已被删除成功！");
						} 
						else {
							JOptionPane.showMessageDialog(null, "删除失败！");
						}
						data=select.getTourist("SELECT * FROM tourist");
						dt.setDataVector(data,header);
						
						//设置表格列宽
						int[] length = {100 , 100 , 50 , 50 , 200 , 300 , 150 , 100 , 50 , 50 };//表格的列宽
						TableColumnModel model0 = jTable.getColumnModel();
						for (int i1 = 0 ; i1<model0.getColumnCount() ; i1++)
						{
							TableColumn column = model0.getColumn(i1);//获取列对象
							column.setPreferredWidth(length[i1]);//设置列宽
						}
					}
				}
			}
		});
		
		//提示按钮
		JButton tipsButton = new JButton("提示");
		tipsButton.setBounds(540, 20, 110, 30);
		tipsButton.setFocusPainted(false);//去掉按钮周围的焦点框
		tipsButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
		tipsButton.setBackground(new Color(78, 110, 242));
		tipsButton.setForeground(Color.WHITE);
		getContentPane().add(tipsButton);
		tipsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "<html>查询：直接点击将列出所有报名信息，也可填写游客编号、团号和性别查询。<br>修改：点击游客将会将游客编号绑定到文本框中，可以对该游客编号对应的游客进行团号和性别修改。<br>删除：点击要删除的信息，点击删除即可。<br>添加：对报名信息进行添加。</html>");
			}
		});
		
		//刷新按钮
		JButton flushButton = new JButton("刷新");
		flushButton.setBounds(670, 20, 110, 30);
		flushButton.setFocusPainted(false);//去掉按钮周围的焦点框
		flushButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
		flushButton.setBackground(new Color(28, 175, 8));
		flushButton.setForeground(Color.WHITE);
		getContentPane().add(flushButton);
		flushButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				data=select.getTourist("SELECT * FROM tourist");
				dt.setDataVector(data,header);
				
				//设置表格列宽
				int[] length = {100 , 100 , 50 , 50 , 200 , 300 , 150 , 100 , 50 , 50 };//表格的列宽
				TableColumnModel model0 = jTable.getColumnModel();
				for (int i = 0 ; i<model0.getColumnCount() ; i++)
				{
					TableColumn column = model0.getColumn(i);//获取列对象
					column.setPreferredWidth(length[i]);//设置列宽
				}
			}
		});
		
		//设置单元格内容居中显示
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER); 
		jTable.setDefaultRenderer(Object.class, r);
	}
    
	//设置Timer 1000ms实现一次动作 实际是一个线程
	private void setTimer(JLabel time) {
		final JLabel varTime = time;
		Timer timeAction = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long timemillis = System.currentTimeMillis();
				// 转换日期显示格式
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				varTime.setText(df.format(new Date(timemillis)));
			}
		});
		timeAction.start();
	}
}
