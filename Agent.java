
public abstract class Agent {
    
    protected static int compte = 0;
    protected final int ident;
    protected int x;
    protected int y;
    protected int morale;
    protected double taux_de_production;
    protected int capacite_de_production;
    protected int capacite_de_tirer;
    protected String production_type;
    protected String tirer_type;

    public Agent(int x, int y) {
        compte++;
        ident = compte;
        this.x = x;
        this.y = y;
        this.morale = 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distance(int x, int y){
        double dx = this.x - x;
        double dy = this.y - y;
        return (Math.sqrt(dx*dx + dy*dy));
    }

    public void seDeplacer(int newx, int newy){
        this.x = newx;
        this.y = newy;
    }

    public abstract Ressource tirerRessource();
    public abstract Ressource produireRessource();
    // public abstract Agent seBattre();
    public abstract void seBattre();

    public  double getTaux_de_production() {
        return taux_de_production;
    }

    public int getCapacite_de_production() {
        return capacite_de_production;
    }

    public void setCapacite_de_production(int capacite_de_production) {
        Police.capacite_de_production = capacite_de_production;
    }

    public int getCapacite_de_tirer() {
        return capacite_de_tirer;
    }

    public String getProduction_type() {
        return production_type;
    }

    public String getTirer_type() {
        return tirer_type;
    }
}
