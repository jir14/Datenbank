public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("David je ghej");
        System.out.println("David je ghej");
        Databaze db = new Databaze();
        db.setStudent(1, "pero", "negr", 2005);
        db.setStudent(1, "david", "chuj", 1111);
        db.setStudent(1, "pero", "negr", 3211);
        db.setStudent(2, "Jorge", "BAD", 5555);
        System.out.println(db.getStudent(1).getName());
        for (Student stud : db.getOrderedStudentsIn(1)) {
            db.getStudentInfo(stud.getID());
        }
        System.out.println(db.getNumberOfStudentsIn(1));
        System.out.println(db.getStudent(2).getStudPrumer());
        System.out.println(db.getStudent(2).specialAbility());
        System.out.println(db.getStudent(4).specialAbility());
    }
}
