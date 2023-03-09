class Ord {

    private String ord;
    private String gissning;

    //Constructor
    public Ord (String ord) {
        this.ord = ord;
        this.gissning = "";
        for (int i = 0; i < ord.length(); i++)
            gissning += "-";
    }

    public String getOrd() {
        return ord;
    }
    public String getGissning() {
        return gissning;
    }

    public String visaBokstav(char bokstav) {
        String nyGissning = "";
        for (int i =0; i < ord.length(); i++) {
            if (ord.charAt(i) == bokstav) {
                nyGissning += bokstav;
            } else {
                nyGissning += gissning.charAt(i);
            }
        }
        gissning = nyGissning;
        return gissning;
    }

    public boolean harVunnit() {
        return gissning.equals(ord);
    }
}
