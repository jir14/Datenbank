

public class IBE extends Student {

    public IBE(Integer id, Integer oborID, String name, String surname, Integer birthDate) {
        super(id, oborID, name, surname, birthDate);
    }

    @Override
    public String specialAbility()
    {
        int hash;
        int HashNumber = 0;
        String hashName = "";
        String hashSurname = "";
        int pismenoNmbr;

        char []pismeno= getName().toCharArray();
        char []pismenoSurname= getSurname().toCharArray();

        hash = 7 + pismeno.length + pismenoSurname.length;

        for (int i = 0; i < pismeno.length; i++) {
            pismenoNmbr = Character.getNumericValue(pismeno[i]);
            HashNumber += pismenoNmbr*hash;
            hashName = String.valueOf(HashNumber);
        }

        for (int i = 0; i < pismenoSurname.length; i++) {
            pismenoNmbr = Character.getNumericValue(pismenoSurname[i]);
            HashNumber += pismenoNmbr*hash;
            hashSurname = String.valueOf(HashNumber);
        }

        return hashName + " " + hashSurname;
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