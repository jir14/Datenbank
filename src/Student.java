import java.util.ArrayList;

public abstract class Student implements Comparable {
	private String Name;
	private String Surname;
	private int OborID;
	private int ID;
	private String BirthDate;
	protected ArrayList<Integer> StudentMarks = new ArrayList<Integer>();
	
	public abstract String specialAbility();

	public Student(Integer oborID, String name, String surname, String birthDate) {
		OborID=oborID;
		Name=name;
		Surname=surname;
		BirthDate=birthDate;
	}

	public String getName() {
		return Name;
	}

	public String getSurname() {
		return Surname;
	}

	public String getBirtDate() {
		return BirthDate;
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

	public Integer getOborID() {
		return OborID;
	}
}
