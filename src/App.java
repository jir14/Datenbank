
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("David je ghej");
        System.out.println("David je ghej");
        Databaze db = new Databaze();
        db.setTLIStudent("david", "chuj", "01.01.2001");
        db.setIBEStudent("Jorge", "BAD", "01.01.2001");
        System.out.println(db.getStudent(1).getName());
    }
}
