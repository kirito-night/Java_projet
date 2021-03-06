import java.util.ArrayList;

public class Simulation {
    // Les composants de base pour une simulation
    private Terrain terrain;
    private ArrayList<Ressource> ressources;
    private ArrayList<Agent> agents;
    // Ci-dessous des nombres pour compter les ressources creees et detruites

    public Simulation(int lig, int col, int m, int n) {
        this.terrain = new Terrain(lig, col);

        ressources = new ArrayList<Ressource>(); // creation des ressource
        for(int i = 0; i < m/2; i++){
            Ressource base = new Ressource("base", 1); // creation d'une ressource
            base.setPosition((int) (Math.random()*lig), (int) (Math.random()*col)); // definition de saposition
            ressources.add(base); // ajout dans la liste
            registerRessource(base); // enregistrement dans le terrain
            Ressource bombe = new Ressource("bombe", 1);
            bombe.setPosition((int) (Math.random()*lig), (int) (Math.random()*col));
            ressources.add(bombe);
            registerRessource(bombe);
        }
        if(m % 2 == 1){ // pour assurer que le nombre des ressources est bon
            ressources.add(new Ressource("base", 1));
        }

        // compter les ressources et enrigistrer leur nombre cree
        for(Ressource ress : ressources){
                Outils.ressourceRecord(ress, 1);
        }

        // creation des agents
        agents = new ArrayList<Agent>();
        for(int i = 0; i < n/2; i++){
            agents.add(new Police((int) (Math.random()*terrain.nbLigne), (int) (Math.random()*terrain.nbLigne)));
            agents.add(new Terroriste((int) (Math.random()*terrain.nbLigne), (int) (Math.random()*terrain.nbLigne)));
        }
        if(n % 2 == 1){
            agents.add(new Terroriste((int) (Math.random()*terrain.nbLigne), (int) (Math.random()*terrain.nbLigne)));
        }
    }

    // enregistrer ou supprimer les ressources sur le terrain et dans la liste selon leur quantite
    public void registerRessource(Ressource ress){
        int x = ress.getX();
        int y = ress.getY();
        Ressource ter = terrain.tab[x][y];
        // si la case est vide, ajouter la ressource
        if(terrain.caseEstVide(x, y)){ 
            terrain.setCase(x, y, ress);
        }
        // si la case a le meme type de ressource, augmenter la quantite
        else if(ter.getType() == ress.getType()){ 
            ter.setQuantite(ter.getQuantite()+1); 
            // si le type de ressource est different de celle qui existe dans la case, diminuer la quantite de cette derniere
        }else{ 
            ter.setQuantite(ter.getQuantite()-1);
            // si la quantite reduit a 0, la ressource est supprimee
            if (ter.getQuantite() == 0) { 
                terrain.videCase(x, y);
                ressources.remove(ress);
            }
            
        }
    }



    public void agentsAction() {

        for(Agent agent : agents){ // une cercle pour tous les agents existants
            int x = agent.getX();
            int y = agent.getY();
            Ressource ress;

            // si la case est vide, il y a une possibilite que l'agent depose sa ressource correspondante
            if (terrain.caseEstVide(x, y)) {
                if (Outils.avoirLieu(agent.getTaux_de_production())) {
                    agent.produireRessource();
                    ress = new Ressource(agent.getProduction_type(), agent.getCapacite_de_production());
                    ress.setPosition(x, y);
                    terrain.setCase(x, y, ress);
                    System.out.println(ress.toString());
                    Outils.ressourceRecord(ress, 1);
                    terrain.affiche();
                }
            } else {// sinon, voir le type de ressource
                ress = terrain.getCase(x, y);
                if (ress.getType() == agent.getProduction_type()) { // si la case contient le meme type de ressource que l'agent peut creer, sa quantite incremente
                    agent.augmenterRessource();
                    System.out.println(ress.toString());
                    ress.setQuantite(ress.getQuantite() + agent.getCapacite_de_production());
                    for(int i = 0; i < agent.getCapacite_de_production(); i++){
                        Outils.ressourceRecord(ress, 1);
                    }
                } else { // sinon, on l'enleve
                    int quantite = ress.getQuantite();
                    if (quantite > agent.getCapacite_de_tirer()) { 
                        // si la quantite de ressource est superieure au nombre qu'un agent peut enlever
                        // on faire diminuer ce nombre
                        agent.tirerRessource();
                        System.out.println(ress.toString());
                        ress.setQuantite(quantite - agent.getCapacite_de_tirer());
                        for(int i = 0; i < agent.getCapacite_de_tirer(); i++){
                            Outils.ressourceRecord(ress, 0);
                        }
                    } else { // sinon, on supprimer la ressource
                        agent.effacerRessource();
                        ress.setQuantite(0);
                        ress = terrain.videCase(x, y);
                        System.out.println(ress.toString());
                        for (int i = 0; i < quantite; i++) {
                            Outils.ressourceRecord(ress, 0);
                        }
                        ress.initialisePosition();
                        ressources.remove(ress);
                        terrain.affiche();
                    }
                }
            }
            // il y a une possibilite que les deux camps se battent, mais cela ne modifie pas aucune coordonnee
            if(Outils.avoirLieu(terrain.nbLigne*terrain.nbColonnes/(agents.size()/2.)/100)){
                agent.seBattre();
            }
        }
    }
    public void moveAgents(){ // deplacer tous les agents
        for(Agent agent : agents){
            agent.seDeplacer((int)Math.random()*terrain.nbLigne, (int)Math.random()*terrain.nbColonnes);
        } 
    }


    
}
