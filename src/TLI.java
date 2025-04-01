import java.util.HashMap;
import java.util.Map;

public class TLI extends Student {

    public TLI(Integer id, Integer oborID, String name, String surname, Integer birthDate) {
        super(id, oborID, name, surname, birthDate);
    }

    @Override
    public String specialAbility()
    {
        String morseName = "";
        String morseSurname = "";
        char pismeno;
        char[] nameArray= getName().toCharArray();
        char[] surnameArray= getSurname().toCharArray();

        Map<Character, String> MorseCode = new HashMap<>();

        MorseCode.put('a', ".-");
        MorseCode.put('b', "-...");
        MorseCode.put('c', "-.-.");
        MorseCode.put('d', "-..");
        MorseCode.put('e', ".");
        MorseCode.put('f', "..-.");
        MorseCode.put('g', "--.");
        MorseCode.put('h', "....");
        MorseCode.put('i', "..");
        MorseCode.put('j', ".---");
        MorseCode.put('k', "-.-");
        MorseCode.put('l', ".-..");
        MorseCode.put('m', "--");
        MorseCode.put('n', "-.");
        MorseCode.put('o', "---");
        MorseCode.put('p', ".--.");
        MorseCode.put('q', "--.-");
        MorseCode.put('r', ".-.");
        MorseCode.put('s', "...");
        MorseCode.put('t', "-");
        MorseCode.put('u', "..-");
        MorseCode.put('v', "...-");
        MorseCode.put('w', ".--");
        MorseCode.put('x', "-..-");
        MorseCode.put('y', "-.--");
        MorseCode.put('z', "--..");

        for (int i = 0; i < nameArray.length; i++)
        {
            pismeno = nameArray[i];
            pismeno = Character.toLowerCase(pismeno);
            morseName += MorseCode.get(pismeno) + " ";
        }

        for (int i = 0; i < surnameArray.length; i++)
        {
            pismeno = surnameArray[i];
            pismeno = Character.toLowerCase(pismeno);
            morseSurname += MorseCode.get(pismeno) + " ";
        }

        return morseName + " " + morseSurname;
    }

    @Override
	public int compareTo(Object o) {
        if (this.getSurname().compareTo(((Student)o).getSurname())<0) {
            return -1;
        }
        if (this.getSurname().compareTo(((Student)o).getSurname())>0) {
            return 1;
        }
		return 0;
	}
}
