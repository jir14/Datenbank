import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Databaze {

    private Integer ID=0;
    private Map<Integer, Student> StudentList;

    public Databaze() {
        StudentList=new HashMap<Integer, Student>();
    }

    public Integer getNextID() {
        ID++;
        return ID;
    }

    public void setTLIStudent(String name, String surname, String birthDate) {
        getNextID();
        StudentList.put(ID, new TLI(name, surname,birthDate));
    }

    public void setIBEStudent(String name, String surname, String birthDate) {
        getNextID();
        StudentList.put(ID, new IBE(name, surname,birthDate));
    }

    public Student getStudent(Integer id) {
        return StudentList.get(id);
    }
}
