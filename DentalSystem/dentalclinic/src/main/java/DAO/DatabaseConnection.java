package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

	private final static String ConnectString = "jbbc:postgresql://localhost:5432/postgres";
	private final static String userName = "postgres";
	private final static String password = "2699";
	
	private static Connection conn;
	
	private static Statement testst;
	
	public DatabaseConnection() {
		connect();
	}
	public Connection connect(){
        conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(ConnectString,userName,password);
           // conn.setAutoCommit(false);

            System.out.println("Database is connected");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) { 
            e.printStackTrace();
        }

        System.out.println("Database is connected");

        return conn;
    }

    public ResultSet retriveData(String sql){
    	testst = null;
    	ResultSet resultSet = null;
        try {
           testst = conn.createStatement();
       
            
             resultSet = testst.executeQuery(sql);
            
            //testst.close(); 
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
       
        return resultSet;
       


    } 

    public void WriteData(String sql){
        testst = null;
        
        try {
           testst = conn.createStatement();
           String test = sql;
         
            testst.executeUpdate(test);  
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
