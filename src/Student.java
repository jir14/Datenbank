import java.util.ArrayList;
import java.util.List;

public abstract class Student {
	private String Name;
	private String Surname;
	private int ID;
	private String BirthDate;
	protected ArrayList<Student> StudentList = new ArrayList<Student>();
	protected ArrayList<Integer> StudentMarks = new ArrayList<Integer>();
	
	public abstract String specialAbility();

	public Student(String name, String surname, String birthDate) {
		Name=name;
		Surname=surname;
		BirthDate=birthDate;
		ID=Databaze.getNextID();
	}

	public String getName() {
		return Name;
	}

	public String getSurname() {
		return Surname;
	}

	public Integer getID() {
		return ID;
	}

	public boolean addMark(Integer mark) {
		if (mark >= 1 && mark <= 5) {
			StudentMarks.add(mark);
			return true;
		}
		return false;
	}

	public ArrayList<Integer> getMarks() {
		return StudentMarks;
	}

}
