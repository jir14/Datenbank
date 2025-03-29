import java.util.ArrayList;

public abstract class Student implements Comparable<Object> {
	private String Name;
	private String Surname;
	private int OborID;
	private int ID;
	private	double StudPrumer=0.0;
	private Integer BirthDate;
	protected ArrayList<Integer> StudentMarks = new ArrayList<Integer>();
	
	public abstract String specialAbility();

	public Student(Integer id, Integer oborID, String name, String surname, Integer birthDate) {
		ID=id;
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

	public Integer getBirthDate() {
		return BirthDate;
	}

	public Integer getID() {
		return ID;
	}

	public boolean addMark(Integer mark) {
		if (mark >= 1 && mark <= 5) {
			StudentMarks.add(mark);
			StudPrumer = calcStudPrumer();
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

	public double getStudPrumer() {
		return StudPrumer;
	}

	private double calcStudPrumer() {
		double sum=0;
		for (Integer mark : StudentMarks) {
			sum+=mark;
		}
		return sum/StudentMarks.size();
	}
}
