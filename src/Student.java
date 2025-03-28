import java.util.List;

public abstract class Student {
	private String Name;
	private String Surname;
	private static int ID;
	private String BirthDate;
	protected List<Student> StudentList;
	protected List<Integer> StudentMarks;
	
	public Student(String name, String surname, String birthDate) {
		Name=name;
		Surname=surname;
		BirthDate=birthDate;
	}

	public void setName(String name) {
		Name=name;
	}

	public void setSurname(String surname) {
		Surname=surname;
	}

	public String getName() {
		return Name;
	}

	public String getSurname() {
		return Surname;
	}

	public boolean AddMark(Integer mark) {
		if (mark >= 1 && mark <= 5) {
			StudentMarks.add(mark);
			return true;
		}
		return false;
	}

	public abstract String specialAbility();
}
