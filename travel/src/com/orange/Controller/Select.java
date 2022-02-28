package com.orange.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.orange.Bean.Tourism_Line;
import com.orange.Bean.Tourist;
import com.orange.Dao.DbConnection;

/**
 *
 * @Description: 数据库查询
 * @Author: wff
 */


@SuppressWarnings({"AlibabaCommentsMustBeJavadocFormat", "MethodNameSameAsClassName"})
public class Select {
	//查询数据条数
	public int getCount(String sql) {
		ResultSet resultSet=DbConnection.query(sql);
		try {
			if (resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//得到一条数据
	public String getString(String sql) {
		ResultSet resultSet=DbConnection.query(sql);
		try {
			if (resultSet.next()) {
				return resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//用户登录
	public int Select(String account, String password) {
		String sql="select * from UserInfo where password='"+password+"'  and account='"+account+"'";
		ResultSet resultSet=DbConnection.query(sql);
		int a=0;
		try {
			while (resultSet.next()) {
				a=1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	//旅游信息表
	public Object[][] getLineInfo() {
		String sql="SELECT * FROM tourism_line";
		ResultSet resultSet = DbConnection.query(sql);
		ArrayList<Tourism_Line> list=new ArrayList<Tourism_Line>();
		try {
			while (resultSet.next()) {
				Tourism_Line t=new Tourism_Line();
				t.setRoute_num(resultSet.getString(1));
				t.setOrigin(resultSet.getString(2));
				t.setDestination(resultSet.getString(3));
				t.setDay_num(resultSet.getString(4));
				t.setAttractions(resultSet.getString(5));
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Object[][] objects=new Object[list.size()][5];
		for(int i=0;i<list.size();i++) {
			objects[i][0]=list.get(i).getRoute_num();
			objects[i][1]=list.get(i).getOrigin();
			objects[i][2]=list.get(i).getDestination();
			objects[i][3]=list.get(i).getDay_num();
			objects[i][4]=list.get(i).getAttractions();
		}
		return objects;
	}
	//旅游信息表
	public Object[][] getTourist(String sql) {
//		String sql="SELECT * FROM tourist";
		ResultSet resultSet = DbConnection.query(sql);
		ArrayList<Tourist> list=new ArrayList<Tourist>();
		try {
			while (resultSet.next()) {
				Tourist t=new Tourist();
				t.setTourist_num(resultSet.getString(1));
				t.setUser_id(resultSet.getString(2));
				t.setTourist_name(resultSet.getString(3));
				t.setTourist_sex(resultSet.getString(4));
				t.setTourist_age(resultSet.getString(5));
				t.setTourist_idCard(resultSet.getString(6));
				t.setTourist_address(resultSet.getString(7));
				t.setTourist_phone(resultSet.getString(8));
				t.setGroup_num(resultSet.getString(9));
				t.setAccompanied(resultSet.getString(10));
				t.setAccommodation(resultSet.getString(11));
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Object[][] objects=new Object[list.size()][10];
		for(int i=0;i<list.size();i++) {
			objects[i][0]=list.get(i).getTourist_num();
			objects[i][1]=list.get(i).getTourist_name();
			objects[i][2]=list.get(i).getTourist_sex();
			objects[i][3]=list.get(i).getTourist_age();
			objects[i][4]=list.get(i).getTourist_idCard();
			objects[i][5]=list.get(i).getTourist_address();
			objects[i][6]=list.get(i).getTourist_phone();
			objects[i][7]=list.get(i).getGroup_num();
			objects[i][8]=list.get(i).getAccompanied();
			objects[i][9]=list.get(i).getAccommodation();
		}
		return objects;
	}
	
}