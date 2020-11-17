import java.util.ArrayList;
public class Stimulation {
    private Terrain terrain;
    private ArrayList<Ressource> ressources;
    private ArrayList<Agent> agents;

    public Stimulation(int lig, int col, int n, int m) {
        this.terrain = new Terrain(lig, col);

        ressources = new ArrayList<Ressource>(n);
        for(int i = 0; i < n; i++){

        }

        this.ressources = ressources;
        this.agents = agents;
    }

    
}
