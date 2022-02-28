package com.orange.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

/**
 * @Description: ���ݿ�����
 * @Author: wff
 */

public class DbConnection {
	//�����������
	private static final String DRIVERNAME="com.mysql.jdbc.Driver";
	//�������ݵ�URL·��
	private static final String URL="jdbc:mysql://127.0.0.1:3306/orange_travel_manage";
	//���ݿ��¼�˺�
	private static final String USER="root";
	//���ݿ��¼����
	private static final String PASSWORD="root";
	//��������
	static{
		try {
			Class.forName(DRIVERNAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
    //��ȡ���ݿ�����
	public static Connection getConnection() {
	    try {
	    	return DriverManager.getConnection(URL,USER,PASSWORD);
	    } catch (SQLException e) {	
	    	e.printStackTrace();
	    }
			return null;
	}
	//��ѯ
	public static ResultSet query(String sql) {
		System.out.println(sql);
		//��ȡ����
		Connection connection=getConnection();
		PreparedStatement psd;
		try {
			psd = connection.prepareStatement(sql);
			return psd.executeQuery();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"ִ��������\n"+e.toString());
			e.printStackTrace();
		}
		return null;
	}
	//����ɾ���ġ���
	public static int updataInfo(String sql) {
		System.out.println(sql);
		//��ȡ����
		Connection connection=getConnection();
		try {
			PreparedStatement psd=connection.prepareStatement(sql);
			return psd.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"ִ��������\n"+e.toString());
			e.printStackTrace();
		}
		return 0;
	}
	//�ر�����
	public  static  void colse(ResultSet rs,Statement stmt,Connection  conn) throws Exception{
	          try { if (rs != null){ rs.close(); }
                         	 if (stmt != null) { stmt.cancel(); }
		 if (conn != null) { conn.close(); }
	   } catch (Exception e) {
		   e.printStackTrace(); throw new Exception();
	   }
	}
}	