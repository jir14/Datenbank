import java.util.ArrayList;
import java.util.Collections;
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

    public void setStudent(Integer oborID, String name, String surname, Integer birthDate) {
        getNextID();
        switch (oborID) {
            case 1:
                StudentList.put(ID, new TLI(ID, oborID, name, surname, birthDate));
                break;
            case 2:
                StudentList.put(ID, new IBE(ID, oborID, name, surname, birthDate));
                break;

            default:
                System.out.println("Zadany obor neexistuje.");
                break;
        }
    }

    public Student getStudent(Integer id) {
        return StudentList.get(id);
    }

    public void getStudentInfo(Integer id) {
        System.out.println("Prijmeni " + getStudent(id).getSurname() + ", jemno: " + getStudent(id).getName() + ", rok naroz.: " + getStudent(id).getBirthDate()+ ", stud. prumer: " + getStudent(id).getStudPrumer() );
    }

    public void Wykonanie(Integer id) {
        StudentList.remove(id);
    }

    public ArrayList<Student> getOrderedStudentsIn(Integer oborID) {
        ArrayList<Student> studs = getStudentsIn(oborID);    
        Collections.sort(studs);
        return studs;
    }

    public void getStudentsInInfo(Integer id) {
        for (Student stud : getOrderedStudentsIn(id)) {
            getStudentInfo(stud.getID());
        }
    }

    public ArrayList<Student> getStudentsIn(Integer oborID) {
        ArrayList<Student> studs = new ArrayList<Student>();
        for (Student stud : StudentList.values()) {
            if (stud.getOborID()==oborID) {
                studs.add(stud);
            }
        }       
        return studs;
    }

    public double getAvgIn(Integer oborID) {
        double sum=0.0;
        double avg=0.0;
        Integer validStud=0;
        ArrayList<Student> studs = getStudentsIn(oborID);
        for (Student stud : studs) {
            avg = stud.getStudPrumer();
            if (avg>=1 && avg<=5) {
                sum+=stud.getStudPrumer();
                validStud++;
            }
        }
        return sum/validStud;
    }

    public Integer getNumberOfStudentsIn(Integer oborID) {
        int studs=0;
        for (Student stud : StudentList.values()) {
            if (stud.getOborID()==oborID) {
                studs++;
            }
        }
        return studs;
    }

    public void setMark(Integer id, Integer mark) {
        StudentList.get(id).addMark(mark);
    }

    public void specialAbility(Integer id) {
        StudentList.get(id).specialAbility();
    }
}
