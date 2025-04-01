import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //Inicializace
        Databaze db = new Databaze();
        Scanner sc=new Scanner(System.in);
        boolean run=true;  
        boolean exit=false;
        int _int;

        //Debug
        /*
        System.out.println("--- DEBUG START ---");
        
        db.setStudent(1, "pero", "bengr", 2001);
        db.setStudent(1, "david", "ahuj", 2001);
        db.setStudent(2, "zdenek", "zabak", 2001);
        db.setStudent(2, "Jorge", "BAD", 2001);
     
        db.setMark(1,1 );
        db.setMark(1, 3);
        db.setMark(2, 2);
        db.setMark(3, 5);
        db.setMark(4, 2);
        

        System.out.println("--- DEBUG END ---");
        //Debug
        */

        System.out.println("\033[0;31m" + "####################\r\n" +
                            "#####" + "\u001B[47m" + "     " + "\u001B[0m" + "\033[0;31m" + "##########\r\n" +
                            "##########" + "\u001B[47m" +  "  ..." + "\u001B[0m" + "\033[0;31m" + "#####\r\n" +
                            "##########" + "\u001B[47m" + " " + "\u001B[0m" + "\033[0;31m" + "#########\r\n" +
                            "##########" + "\u001B[47m" + " " + "\u001B[0m" + "\033[0;31m" + "#########\r\n" +
                            "##########" + "\u001B[47m" + " " + "\u001B[0m" + "\033[0;31m" + "#########\r\n" +
                            "####################\r\n" +
                            "\u001B[0m"
                            );


        while (run) {
            System.out.println("Hlavni menu");
            System.out.println("1. Vytvoreni databaze");
            System.out.println("2. Vytvoreni studenta");
            System.out.println("3. Pridani znamky");
            System.out.println("4. Podrobnosti studenta");
            System.out.println("5. Informace o oboru");
            System.out.print("volba> ");
            int volba = Tests.IntOnly(sc);
            System.out.println();

            switch(volba)
            {
                case 1:
                    db = new Databaze();
                    break;
                    
                case 2:
                    _int=Tests.CisloOboru(sc);

                    System.out.println("Zadejte jmeno studenta: ");
                    String name = sc.next();

                    System.out.println("Zadejte prijmeni studenta: ");
                    String surname = sc.next();

                    int birthDate=0;
                    do {
                        System.out.println("Zadejte rok narozeni: ");
                        birthDate = Tests.IntOnly(sc);
                    } while (birthDate<1);

                    db.setStudent(_int, name, surname, birthDate);
                    System.out.println("Student vytvoren, ID=" + db.getID());
                    break;

                case 3:
                    _int = Tests.ValidStudID(sc);
                    db.setMark(_int, Tests.markRange(sc));
                    break;
                
                case 4:
                    if (db.getNumberOfStudents()==0) {
                        System.out.println("V databazi se nenachazi zadny student");
                        break;
                    }
                    _int = Tests.ValidStudID(sc);
                    exit=false;      

                    do {
                        System.out.println();
                        System.out.println("Hlavni menu");
                        System.out.println("└> Podrobnosti studenta "+_int);
                        System.out.println("   1. Vypis studenta");
                        System.out.println("   2. Specialni abilita studenta");
                        System.out.println("   3. Odstraneni studenta");
                        System.out.println("   4. Zpet");
                        System.out.print("volba> ");
                        volba = Tests.IntOnly(sc);
                        System.out.println();
                        switch(volba)
                        {
                            case 1:
                                db.getStudentInfo(_int);
                                break;

                            case 2:
                                db.getSpecialAbility(_int);
                                break;
                            case 3:
                                db.Wykonanie(_int);
                                System.out.println("Student se zadanym ID: "+ _int + " byl odstranen");
                                exit=true;
                                break; 
                            case 4:
                                exit=true;    
                            default:
                                System.out.println("Byla zvolena neexistujici volba");
                                break;
                    }
                    } while (!exit); 
                    break;
                    
                case 5:
                    System.out.println();
                    _int=Tests.CisloOboru(sc); 
                    exit=false;        

                    do {
                        System.out.println();
                        System.out.println("Hlavni menu");
                        System.out.println("└> Informace o oboru s kodem "+_int);
                        System.out.println("   1. Pocet studentu oboru");
                        System.out.println("   2. Prumerne hodnoceni zaka oboru");
                        System.out.println("   3. Studenti oboru dle abecedy");
                        System.out.println("   4. exit");
                        System.out.print("volba> ");
                        volba = Tests.IntOnly(sc);
                        switch (volba) {
                            case 1:
                                System.out.println(db.getNumberOfStudentsIn(_int));
                                break;

                            case 2:
                                double avgVysledek = db.getAvgIn(_int);
                                if(Double.isNaN(avgVysledek)) 
                                {
                                    System.out.println("Nebyly zadany znamky pro vypocet prumeru");
                                } else {                   
                                    System.out.println("Prumer oboru: " + avgVysledek);
                                }
                                break;

                            case 3:
                                db.getStudentsInInfo(_int); 
                                break;
                        
                            case 4:
                                exit=true;
                            
                            default:
                                System.out.println("Byla zvolena neexistujici volba");
                                break;
                    }
                    } while (!exit);
                    break;

                default:
                    System.out.println("Byla zvolena neexistujici volba");
                    break;
            } 
            System.out.println();
        }  
    }
}