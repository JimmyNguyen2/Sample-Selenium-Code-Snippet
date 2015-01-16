import java.sql.*;
/**
 * 
 * @author Jimmy Nguyen
 * This code snippet shows how to connect to MySQL database and run a select query
 * then print the result.( need to download the jar file: mysql-connector-java-5.1.34-bin.jar)
 *
 */
public class MySqlConnection {

	public static void main(String[] args){
		
		try{
			//connect to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://127.001.3306/sakila","root","");
			
			//Create a statement
			Statement myStmt = myConn.createStatement();
			
			//Execute SQL query
			ResultSet myRs = myStmt.executeQuery("select * from category");
			
			//Process the result set
			while (myRs.next()){
				System.out.println(myRs.getString("category_id" + " " + myRs.getString("name" + " " + myRs.getString("last_update"))));
			}
			
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
	}
}
