import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //Inicializace
        Databaze db = new Databaze();
        Scanner sc = new Scanner(System.in);
        DB database = new DB();
        Files file = new Files();
        boolean run=true;  
        boolean exit=false;
        int _int;
        String dbName="DB.db";

        //Debug
        /*
        System.out.println("--- DEBUG START ---");
        
        db.setStudent(1, "pero", "bengr", 2001);
        db.setStudent(1, "david", "ahuj", 2001);
        db.setStudent(2, "zdenek", "zabak", 2001);
        db.setStudent(2, "Jorge", "BAD", 2001);
     
        db.setMark(1, 1 );
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
            System.out.println();
            System.out.println("Hlavni menu");
            System.out.println("1. Upravy databaze");
            System.out.println("2. Vytvoreni studenta");
            System.out.println("3. Pridani znamky");
            System.out.println("4. Podrobnosti studenta");
            System.out.println("5. Informace o oboru");
            System.out.println("6. Ukoncit aplikaci");
            System.out.print("volba> ");
            int volba = Tests.IntOnly(sc);
            System.out.println();

            switch(volba)
            {
                case 1:
                    exit=false;

                    do {
                        System.out.println();
                        System.out.println("Hlavni menu");
                        System.out.println("└> Prace s databazi "+dbName);
                        System.out.println("   1. Nacteni dat z DB");
                        System.out.println("   2. Zmena DB");
                        System.out.println("   3. Uloz databazi");
                        System.out.println("   4. Smaz databazi");
                        System.out.println("   5. Uloz studenta do souboru");
                        System.out.println("   6. Nacti studenta ze souboru");
                        System.out.println("   7. exit");
                        System.out.print("volba> ");
                        volba = Tests.IntOnly(sc);
                        String fileName;
                        switch (volba) {
                        case 1:
                            if  (database.DBconnect(dbName)) {
                                if (database.DBload()) {
                                    System.out.println("Import probehl uspesne");
                                } else {
                                    System.out.println("Chyba pri nacitani databaze "+dbName);
                                }
                            } else {
                                System.out.println("Databazi "+dbName+" nelze otevrit");
                            }
                            break;

                        case 2:
                            System.out.println("Zadejte jmeno databaze (xz.db): ");
                            dbName = sc.next();
                            if (dbName!=database.getDBName()) {
                                database.DBconnect(dbName);
                                database.DBsetup();
                                System.out.println("Pripojeno k "+dbName);
                            } else {
                                System.out.println("Databaze "+dbName+" je jiz pouzivana.");
                            }
                            break;

                        case 3:
                            if  (database.DBconnect(dbName)) {
                                if (database.DBfill()) {
                                    System.out.println("Databaze ulozena do souboru "+dbName);
                                } else {
                                    System.out.println("Chyba pri ukladani databaze");
                                }
                            } else {
                                System.out.println("Databazi "+dbName+" nelze ulozit");
                            }
                            break;

                        case 4:
                            System.out.println("Zadejte jmeno databaze (xz.db): ");
                            dbName = sc.next();
                            if (database.DBremove(dbName)) {
                                System.out.println("Databaze "+dbName+" smazana.");
                                System.out.println("Aktualni detabaze je DB.db");
                            } else {
                                System.out.println("Neco se pokazilo, databaze nesmazana.");
                            }
                            break;

                        case 5:
                            System.out.println("Zadejte jmeno souboru (xz.dat): ");
                            fileName = sc.next();
                            _int = Tests.ValidStudID(sc);
                            if(file.ulozStudenta(fileName, _int)) {
                                System.out.println("Student s ID "+_int+" ulozen do souboru "+fileName);
                            } else {
                                System.out.println("Studenta nebylo mozne ulozit do souboru");
                            }
                            break;

                        case 6:
                            System.out.println("Zadejte jmeno souboru (xz.dat): ");
                            fileName = sc.next();
                            System.out.println("Zadejte ID studenta, ktereho chcete nacist ze souboru: ");
                            _int = Tests.IntOnly(sc);
                            if (database.getStudent(_int)!=null) {
                                System.out.println("Student se zadanym ID jiz existuje");
                                break;
                            }
                            if(file.nactiStudenta(fileName, _int)) {
                                System.out.println("Student s ID "+_int+" nacten ze souboru "+fileName);
                            } else {
                                System.out.println("Student s ID "+_int+" v souboru "+fileName+" nenalezen");
                            }
                            break;

                        case 7:
                            System.out.println("Ukladam DB do souboru "+dbName);
                            if  (database.DBconnect(dbName)) {
                                if (database.DBfill()) {
                                    System.out.println("Databze ulozena do souboru "+dbName);
                                } else {
                                    System.out.println("Chyba pri ukladani databaze");
                                }
                            } else {
                                System.out.println("Databazi "+dbName+" nelze ulozit");
                            }
                            exit=true;
                            break;
                        
                        default:
                            System.out.println("Byla zvolena neexistujici volba");
                            break;
                        }
                    } while (!exit);
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
                                break; 

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
                                break;
                            
                            default:
                                System.out.println("Byla zvolena neexistujici volba");
                                break;
                    }
                    } while (!exit);
                    break;

                case 6:
                    run=false;
                    database.DBfill();
                    System.out.println("Databaze "+dbName+" ulozena");
                    System.out.println();
                    System.out.println("Budeme se tesit priste!");
                    break;

                default:
                    System.out.println("Byla zvolena neexistujici volba");
                    break;
            } 
        }  
    }
}