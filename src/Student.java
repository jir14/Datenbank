import java.util.List;

public abstract class Student {
	protected String Name;
	protected String Surname;
	protected static int ID;
	protected String BirthDate;
	protected List<Student> StudentList;
	protected List<Integer> StudentMarks;
	
	public Student(String name, String surname, String birthDate) {
		Name=name;
		Surname=surname;
		BirthDate=birthDate;
	}

	public boolean AddMark(Integer mark) {
		if (mark >= 1 && mark <=5) {
			StudentMarks.add(mark);
			return true;
		}
		return false;
	}
}
