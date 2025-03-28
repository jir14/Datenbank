import java.util.ArrayList;
import java.util.Collection;
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

    public void setStudent(Integer oborID, String name, String surname, String birthDate) {
        getNextID();
        switch (oborID) {
            case 1:
                StudentList.put(ID, new TLI(oborID, name, surname,birthDate));
                break;
            case 2:
                StudentList.put(ID, new IBE(oborID, name, surname,birthDate));
                break;

            default:
                System.out.println("Zadany obor neexistuje.");
                break;
        }
    }

    public Student getStudent(Integer id) {
        return StudentList.get(id);
    }

    public void Wykonanie(Integer id) {
        StudentList.remove(id);
    }

    public ArrayList<Student> getOrderedStudents(Integer oborID) {
        ArrayList<Student> studs = new ArrayList<Student>();/*
        for (Student stud : StudentList.values()) {
            if (stud.getOborID()==oborID) {
                studs.add(stud);
            }
        }
        */
        return studs;
    }
}
