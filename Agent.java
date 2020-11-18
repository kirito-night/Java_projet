
public abstract class Agent {
    
    protected static int compte = 0;
    protected final int ident;
    protected int x;
    protected int y;
    protected int morale;

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

    public void incrementerMorale(){
        morale++;
    }


    public abstract void augmenterRessource();
    
    public abstract void produireRessource();

    public abstract void tirerRessource();
    
    public abstract void effacerRessource();

    public abstract void seBattre();

    public abstract double getTaux_de_production();

    public abstract int getCapacite_de_production();

    public abstract int getCapacite_de_tirer();

    public abstract String getProduction_type();

    public abstract String getTirer_type();
}
