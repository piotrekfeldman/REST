package Enum;

public enum TshirtSize {
    Rozmiar_S("S"),
   Rozmiar_M ("M"),
   Rozmiar_L("L"),
   Rozmiar_XL("XL");



    private String rozmiar;

    TshirtSize(String rozmiar) {
        this.rozmiar = rozmiar;
    }
    public String getRozmiar() {
        return rozmiar;
    }

    public void setRozmiar(String rozmiar) {
        this.rozmiar = rozmiar;
    }

}
