package com.orange.View;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @Author: wff
 * @description: TODO(����������·��Ϣҳ��)
 */
public class HotRoutes_Info extends JFrame {

	private static final long serialVersionUID = 1L;

	public HotRoutes_Info() { 
		
		super.setTitle("������Ϣ��ѯ");
		this.setBounds(0, 0, 900, 600);
		this.setLocationRelativeTo(null);//�ô�������Ļ�м���ʾ
  	    this.setResizable(false);//�ô��ڴ�С���ɸı�
  	   
		//���ô���ͼ��
	    Toolkit tk = Toolkit.getDefaultToolkit();
	    Image frameImage=tk.createImage("img/logo.png");//ͼƬ·��
	    this.setIconImage(frameImage);
	    
	    //ͼƬ���
        JLabel jl = new JLabel();
        jl.setIcon(new ImageIcon("img/hotroutes.png"));//�ļ�·��
        jl.setBounds(0, 0, 750, 600);
        this.add(jl);     
	}
}
