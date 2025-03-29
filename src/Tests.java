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
			sc.nextLine();
			cislo = IntOnly(sc);
		}
		return cislo;
    }
}
