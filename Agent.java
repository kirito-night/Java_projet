
public abstract class Agent {
    
    protected static int compte = 0;
    protected final int ident;
    protected double taux_de_production;
    protected int x;
    protected int y;
    protected int morale;
    protected Terrain terrain;

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

    public boolean avoirLieu(double seuil){
        return (Math.random()<seuil);
    }

    public abstract Ressource tirerRessource();
    public abstract Ressource produireRessource();
    public abstract Agent seBattre();
}
