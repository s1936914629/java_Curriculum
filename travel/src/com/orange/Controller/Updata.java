package com.orange.Controller;
import com.orange.Dao.DbConnection;

/**
 *
 * @Description: 数据库添加
 * @Author: wff
 */

public class Updata {
	
	//添加数据
	public int addData(String sql) {
		
		return DbConnection.updataInfo(sql);
	}
	
}
