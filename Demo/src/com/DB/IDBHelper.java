package com.DB;

import java.sql.Connection;

public interface IDBHelper {
	
	public Connection getConnection();
	
	public void closeConnection(Connection on);
}
