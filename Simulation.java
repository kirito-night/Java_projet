import java.util.ArrayList;


public class Simulation {
    private Terrain terrain;
    private ArrayList<Ressource> ressources;
    private ArrayList<Agent> agents;

    public Simulation(int lig, int col, int m, int n) {
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
            agents.add(new Police((int) (Math.random())*(terrain.nbLigne), (int) (Math.random())*(terrain.nbLigne)));
            agents.add(new Terroriste((int) (Math.random())*(terrain.nbLigne), (int) (Math.random())*(terrain.nbLigne)));
        }
        if(n % 2 == 1){
            agents.add(new Terroriste((int) (Math.random())*(terrain.nbLigne), (int) (Math.random())*(terrain.nbLigne)));
        }
    }


    public void agentsAction() {

        // int [][] agentIci = new int[terrain.nbLigne][terrain.nbColonnes];

        for(Agent agent : agents){
            
            int x = agent.getX();
            int y = agent.getY();
            // agentIci[x][y] = agentToInt(agent);
            Ressource ress;

            if (terrain.caseEstVide(x, y)) {
                if (avoirLieu(agent.getTaux_de_production())) {
                    agent.produireRessource();
                    ress = new Ressource(agent.getProduction_type(), agent.getCapacite_de_production());
                    ress.setPosition(x, y);
                    terrain.setCase(x, y, ress);
                }
            } else {
                ress= terrain.getCase(x, y);
                if (ress.getType() == agent.getProduction_type()) {
                    agent.augmenterRessource();
                    ress.setQuantite(ress.getQuantite() + agent.getCapacite_de_production());
                } else {
                    int quantite = ress.getQuantite();
                    if (quantite > agent.getCapacite_de_tirer()) {
                        agent.tirerRessource();
                        ress.setQuantite(quantite - agent.getCapacite_de_tirer());
                    } else {
                        agent.effacerRessource();
                        ress.initialisePosition();
                        terrain.videCase(x, y);
                    }
                    agent.incrementerMorale();
                }
            }
            // if(agentIci[x][y] == )
            if(avoirLieu(terrain.nbLigne*terrain.nbColonnes/(agents.size()/2.))){
                agent.seBattre();
            }
        }
    }

    public int agentToInt(Agent agent){
        if(agent.getProduction_type() == "base"){
            return 0;
        }else{
            return 1;
        }
    }

    public boolean avoirLieu(double seuil){
        return (Math.random()<seuil);

    }
}
