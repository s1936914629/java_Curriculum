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
 * @description: TODO(主界面)
 */

public class MainJframe extends JFrame {

	private static final long serialVersionUID = 1L;
	
	Select select = new Select();
	Updata updata = new Updata();
	Object[] header = {"线路号","起点城市","目的城市","旅程天数","主要景点"};//表头
	Object[][] data = select.getLineInfo();
	
	public MainJframe() {
		
		this.setTitle("Orange旅游管理系统");
		this.setBounds(0, 0, 1130, 700);
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
        jl_logo.setBounds(950, 6, 200, 50);
        this.add(jl_logo);
	    
		//热门线路按钮
		ImageIcon icon1 = new ImageIcon("img/Icon1.png");
		JButton searchButton = new JButton("热门线路查询",icon1);
		searchButton.setBounds(20, 11, 145, 35);
		searchButton.setFocusPainted(false);//去掉按钮周围的焦点框
		searchButton.setContentAreaFilled(false);//设置按钮透明背景
		searchButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
//		searchButton.setBackground(new Color(255, 153, 41));
		searchButton.setForeground(Color.black);
		getContentPane().add(searchButton);
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//显示热门线路界面
				HotRoutes_Info hr = new HotRoutes_Info();
				hr.setVisible(true);
//				dispose();关闭旧窗口
			}
		});
		
		//报名旅游按钮
		ImageIcon icon2 = new ImageIcon("img/Icon2.png");
		JButton signButton = new JButton("报名旅游",icon2);
		signButton.setBounds(173, 11, 120, 35);
		signButton.setFocusPainted(false);//去掉按钮周围的焦点框
		signButton.setContentAreaFilled(false);//设置按钮透明背景
		signButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
//		signButton.setBackground(new Color(255, 153, 41));
		signButton.setForeground(Color.black);
		getContentPane().add(signButton);
		
		signButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//判断当前是否有用户登录
				String sql = "SELECT COUNT(*) FROM `user` WHERE user_state='已登录'";
				int reselt = select.getCount(sql);
				if (reselt>0) {
					//打开报名界面
					Registration_Info r = new Registration_Info();
					r.setVisible(true);
				} 
				else {
					JOptionPane.showMessageDialog(null, "请先登录！");
					//打开登录界面
					Login l = new Login();
					l.setVisible(true);
//					dispose();
				}
			}
		});
		
		//订单管理按钮
		ImageIcon icon3 = new ImageIcon("img/Icon3.png");
		JButton orderButton = new JButton("订单管理",icon3);
		orderButton.setBounds(300, 11, 125, 35);
		orderButton.setFocusPainted(false);//去掉按钮周围的焦点框
		orderButton.setContentAreaFilled(false);//设置按钮透明背景
		orderButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
//		yhdl.setBackground(new Color(255, 153, 41));
		orderButton.setForeground(Color.black);
		getContentPane().add(orderButton);
		
		orderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//判断当前是否有用户登录
				String sql = "SELECT COUNT(*) FROM `user` WHERE user_state='已登录'";
				int reselt = select.getCount(sql);
				if (reselt>0) {
					//判断当前登录的用户身份
					String user_type = select.getString("SELECT user_type FROM `user` WHERE user_state='已登录'");
					if (user_type.equals("管理员")) {
						//打开订单管理界面
						Registration_Management r = new Registration_Management();
						r.setVisible(true);
						dispose();
					}else{
						JOptionPane.showMessageDialog(null, "当前用户无权限！请登录管理员账号！");
					}
				} else {
					JOptionPane.showMessageDialog(null, "请先登录！");
					//打开登录界面
					Login l = new Login();
					l.setVisible(true);
//					dispose();//关闭旧窗口
				}
			}
		});
		
		//用户切换按钮
		ImageIcon icon4 = new ImageIcon("img/Icon4.png");
		JButton switchButton = new JButton("用户切换",icon4);
		switchButton.setBounds(433, 11, 120, 35);
		switchButton.setFocusPainted(false);//去掉按钮周围的焦点框
		switchButton.setContentAreaFilled(false);//设置按钮透明背景
		switchButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
//		switchButton.setBackground(new Color(255, 153, 41));
		switchButton.setForeground(Color.black);
		getContentPane().add(switchButton);
		
		switchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//判断当前是否有用户登录
				String sql = "SELECT COUNT(*) FROM `user` WHERE user_state='已登录'";
				int reselt = select.getCount(sql);
				if (reselt>0) {
					String i = select.getString("SELECT user_account FROM `user` WHERE user_state='已登录'");
					int a = JOptionPane.showConfirmDialog(null,"当前已有用户" + "   ”"+ i +"”   " + "登录！是否注销？","注销提示",0,1);
					if(a == JOptionPane.OK_OPTION){
						JOptionPane.showMessageDialog(null, "已注销前账户！");
						updata.addData("UPDATE user SET user_state='未登录' WHERE user_account='"+ i +"';");
						//打开登录界面
						Login l = new Login();
						l.setVisible(true);
						dispose();//关闭旧窗口
	                }
				}else {
					//打开登录界面
					Login l = new Login();
					l.setVisible(true);
					dispose();//关闭旧窗口
				}
			}
		});
		
		//添加用户按钮
		ImageIcon icon5 = new ImageIcon("img/Icon5.png");
		JButton appendButton = new JButton("添加用户",icon5);
		appendButton.setBounds(560, 11, 120, 35);
		appendButton.setFocusPainted(false);//去掉按钮周围的焦点框
		appendButton.setContentAreaFilled(false);//设置按钮透明背景
		appendButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
