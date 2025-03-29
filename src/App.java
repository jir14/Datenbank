import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Databaze db = new Databaze();
        db.setStudent(1, "pero", "negr", 2001);
        db.setStudent(1, "david", "chuj", 2001);
        db.setStudent(1, "pero", "negr", 2001);
        db.setStudent(2, "Jorge", "BAD", 2001);
     
        db.setMark(1,1 );
        db.setMark(1, 2);
        
        System.out.println("pes");

        System.out.println(db.getAvgIn(1));

        Scanner sc=new Scanner(System.in);
        
        System.out.println("1. Vytvoreni databaze");
        System.out.println("2. Vytvoreni studenta");
        System.out.println("3. Vybrat studenta");
        System.out.println("4. Abecedni vypis studentu");
        System.out.println("5. Informace o oboru");

        int volba = sc.nextInt();

        switch(volba)
        {
            //1. Vytvoreni databaze
            case 1:
                Databaze dtb = new Databaze();
                break;

            //2. Vytvoreni studenta
            case 2:
                //Volba oboru
                System.out.println("Zadejte kod oboru: [1. TLI; 2. IBE]: ");
                int obor = sc.nextInt();
                
                //Zadani jmena
                System.out.println("Zadejte jmeno studenta: ");
                String name = sc.next();

                //Zadani prijmeni
                System.out.println("Zadejte jmeno studenta: ");
                String surname = sc.next();

                //Zadani data narozeni
                System.out.println("Zadejte jmeno studenta: ");
                String birthDate = sc.next();

                //Pripsani
                /*
                if (dtb != null)
                {
                    System.out.println("Databaze nebyla vytvorena, vytvareni databaze");
                    Databaze dtb = new Databaze();
                }
                else
                {
                    dtb.setStudent(obor, name, surname, birthDate);
                }
                */
                
        }   
    }
}