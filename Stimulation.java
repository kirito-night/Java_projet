import java.util.ArrayList;

import jdk.internal.agent.resources.agent;
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
            agents.add(new Police((int) (Math.random())*(terrain.nbLigne), (int) (Math.random())*(terrain.nbLigne)));
            agents.add(new Terroriste((int) (Math.random())*(terrain.nbLigne), (int) (Math.random())*(terrain.nbLigne)));
        }
        if(n % 2 == 1){
            agents.add(new Terroriste((int) (Math.random())*(terrain.nbLigne), (int) (Math.random())*(terrain.nbLigne)));
        }
    }


    /*public void agentAction() {
        for(Agent agent : agents){
            Ressource ress = terrain.getCase(agent.getX(), agent.getY());
            if (ress == null || ress.getType() == agent.getProduction_type()) {
                if (avoirLieu(agent.getTaux_de_production())) {
                    agent.produireRessource();
                }
            } else {
                agent.tirerRessource();
            }
        }
    }*/
    public void Action_Police() {
        Ressource ress = getCase();
        if (ress == null || ress.getType() == Police.production_type) {
            if (avoirLieu(taux_de_production)) {
                Police.produireRessource();
            }
        } else {
            Police.tirerRessource();
        }
    }

    public void Action_Terroriste() {
        Ressource ress = getCase();
        if (ress == null || ress.getType() == Terroriste.production_type) {
            if (avoirLieu(taux_de_production)) {
                Terroriste.produireRessource();
            }
        } else {
            Terroriste.tirerRessource();
        }
    }

    public boolean avoirLieu(double seuil){
        return (Math.random()<seuil);

    }
}