//		appendButton.setBackground(new Color(255, 153, 41));
		appendButton.setForeground(Color.black);
		getContentPane().add(appendButton);
		
		appendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//判断当前是否有用户登录
				String sql = "SELECT COUNT(*) FROM `user` WHERE user_state='已登录'";
				int reselt = select.getCount(sql);
				if (reselt>0) {
					String i = select.getString("SELECT user_account FROM `user` WHERE user_state='已登录'");
//					JOptionPane.showMessageDialog(null, "当前已有用户"+"   ”"+i+"”   "+"登录！是否注销？");
					int a = JOptionPane.showConfirmDialog(null,"当前已有用户" + "   ”" + i + "”   " + "登录！是否注销？","注销提示",0,1);
					if(a == JOptionPane.OK_OPTION){
						JOptionPane.showMessageDialog(null, "已注销前账户！");
						updata.addData("UPDATE user SET user_state='未登录' WHERE user_account='" + i + "';");
						//打开注册界面
						Registered r = new Registered();
						r.setVisible(true);
						//dispose();//打开新窗口的时候关闭旧窗口
	                }
				}else {
					//打开注册界面
					Registered r = new Registered();
					r.setVisible(true);
					//dispose();
				}
			}
		});
		
		//退出系统按钮
		ImageIcon icon6 = new ImageIcon("img/Icon6.png");
		JButton exitButton = new JButton("退出系统",icon6);
		exitButton.setBounds(687, 11, 120, 35);
		exitButton.setFocusPainted(false);//去掉按钮周围的焦点框
		exitButton.setContentAreaFilled(false);//设置按钮透明背景
		exitButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
//		exitButton.setBackground(new Color(255, 153, 41));
		exitButton.setForeground(Color.black);
		getContentPane().add(exitButton);
		
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = JOptionPane.showConfirmDialog(null,"您现在要关闭系统吗?关闭后同时注销账号!","退出提示",0,1);
				if(result == JOptionPane.OK_OPTION){
					JOptionPane.showMessageDialog(null, "已退出系统，欢迎下次使用！");
					updata.addData("UPDATE user SET user_state='未登录';");
                    System.exit(0);
                }
			}
		});
		
		//系统帮助按钮
		ImageIcon icon7 = new ImageIcon("img/Icon7.png");
		JButton helpButton = new JButton("系统帮助",icon7);
		helpButton.setBounds(815, 11, 120, 35);
		helpButton.setFocusPainted(false);//去掉按钮周围的焦点框
		helpButton.setContentAreaFilled(false);//设置按钮透明背景
		helpButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
//		helpButton.setBackground(new Color(101, 113, 175));
		helpButton.setForeground(Color.black);
		getContentPane().add(helpButton);
		
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//打开系统帮助界面
				About a = new About();
				a.setVisible(true);
			}
		});
		
		//当前时间
		JLabel dqsj = new JLabel("当前时间 ：");
		dqsj.setBounds(825, 70, 85, 35);
		dqsj.setFont(new Font("微软雅黑", Font.BOLD, 15));
		dqsj.setForeground(Color.white);
		getContentPane().add(dqsj);
		
		JLabel time1 = new JLabel();
		time1.setBounds(910, 71, 236, 35);
		time1.setFont(new Font("微软雅黑", Font.CENTER_BASELINE, 16));
		time1.setForeground(Color.white);
		getContentPane().add(time1);
		this.setTimer(time1);
		
		//背景图片添加
        JLabel jl = new JLabel();
        jl.setIcon(new ImageIcon("img/timebg.png"));//文件路径
        jl.setBounds(810, 62, 750, 40);
        this.add(jl);     
		
        //文本信息
		JLabel massageLabel = new JLabel("国内热门旅游线路推荐");
		massageLabel.setBounds(20, 65, 200, 35);
		massageLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
		getContentPane().add(massageLabel);
		
		//创建表模型
		DefaultTableModel dt = new DefaultTableModel(data,header){

			private static final long serialVersionUID = 1L;

			   //设置表格内容不可被编辑
			   public boolean isCellEditable(int row, int column) {
				    return false;//返回true表示能编辑，false表示不能编辑
			   }
		};
		
		JTable jTable=new JTable(dt);//创建表格
		jTable.getTableHeader().setFont(new Font("微软雅黑", Font.CENTER_BASELINE, 15));// 设置表头名称字体样式
		jTable.getTableHeader().setForeground(Color.white);// 设置表头名称字体颜色
		jTable.getTableHeader().setResizingAllowed(false);// 设置不允许手动改变列宽
		jTable.getTableHeader().setReorderingAllowed(false);//设置表头不允许拖动
		jTable.getTableHeader().setBackground(new Color(68, 114, 196));//设置表头背景色
		
		//设置表头高度
		Dimension size = jTable.getTableHeader().getPreferredSize();
		size.height = 40;//设置新的表头高度40
		jTable.getTableHeader().setPreferredSize(size);
		
		//设置行高
		jTable.setRowHeight(30);//指定每一行的行高50
		jTable.setFont(new Font("微软雅黑", Font.PLAIN, 14));//设置表格字体
	
		//设置表格列宽
		int[] length = {100 , 200 , 200 , 100 , 400 };//表格的列宽
		TableColumnModel model0 = jTable.getColumnModel();
		for (int i = 0 ; i<model0.getColumnCount() ; i++)
		{
			TableColumn column = model0.getColumn(i);//获取列对象
			column.setPreferredWidth(length[i]);//设置列宽
		}
		
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;//水平滚动条
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;//垂直滚动条
		JScrollPane jsp=new JScrollPane(jTable,v,h);//创建滚动容器
		jsp.setBounds(20, 110, 1070, 530);
		getContentPane().add(jsp);
		
		//设置单元格内容居中显示
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER); 
		jTable.setDefaultRenderer(Object.class, r);
	}
	
	// 设置Timer1000ms实现一次动作 实际是一个线程
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
