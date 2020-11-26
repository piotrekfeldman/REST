package Enum;

public class KlasaWyliczeniowa {

    public static void main(String[] args) {


        for(Samochody s: Samochody.values()){
            System.out.println(s);
        }

        int rok=Samochody.FORD_FIESTA.getRok();
        System.out.println(Samochody.valueOf("FORD_FIESTA"));

    }
}
