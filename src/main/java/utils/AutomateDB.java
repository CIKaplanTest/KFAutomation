package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AutomateDB {

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		 String dbUrl = "jdbc:sqlserver://DELSPHTSCSQL01:1433";					

			//Database Username		
			String username = "RetailWeb";	
   
			//Database Password		
			String password = "Ret@ilweb123";				

			//Query to Execute		
			String query = "select *  from [CredentialsService].[dbo].[UserCredentialInfo];";	
   
	    //Load mysql jdbc driver		
	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");			

		//Create Connection to DB		
	Connection con = DriverManager.getConnection(dbUrl,username,password);

		//Create Statement Object		
	   Statement stmt = (Statement) con.createStatement();					

			// Execute the SQL Query. Store results in ResultSet		
		ResultSet rs= stmt.executeQuery(query);							

		// While Loop to iterate through all data and print results		
			while (rs.next()){
		        		String userId = rs.getString(1);								        
               String userName = rs.getString(2);					                               
               System. out.println(userId+"  "+userName);		
       }		
			 // closing DB Connection		
			con.close();			
	
		// TODO Auto-generated method stub

		
	}

}
