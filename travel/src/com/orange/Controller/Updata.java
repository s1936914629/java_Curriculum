package com.orange.Controller;
import com.orange.Dao.DbConnection;

/**
 *
 * @Description: ���ݿ����
 * @Author: wff
 */

public class Updata {
	
	//�������
	public int addData(String sql) {
		
		return DbConnection.updataInfo(sql);
	}
	
}
