import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Databaze {

    private static Integer ID=0;
    protected static Map<Integer, Student> StudentList;

    public Databaze() {
        StudentList=new HashMap<Integer, Student>();
    }

    public Integer getNextID() {
        ID++;
        return ID;
    }

    public Integer getID() {
        return ID;
    }

    protected void setID(Integer id) {
        ID=id;
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

    public void setStudent(Integer oborID, String name, String surname, Integer birthDate, Integer ID) {
        setID(ID);
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

    public static Student getStudent(Integer id) {
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

    public boolean setMark(Integer id, Integer mark) {
        if (StudentList.get(id).addMark(mark)) {
            return true;
        }
        return false;
    }

    public String getSpecialAbility(Integer id)
    {
        return StudentList.get(id).specialAbility();
    }

    public Integer getNumberOfStudents() {
        return StudentList.size();
    }
}
