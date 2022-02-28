package com.orange.View;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @Author: wff
 * @description: TODO(热门旅游线路信息页面)
 */
public class HotRoutes_Info extends JFrame {

	private static final long serialVersionUID = 1L;

	public HotRoutes_Info() { 
		
		super.setTitle("旅游信息查询");
		this.setBounds(0, 0, 900, 600);
		this.setLocationRelativeTo(null);//让窗口在屏幕中间显示
  	    this.setResizable(false);//让窗口大小不可改变
  	   
		//设置窗口图标
	    Toolkit tk = Toolkit.getDefaultToolkit();
	    Image frameImage=tk.createImage("img/logo.png");//图片路径
	    this.setIconImage(frameImage);
	    
	    //图片添加
        JLabel jl = new JLabel();
        jl.setIcon(new ImageIcon("img/hotroutes.png"));//文件路径
        jl.setBounds(0, 0, 750, 600);
        this.add(jl);     
	}
}
