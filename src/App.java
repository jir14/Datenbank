import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //Inicializace
        Databaze db = new Databaze();
        Scanner sc=new Scanner(System.in);
        boolean run=true;

        //Debug
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


        while (run) {
            System.out.println("1. Vytvoreni databaze");
            System.out.println("2. Vytvoreni studenta");
            System.out.println("3. Vypis studenta");
            System.out.println("4. Abecedni vypis studentu");
            System.out.println("5. Informace o oboru");
            System.out.print("Vase volba: ");
            int volba = Tests.IntOnly(sc);
            System.out.println();

            switch(volba)
            {
                //1. Vytvoreni databaze
                case 1:
                    db = new Databaze();
                    break;
                    
                //2. Vytvoreni studenta
                case 2:
                    //Volba oboru
                    int oborID;
                    do {
                        System.out.println("Zadejte kod oboru [TLI - 1; IBE - 2]: ");
                        oborID = Tests.IntOnly(sc);
                    } while (oborID<1 || oborID>2);

                    //Zadani jmena
                    System.out.println("Zadejte jmeno studenta: ");
                    String name = sc.next();

                    //Zadani prijmeni
                    System.out.println("Zadejte prijmeni studenta: ");
                    String surname = sc.next();

                    //Zadani data narozeni
                    int birthDate=0;
                    do {
                        System.out.println("Zadejte rok narozeni: ");
                        birthDate = Tests.IntOnly(sc);
                    } while (birthDate<1);

                    //Pripsani
                    if (db==null)
                    {
                        System.out.println("Databaze nebyla vytvorena, vytvareni databaze");
                        db=new Databaze();
                    }
                    db.setStudent(oborID, name, surname, birthDate);
                    System.out.println("Student vytvoren, ID=" + db.getID());
                    break;
                
                //3. Vypis studenta
                case 3:
                    int ID=0;
                    boolean repeat=true;
                    do {
                        System.out.println("Zadejte ID studenta: ");
                        ID = Tests.IntOnly(sc);
                        if (db.getStudent(ID)==null) {
                            System.out.println("Student se zadanym ID neexistuje");
                        } else {
                            repeat=false;
                        }
                    } while (repeat);
                    db.getStudentInfo(ID);
                    break;
                
                //4. Abecedni vypis studentu
                case 4:
                    break;
                
                //5. Informace o oboru
                case 5:
                    int vyberID = 0;

                    do { 
                        System.out.print("Zadejte obor: [0 - Obecne; 1 - TLI; 2 - IBE]");
                        vyberID = Tests.IntOnly(sc);
                        
                    } while (vyberID > 2 || vyberID < 0);

                    double avgVysledek = db.getAvgIn(vyberID);

                    //Rozhodnout pokud chceme případ 0 (obecně) nebo ne
                    if(Double.isNaN(avgVysledek)) 
                    {
                            System.out.println("Nebyly zadany znamky pro vypocet prumeru");
                    }
                    else 
                    {                   
                        System.out.println("Prumer:" + db.getAvgIn(vyberID));
                    }
                    break;
                default:
                    System.out.println("Vyla zvolena neexistujici volba");
                    break;
            } 
            System.out.println();
        }  
    }
}