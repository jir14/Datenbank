
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("David je ghej");
        System.out.println("David je ghej");
        Student stud = new TLI("david", "chuj", "01.01.2001");
        Student studIBE = new IBE("Jorge", "BAD", "01.01.2001");
        System.out.println(studIBE.specialAbility());
        System.out.println(stud.getID());
        System.out.println(studIBE.getID());
    }
}
