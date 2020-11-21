public class Ressource{
    private static int compte = 0;
    public final int ident;
    public final String type;
    private int x;
    private int y;
    private int quantite;

    public Ressource(String type, int quantite) {
        compte++;
        this.ident = compte;
        this.type = type;
        this.quantite = quantite;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    public void setPosition(int lig, int col){
        this.x = lig;
        this.y = col;
    }

    public void initialisePosition(){
        this.x = -1;
        this.y = -1;
    }

    @Override
    public String toString() {
        return type + " [id=" + ident + ", quantite=" + quantite + 
            "] en position (" + x + ", " + y + ") \n";
    }

    /*
     * @return  le type de Ressource sous format de string
    */
    public String getType() {
        return type;
    }
    
}