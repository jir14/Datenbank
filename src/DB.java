import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB extends Databaze {
    private Connection conn; 
    private String DBName;

    public String getDBName() {
		return DBName;
	}

    public boolean DBconnect() { 
        if (conn!=null) {
            DBdisconnect();
        }
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:"+DBName);       
        } 
        catch (SQLException e) { 
            System.out.println(e.getMessage());
	        return false;
        }
        return true;
    }

    public boolean DBconnect(String dbName) { 
        if (conn!=null) {
            DBdisconnect();
        } 
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:"+dbName);       
            DBName=dbName;
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
        DBconnect(); 
        String sql1 = "CREATE TABLE IF NOT EXISTS students (ID int NOT NULL UNIQUE, oborID int NOT NULL, name varchar(50) NOT NULL, surname varchar(50) NOT NULL, birthDate int NOT NULL, avg double)";
        String sql2 = "CREATE TABLE IF NOT EXISTS marks (ID int NOT NULL, mark int NOT NULL)";
        try (PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
             PreparedStatement preparedStatement2 = conn.prepareStatement(sql2)) {     
                preparedStatement1.executeUpdate();
                preparedStatement2.executeUpdate();  
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            DBdisconnect();
        }
    }

    public boolean DBload() {
        DBconnect(); 
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT ID,oborID,name,surname,birthDate,avg FROM students")){       

            while (rs.next()) {
                int ID = rs.getInt("ID");
                int oborID = rs.getInt("oborID");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int birthDate = rs.getInt("birthDate");
                double avg = rs.getDouble("avg");
                setStudent(oborID, name, surname, birthDate, ID);
                if (avg>=1 || avg<=5) {
                    StudentList.get(ID).setStudPrumer(avg);
                }

                String sqlSelectMark = "SELECT mark FROM marks WHERE ID=?";

                try (PreparedStatement pstmtStud = conn.prepareStatement(sqlSelectMark)) {
                    
                    pstmtStud.setInt(1, ID);

                    try (ResultSet rsMarks = pstmtStud.executeQuery()){
                        while (rsMarks.next()) {
                            StudentList.get(ID).addMarkOnly(rsMarks.getInt("mark"));
                        }
                    } catch (Exception e) {
                        System.out.println("Cannot load marks for student n. "+ID);
                    }       
                } catch (Exception e) {
                    System.out.println("Cannot load marks for student n. "+ID);
                }
            }
            return true;  
        } catch (Exception e) {
            System.out.println("Data not loaded");
            return false;
        } 
        finally {
            DBdisconnect();
        }
    }

	public boolean DBfill() {
        DBconnect();
        Integer studID;

        String sqlDeleteStuds = "DROP TABLE IF EXISTS 'students'";
        String sqlDeleteMarks = "DROP TABLE IF EXISTS 'marks'";
        try (PreparedStatement prepStuds = conn.prepareStatement(sqlDeleteStuds);
             PreparedStatement prepMarks = conn.prepareStatement(sqlDeleteMarks)) {
            prepStuds.executeUpdate();
            prepMarks.executeUpdate();
            System.out.println("Predesla verze databaze smazana");
            DBsetup();
        } catch (SQLException e) {
            System.out.println("Vytvarim novou DB");
            DBsetup();
        }

        DBconnect();
        for (Student stud : StudentList.values()) {
            String sqlInsertStud = "INSERT INTO students(ID,oborID,name,surname,birthDate,avg) VALUES(?,?,?,?,?,?)";
            try (PreparedStatement pstmtStud = conn.prepareStatement(sqlInsertStud)) {
                studID=stud.getID();
                pstmtStud.setInt(1, studID);
                pstmtStud.setInt(2, stud.getOborID());
                pstmtStud.setString(3, stud.getName());
                pstmtStud.setString(4, stud.getSurname());
                pstmtStud.setInt(5, stud.getBirthDate());
                pstmtStud.setDouble(5, stud.getStudPrumer());
                pstmtStud.executeUpdate();

                for (Integer mark : stud.getMarks()) {
                    String sqlInsertMark = "INSERT INTO marks(ID,mark) VALUES(?,?)";
                    try (PreparedStatement pstmtMarks = conn.prepareStatement(sqlInsertMark)) {
                        pstmtMarks.setInt(1, studID);
                        pstmtMarks.setInt(2, mark);
                        pstmtMarks.executeUpdate();
                    } catch (Exception e) {
                        System.out.println("Cannot insert marks for student n. "+studID);
                    }
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                DBdisconnect();
                return false;
            }
        }
        DBdisconnect();
        return true;
    }

    public boolean DBremove(String dbName) {
        DBdisconnect();
        boolean result = new File(dbName).delete();
        return result;
    }
}
