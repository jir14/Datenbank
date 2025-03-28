import java.util.ArrayList;

public class Databaze {

    public Databaze() {
        ArrayList<Student> StudentList = new ArrayList<Student>();
    }

    public void setTLIStudent(String name, String surname, String birthDate) {
        new TLI(name, surname,birthDate);
    }

    public void setIBEStudent(String name, String surname, String birthDate) {
        new TLI(name, surname,birthDate);
    }
}
