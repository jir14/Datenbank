import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Files extends Databaze {
    public boolean ulozStudenta(String jmenoSouboru, Integer studID)
	{
		try {
			FileWriter fw = new FileWriter(jmenoSouboru);
			BufferedWriter out = new BufferedWriter(fw);
			Student stud = StudentList.get(studID);	
            String marks = "";
            for (Integer mark : getStudent(studID).getMarks()) {
                marks+=" "+mark;
            }
            out.append(stud.getID() +" "+ stud.getOborID() +" "+ stud.getName() +" "+ stud.getSurname() +" "+ stud.getBirthDate() + marks);
			out.newLine();
			out.close();
			fw.close();
            setID(studID);
            return true;
		}
		catch (IOException e) {
			System.out.println("Soubor nelze vytvorit");
			return false;
		}
	}

    public boolean nactiStudenta(String jmenoSouboru, Integer studID) {
		FileReader fr=null;
		BufferedReader in=null;
		try {
			fr = new FileReader(jmenoSouboru);
			in = new BufferedReader(fr);
			String radek;
			String[] castiTextu;
			
			do {			
				radek = in.readLine();
				castiTextu = radek.split(" ");
				if (castiTextu.length>=5 && Integer.parseInt(castiTextu[0])==studID)
				{
					setStudent(Integer.parseInt(castiTextu[1]), castiTextu[2], castiTextu[3], Integer.parseInt(castiTextu[4]), studID);
                    for (int i=5;i<castiTextu.length;i++) {
                        setMark(Integer.parseInt(castiTextu[0]), Integer.parseInt(castiTextu[i]));
                    }
                    return true;
				} 
			} while (in.readLine()!=null);
            return false;
		}
		catch (IOException e) {
			System.out.println("Soubor  nelze otevrit");
			return false;
		} 
		catch (NumberFormatException e) {
			System.out.println("Chyba integrity dat v souboru");
			return false;
		}
		finally
		{
			try
			{	if (in!=null)
				{
					in.close();
					fr.close();
				}
			}
			catch (IOException e) {
				System.out.println("Soubor nelze zavrit");
				return false;
			} 
		}
	}
}
