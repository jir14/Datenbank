import java.util.Scanner;

public class Tests {

    public static int IntOnly(Scanner sc) {
        int cislo = 0;
		try
		{
			cislo = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cele cislo ");
			System.out.print("volba> ");
			sc.nextLine();
			cislo = IntOnly(sc);
		}
		return cislo;
    }

	public static int CisloOboru(Scanner sc) {
		int oborID=0;
		do {
			System.out.println("Zadejte kod oboru [TLI - 1; IBE - 2]: ");
			System.out.print("volba> ");
			oborID = Tests.IntOnly(sc);
		} while (oborID<1 || oborID>2);
		return oborID;
	}

	public static Integer ValidStudID(Scanner sc) {
		boolean repeat=true;
		int ID;
        do {
        	System.out.println("Zadejte ID studenta: ");
			System.out.print("volba> ");
            ID = Tests.IntOnly(sc);
            if (Databaze.getStudent(ID)==null) {
            	System.out.println("Student se zadanym ID neexistuje");
            } else {
            	repeat=false;
            }
        } while (repeat);
		return ID;
	}

	public static Integer ValidStudID(Integer ID) {
        if (Databaze.getStudent(ID)==null) {
			return 0; 
		} else {
			return ID;
		}
	}

	public static Integer markRange(Scanner sc) {
		int mark;
		do {
			System.out.println("Zadejte znamku (1-5)");
			System.out.print("volba> ");
			mark = Tests.IntOnly(sc);
		} while (mark<1 || mark>5);
		return mark;
	}

}
