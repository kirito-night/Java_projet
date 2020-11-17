import java.util.ArrayList;
public class Stimulation {
    private Terrain terrain;
    private ArrayList<Ressource> ressources;
    private ArrayList<Agent> agents;

    public Stimulation(int lig, int col, int m, int n) {
        this.terrain = new Terrain(lig, col);

        ressources = new ArrayList<Ressource>();
        for(int i = 0; i < m/2; i++){
            ressources.add(new Ressource("base", 1));
            ressources.add(new Ressource("bomb", 1));
        }
        if(m % 2 == 1){
            ressources.add(new Ressource("base", 1));
        }


        agents = new ArrayList<Agent>();
        for(int i = 0; i < n/2; i++){
            agents.add(new Police(Math.random()*));
            agents.add(new Ressource("bomb", 1));
        }
        if(n % 2 == 1){
            agents.add(new Ressource("base", 1));
        }
        this.agents = agents;
    }

    
}
