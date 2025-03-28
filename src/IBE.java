
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
        int pismenoNmbr;

        char []pismeno= getName().toCharArray();


        for (int i = 0; i < pismeno.length; i++) {
            pismenoNmbr = Character.getNumericValue(pismeno[i]);
            HashNumber = pismenoNmbr*hash;
            hashName = String.valueOf(HashNumber);
        }

        return hashName;
    }
}