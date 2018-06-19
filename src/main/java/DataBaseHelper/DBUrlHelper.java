package DataBaseHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUrlHelper 
{
	private static final String GetLatestOrderID = "select TOP 1 WebOrderId FROM [OrdersService].[dbo].[WebOrder] order by Id desc";
	private static final String GetApprovalID = "Select ApprovalCode from [CredentialsService].[dbo].[EmailVerification] where Email like ";
	
	
	public static String GetApprovalURL(String emailId) throws ClassNotFoundException, SQLException
	{
		return "http://sys.kaplan.co.uk/SponsoredRequest?OrderId="+ GetWebOrderId()+"&approvalcode="+ GetApprovalIdByUserId(emailId);
	}
	
	private static String GetWebOrderId() throws ClassNotFoundException, SQLException
	{
		return GetQueryResult(GetLatestOrderID);
	}
	
	private static String GetApprovalIdByUserId(String EmailId)throws ClassNotFoundException, SQLException
	{
		String query = GetApprovalID + "'%"+ EmailId +"%'";
		return GetQueryResult(query);
	}
	
	private static String GetQueryResult(String query)throws ClassNotFoundException, SQLException
	{
		try
		{
		 String dbUrl = "jdbc:sqlserver://DELSPHTSCSQL01:1433";					

			//Database Username		
			String username = "RetailWeb";	

			//Database Password		
			String password = "Ret@ilweb123";			

	    //Load mysql jdbc driver		
	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");			

		//Create Connection to DB		
	Connection con = DriverManager.getConnection(dbUrl,username,password);

		//Create Statement Object		
	   Statement stmt = (Statement) con.createStatement();					

			// Execute the SQL Query. Store results in ResultSet		
		ResultSet rs= stmt.executeQuery(query);							
		rs.next();
		String result = rs.getString(1);
		
		//closing DB Connection
		con.close();
		return result;
		
		}
		catch(Exception ex)
		{
		    return null;
		}
	}
	
	
}

