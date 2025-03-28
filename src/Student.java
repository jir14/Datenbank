import java.util.List;

public abstract class Student {
	private String Name;
	private String Surname;
	private static int ID;
	private String BirthDate;
	private List<Student> StudentList;
	
	public Student(String name, String surname, String birthDate) {
		Name=name;
		Surname=surname;
		BirthDate=birthDate;
	}
}
