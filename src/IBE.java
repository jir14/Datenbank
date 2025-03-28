
import java.util.Random;

public class IBE extends Student {
    public IBE(String name, String surname, String birthDate) {
        super(name, surname, birthDate);
    }

    @Override
    public String specialAbility()
    {
        Random rand = new Random();
        int hash = rand.nextInt(11);
        int HashNumber;
        String hashName = "";
        String hashSurname = "";
        int pismenoNmbr;

        char []pismeno= getName().toCharArray();
        char []pismenoSurname= getSurname().toCharArray();


        for (int i = 0; i < pismeno.length; i++) {
            pismenoNmbr = Character.getNumericValue(pismeno[i]);
            HashNumber = pismenoNmbr*hash;
            hashName = String.valueOf(HashNumber);
        }

        for (int i = 0; i < pismenoSurname.length; i++) {
            pismenoNmbr = Character.getNumericValue(pismenoSurname[i]);
            HashNumber = pismenoNmbr*hash;
            hashSurname = String.valueOf(HashNumber);
        }

        return hashName + " " + hashSurname;
    }
}