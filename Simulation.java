import java.util.ArrayList;


public class Simulation {
    private Terrain terrain;
    private ArrayList<Ressource> ressources;
    private ArrayList<Agent> agents;

    public Simulation(int lig, int col, int m, int n) {
        this.terrain = new Terrain(lig, col);

        ressources = new ArrayList<Ressource>();
        for(int i = 0; i < m/2; i++){
            Ressource base = new Ressource("base", 1);
            base.setPosition((int) (Math.random()*lig), (int) (Math.random()*col));
            ressources.add(base);
            registerRessource(base);
            Ressource bombe = new Ressource("bombe", 1);
            bombe.setPosition((int) (Math.random()*lig), (int) (Math.random()*col));
            ressources.add(bombe);
            registerRessource(bombe);
        }
        if(m % 2 == 1){
            ressources.add(new Ressource("base", 1));
        }

        agents = new ArrayList<Agent>();
        for(int i = 0; i < n/2; i++){
            agents.add(new Police((int) (Math.random()*terrain.nbLigne), (int) (Math.random()*terrain.nbLigne)));
            agents.add(new Terroriste((int) (Math.random()*terrain.nbLigne), (int) (Math.random()*terrain.nbLigne)));
        }
        if(n % 2 == 1){
            agents.add(new Terroriste((int) (Math.random()*terrain.nbLigne), (int) (Math.random()*terrain.nbLigne)));
        }
    }

    public void registerRessource(Ressource ress){
        int x = ress.getX();
        int y = ress.getY();
        Ressource ter = terrain.tab[x][y];
        if(terrain.caseEstVide(x, y)){
            terrain.setCase(x, y, ress);
        }
        else if(ter.getType() == ress.getType()){
            ter.setQuantite(ter.getQuantite()+1);
        }else{
            ter.setQuantite(ter.getQuantite()-1);
            if (ter.getQuantite() == 0) {
                terrain.videCase(x, y);
                ressources.remove(ress);
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
                    System.out.println(ress.toString());
                }
            } else {
                ress = terrain.getCase(x, y);
                if (ress.getType() == agent.getProduction_type()) {
                    agent.augmenterRessource();
                    System.out.println(ress.toString());
                    ress.setQuantite(ress.getQuantite() + agent.getCapacite_de_production());
                } else {
                    int quantite = ress.getQuantite();
                    if (quantite > agent.getCapacite_de_tirer()) {
                        agent.tirerRessource();
                        System.out.println(ress.toString());
                        ress.setQuantite(quantite - agent.getCapacite_de_tirer());
                    } else {
                        agent.effacerRessource();
                        System.out.println(ress.toString());
                        terrain.videCase(x, y);
                        ress.initialisePosition();
                        ressources.remove(ress);
                        
                    }
                    agent.incrementerMorale();
                }
            }
            terrain.affiche();
            // if(agentIci[x][y] == )
            if(avoirLieu(terrain.nbLigne*terrain.nbColonnes/(agents.size()/2.)/100)){
                agent.seBattre();
            }
        }
    }
    public void moveAgents(){
        for(Agent agent : agents){
            agent.seDeplacer((int)Math.random()*terrain.nbLigne, (int)Math.random()*terrain.nbColonnes);
        } 
    }

    // public int agentToInt(Agent agent){
    //     if(agent.getProduction_type() == "base"){
    //         return 0;
    //     }else{
    //         return 1;
    //     }
    // }

    public boolean avoirLieu(double seuil){
        return (Math.random()<seuil);

    }
}
