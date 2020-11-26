package Enum;

public enum Samochody {

    OPEL_CORSA(1998,3),
    FORD_FIESTA(2000,4),
    TOYOTA_AVENSIS(1994,2);

    private  int rok;
   private  int drzwi;

    Samochody(int rok, int drzwi) {
        this.rok = rok;
        this.drzwi = drzwi;
    }



    @Override
    public String toString() {
        return super.toString() +
                "rok=" + rok +
                ", drzwi=" + drzwi ;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public int getDrzwi() {
        return drzwi;
    }

    public void setDrzwi(int drzwi) {
        this.drzwi = drzwi;
    }
}
