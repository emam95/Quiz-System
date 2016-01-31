/*
 * author: Mohamed Emam
 * date: 11-7-2015
 */
package quiz.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class Data {
	
	private static String schema;
	private static Connection myCon = null;
	private static Statement myStat = null;
	private static ResultSet res = null;
	private static boolean error = false;
	private static String errorMessage = "";
	
	private Data(){
		
	}
	
	public static boolean isError()
	{
		return error;
	}
	
	public static void setSchema(String name)
	{
		schema = name;
	}
	
	
	public static String getError()
	{
		return errorMessage;
	}
	
	
	public static void startConnection() //url , id , pass as default parameter :/
	{
		String url = "jdbc:mysql://localhost:3306/" + schema;
		String id = "emam";
		String pass = "emam";
		
		try{
			myCon = DriverManager.getConnection(url, id , pass);
			myStat = myCon.createStatement();
		}catch(Exception exc){
			exc.printStackTrace();
			errorMessage = "Error : " + exc;
			error = true;
		}
	}
		
	
	public static void getTable(String tableName)
	{
		try {
			res = myStat.executeQuery("select * from " + tableName);
		}
		catch(Exception exc) {
			exc.printStackTrace();
			errorMessage = "Error : " + exc;
			error = true;
		}
	}
	
	
	public static void printTable(String tableName)
	{
		Data.getTable(tableName);
		try {
			while (res.next()){
				System.out.println(res.getString("question") + " , " + res.getString("answer"));
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
			errorMessage = "Error : " + exc;
			error = true;
		}
	}
	
	
	public static Map<Integer, String> getCol(String tableName, String colName)
	{
		Map<Integer, String> data = new HashMap<Integer, String>();
		try {
			res = myStat.executeQuery("select * from " + tableName);

			while (res.next()){
			data.put(res.getInt(1), res.getString(colName));
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
			errorMessage = "Error : " + exc;
			error = true;
		}
		return data;
	}
	
	public static Map<String, String> getCols(String tableName, String col1,String col2)
	{
		Map<String, String> data = new HashMap<String, String>();
		try {
			res = myStat.executeQuery("select * from " + tableName);

			while (res.next()){
			data.put(res.getString(col1), res.getString(col2));
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
			errorMessage = "Error : " + exc;
			error = true;
		}
		return data;
	}
	
	public static int getIntCell(String column,String tableName, int id)
	{
		int x = 0;
		try {
			res = myStat.executeQuery("Select " + column + " from " + tableName + " where id= " + id);
			while(res.next()){
				x = res.getInt(1);
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
			errorMessage = "Error : " + exc;
			error = true;
		}
		return x;
	}
	
	public static int getIntCell(String column, String tableName, String col2, String value)
	{
		int x = 0;
		try {
			res = myStat.executeQuery("Select " + column + " from " + tableName + " where " + col2 +" = " + "'" + value + "'");
			while(res.next()){
				x = res.getInt(column);
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
			errorMessage = "Error : " + exc;
			error = true;
		}
		return x;
	}
	
	public static String getStringCell(String column,String tableName, int id)
	{
		String s = "";
		try {
			res = myStat.executeQuery("Select " + column + " from " + tableName + " where id= " + id);
			while(res.next()){
				s = res.getString(column);
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
			errorMessage = "Error : " + exc;
			error = true;
		}
		return s;
	}
	
	public static Timestamp getDateCell(String column,String tableName, int id)
	{
		Timestamp t = null;
		try {
			res = myStat.executeQuery("Select " + column + " from " + tableName + " where id= " + id);
			while(res.next()){
				t = res.getTimestamp(column);
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
			errorMessage = "Error : " + exc;
			error = true;
		}
		return t;
	}
	
	public static int getMaxId(String tableName)
	{
		int max = 0;
		try {
			res = myStat.executeQuery("Select max(id) from " + tableName);
			while(res.next()){
				max = res.getInt(1);
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
			errorMessage = "Error : " + exc;
			error = true;
		}
		return max;
	}
	
	public static void insert(String tableName, String columns,String values)
	{
		try {
			String sql = "insert into " + tableName
					   + " (" + columns + ")"
					   + " values (" + values + ")";
		
			myStat.executeUpdate(sql);

			System.out.println("Insert complete.");
		}catch(Exception exc) {
			exc.printStackTrace();
			errorMessage = "Error : " + exc;
			error = true;
		}
	}
	
	public static void insertPrepDate(String tableName, String columns,Timestamp time,String values)
	{
		try {
			String sql = "insert into " + tableName
					   + " (" + columns + ")"
					   + " values (?," + values + ")";
		
			PreparedStatement prepState = myCon.prepareStatement(sql);
			prepState.setTimestamp(1, time);
			prepState.executeUpdate();
			prepState.close();

		}catch(Exception exc) {
			exc.printStackTrace();
			errorMessage = "Error : " + exc;
			error = true;
		}
	}
	
	public static void update(String tableName, String column, String value, int id)
	{
		try{
			String sql = "update " + tableName + " set " + column + "=" + value+ " where id=" + id;
			
			int rowsAffected = myStat.executeUpdate(sql);

			System.out.println("Rows affected: " + rowsAffected);
			System.out.println("Update complete.");
		}catch(Exception exc) {
			exc.printStackTrace();
			errorMessage = "Error : " + exc;
			error = true;
		}
	}
	
	public static void delete(String tableName,int id)
	{
		try {
		String sql = "delete from " + tableName + " where id=" + id;
		
		int rowsAffected = myStat.executeUpdate(sql);

		System.out.println("Rows affected: " + rowsAffected);
		System.out.println("Delete complete.");
		}catch(Exception exc) {
			exc.printStackTrace();
			errorMessage = "Error : " + exc;
			error = true;
		}
	}
	
	public static void closeConnection()
	{
			try 
			{
				if (myStat != null) 
				{
					myStat.close();
				}
				if (myCon != null)
				{
					myCon.close();
				}
			}catch(Exception exc) 
			{
				exc.printStackTrace();
				errorMessage = "Error : " + exc;
				error = true;
			}
	}

}
