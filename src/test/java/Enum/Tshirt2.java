package Enum;

public class Tshirt2 {


    private TshirtSize ts;
    private String man;

    public Tshirt2(TshirtSize ts, String man) {
        this.ts = ts;
        this.man = man;
    }

    public static void main (String [] arg)
    {
        Tshirt2 tt = new Tshirt2(TshirtSize.Rozmiar_L,"Coś");
        System.out.println(tt.ts);

    }
}
