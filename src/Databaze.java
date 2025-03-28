import java.util.ArrayList;

public class Databaze {

    private static int ID;

    public Databaze() {
        ArrayList<Student> StudentList = new ArrayList<Student>();
        ID=1;
    }

    public static Integer getNextID() {
        ID++;
        return ID;
    }

    public void setTLIStudent(String name, String surname, String birthDate) {
        new TLI(name, surname,birthDate);
    }

    public void setIBEStudent(String name, String surname, String birthDate) {
        new TLI(name, surname,birthDate);
    }
}
