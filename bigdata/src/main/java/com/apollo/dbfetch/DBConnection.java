package com.apollo.dbfetch;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private final static String DB_URL = "jdbc:oracle:thin:@10.20.36.16:1521:crmcn";
	private final static String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String DB_USERNAME = "finance";
	private final static String DB_PASSWORD = "oracle";

	public static Connection getConnection() {
		/** ����Connection���Ӷ��� */
		Connection conn = null;
		try {
			/** ʹ��Class.forName()�����Զ�����������������ʵ�����Զ�����DriverManager��ע���� */
			Class.forName(DB_DRIVER);
			/** ͨ��DriverManager��getConnection()������ȡ���ݿ����� */
			conn = DriverManager
					.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}

	/**
	 * �ر����ݿ�����
	 * 
	 * @param connect
	 */
	public void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				/** �жϵ�ǰ�������Ӷ������û�б��رվ͵��ùرշ��� */
				if (!conn.isClosed()) {
					conn.close();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
