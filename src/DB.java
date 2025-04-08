import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB {
    private Connection conn; 
    
    public boolean DBconnect() { 
        conn= null; 
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:DB.db");                       
        } 
        catch (SQLException e) { 
            System.out.println(e.getMessage());
	        return false;
        }
        return true;
    }

    public void DBdisconnect() { 
	    if (conn != null) {
	        try {
                conn.close();
            } 
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
	    }
    }

    public void DBsetup() {
        String sql = "CREATE TABLE students (ID int NOT NULL UNIQUE, name varchar(50) NOT NULL, surname varchar(50) NOT NULL, avg double(1))";
        try {
            if (conn!=null) {         
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void DBClearTable() {
        String sql = "DELETE FROM students";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Cannot clear table");
        }
    }
}
