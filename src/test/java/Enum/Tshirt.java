package Enum;

public class Tshirt {



    public static void main(String[] arg) {

        for (TshirtSize ts : TshirtSize.values()) {

            System.out.println(ts);

        }

        System.out.println(TshirtSize.Rozmiar_M.getRozmiar());
        TshirtSize tt= TshirtSize.valueOf("Rozmiar_S");
        String rozmiar = tt.getRozmiar();

        System.out.println("to jest kurwa rozmiar " + rozmiar);


    }


}
