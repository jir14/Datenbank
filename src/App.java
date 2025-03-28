import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("David je ghej");
        System.out.println("David je ghej");
        Student stud = new TLI("david", "chuj", "01.01.2001");
        stud.addMark(2);
        stud.addMark(5);
        for (Integer mark : stud.getMarks()) {
            System.out.println(mark);
        }
    }
}
