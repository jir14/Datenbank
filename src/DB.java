import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB extends Databaze {
    private Connection conn; 
    private String sql;
    private String DBName;

    public String getDBName() {
		return DBName;
	}

	public void setDBName(String dBName) {
		DBName = dBName;
	}

    public boolean DBconnect() { 
        conn=null; 
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
        conn=null; 
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
        String sql1 = "CREATE TABLE IF NOT EXISTS students (ID int NOT NULL UNIQUE, oborID int NOT NULL, name varchar(50) NOT NULL, surname varchar(50) NOT NULL, birthDate int NOT NULL, avg double)";
        String sql2 = "CREATE TABLE IF NOT EXISTS marks (ID int NOT NULL, mark int NOT NULL)";
        try {
            if (conn!=null) {     
                PreparedStatement preparedStatement;   
                preparedStatement = conn.prepareStatement(sql1);
                preparedStatement.executeUpdate();
                preparedStatement = conn.prepareStatement(sql2);
                preparedStatement.executeUpdate();
                DBdisconnect();
            }    
        } catch (Exception e) {
            DBdisconnect();
            System.out.println(e.getMessage());

        }
    }

    public void DBClearTable() {
        sql = "DELETE FROM students";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
            DBdisconnect();
        } catch (Exception e) {
            DBdisconnect();
            System.out.println("Cannot clear table");
        }
    }

    public boolean DBload() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID,oborID,name,surname,birthDate,avg FROM students");            

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

                try {
                    Statement stmtMarks = conn.createStatement();
                    ResultSet rsMarks = stmtMarks.executeQuery("SELECT mark FROM marks WHERE ID="+ID);

                    while (rsMarks.next()) {
                        StudentList.get(ID).addMarkOnly(rsMarks.getInt("mark"));
                    }
                } catch (Exception e) {
                    System.out.println("Cannot load marks for student n. "+ID);
                }
            }
            DBdisconnect();
            return true;  
        } catch (Exception e) {
            DBdisconnect();
            System.out.println("Data not loaded");
            return false;
        }
    }

    public boolean DBloadStud(Integer ID) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT oborID,name,surname,birthDate,avg FROM students WHERE ID="+ID);

            while (rs.next()) {
                int oborID = rs.getInt("oborID");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int birthDate = rs.getInt("birthYear");
                double avg = rs.getDouble("avg");
                setStudent(oborID, name, surname, birthDate, ID);
                if (!StudentList.get(ID).setStudPrumer(avg)) {
                    System.out.println("Cannot set average for sudent n. "+ID);
                }

                try {
                    Statement stmtMarks = conn.createStatement();
                    ResultSet rsMarks = stmtMarks.executeQuery("SELECT mark FROM marks WHERE ID="+ID);

                    while (rsMarks.next()) {
                        StudentList.get(ID).addMark(rs.getInt("mark"));
                    }
                } catch (Exception e) {
                    DBdisconnect();
                    System.out.println("Cannot load marks for student n. "+ID);
                }
            }   
            DBdisconnect();
            return true;
        } catch (Exception e) {
            DBdisconnect();
            System.out.println("Data not loaded");
            return false;
        }
    } 

	public boolean DBfill() {
        Integer studID;

        String sqlDeleteTables = "DROP TABLE IF EXISTS students, marks";
        try {
            conn.prepareStatement(sqlDeleteTables).executeUpdate();
            System.out.println("Predesla verze databaze smazana");
        } catch (SQLException e) {
            System.out.println("Vytvarim novou databazi");
        }

        for (Student stud : StudentList.values()) {
            String sqlInsertStud = "INSERT INTO students(ID,oborID,name,surname,birthDate,avg) VALUES(?,?,?,?,?,?)";
            try {
                studID=stud.getID();
                System.out.println(studID);
                PreparedStatement pstmtStud = conn.prepareStatement(sqlInsertStud); 
                pstmtStud.setInt(1, studID);
                pstmtStud.setInt(2, stud.getOborID());
                pstmtStud.setString(3, stud.getName());
                pstmtStud.setString(4, stud.getSurname());
                pstmtStud.setInt(5, stud.getBirthDate());
                pstmtStud.setDouble(5, stud.getStudPrumer());
                pstmtStud.executeUpdate();

                for (Integer mark : stud.getMarks()) {
                    String sqlInsertMark = "INSERT INTO marks(ID,mark) VALUES(?,?)";
                    try {
                        PreparedStatement pstmtMarks = conn.prepareStatement(sqlInsertMark);
                        pstmtMarks.setInt(1, studID);
                        pstmtMarks.setInt(2, mark);
                        pstmtMarks.executeUpdate();
                    } catch (Exception e) {
                        System.out.println("Cannot insert marks for student n. "+studID);
                    }
                }
            } catch (SQLException e) {
                DBdisconnect();
                System.out.println(e.getMessage());
                return false;
            }
        }
        DBdisconnect();
        return true;
    }
}
