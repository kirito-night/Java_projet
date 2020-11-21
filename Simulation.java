import java.util.ArrayList;

public class Simulation {
    // Les composants de base pour une simulation
    private Terrain terrain;
    private ArrayList<Ressource> ressources;
    private ArrayList<Agent> agents;
    // Ci-dessous des nombres pour compter les ressources creees et detruites
    private static int nbBombeCreees = 0;
    private static int nbBombeDetruites = 0;
    private static int nbBaseCreees = 0;
    private static int nbBaseDetruites = 0;

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
        for(Ressource ressource : ressources){
            if(ressource.getType() == "bombe"){
                nbBombeCreees++;
            }else{
                nbBaseCreees++;
            }
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
        if(terrain.caseEstVide(x, y)){ // si la case est vide, ajouter la ressource
            terrain.setCase(x, y, ress);
        }
        else if(ter.getType() == ress.getType()){ // si la case a le meme type de ressource, augmenter la quantite
            ter.setQuantite(ter.getQuantite()+1); 
        }else{ // si le type de ressource est different de celle qui existe dans la case, diminuer la quantite de cette derniere
            ter.setQuantite(ter.getQuantite()-1);
            if (ter.getQuantite() == 0) { // si la quantite reduit a 0, la ressource est supprimee
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
                if (avoirLieu(agent.getTaux_de_production())) {
                    agent.produireRessource();
                    ress = new Ressource(agent.getProduction_type(), agent.getCapacite_de_production());
                    ress.setPosition(x, y);
                    terrain.setCase(x, y, ress);
                    System.out.println(ress.toString());
                    ressourceRecord(ress, 1);
                }
            } else {// sinon, voir le type de ressource
                ress = terrain.getCase(x, y);
                if (ress.getType() == agent.getProduction_type()) { // si la case contient le meme type de ressource que l'agent peut creer, sa quantite incremente
                    agent.augmenterRessource();
                    System.out.println(ress.toString());
                    ress.setQuantite(ress.getQuantite() + agent.getCapacite_de_production());
                    for(int i = 0; i < agent.getCapacite_de_production(); i++){
                        ressourceRecord(ress, 1);
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
                            ressourceRecord(ress, 0);
                        }
                    } else { // sinon, on supprimer la ressource
                        agent.effacerRessource();
                        ress.setQuantite(0);
                        ress = terrain.videCase(x, y);
                        System.out.println(ress.toString());
                        for (int i = 0; i < quantite; i++) {
                            ressourceRecord(ress, 0);
                        }
                        ress.initialisePosition();
                        ressources.remove(ress);
                        
                    }
                }
            }
            // il y a une possibilite que les deux camps se battent, mais cela ne modifie pas aucune coordonnee
            if(avoirLieu(terrain.nbLigne*terrain.nbColonnes/(agents.size()/2.)/100)){
                agent.seBattre();
            }
            terrain.affiche();
        }
    }
    public void moveAgents(){ // deplacer tous les agents
        for(Agent agent : agents){
            agent.seDeplacer((int)Math.random()*terrain.nbLigne, (int)Math.random()*terrain.nbColonnes);
        } 
    }

    // une methode pour definir un evenement se passe ou non
    public boolean avoirLieu(double seuil){
        return (Math.random()<seuil);

    }

    /**
     * 
     * @param ress la ressource specifique qui fait l'objet
     * @param plusOuMoins 0 si on va diminuer sa quantite, 1 pour l'augmenter
    */
    public void ressourceRecord(Ressource ress, int plusOuMoins) {
        if(ress.getType() == "bombe"){
            if(plusOuMoins == 1){
                nbBombeCreees++;
            }else{
                nbBombeDetruites++;
            }
        }else{
            if(plusOuMoins == 1){
                nbBaseCreees++;
            }else{
                nbBaseDetruites++;
            }
        }
    }

    // faire une resume pour les ressources deja creees et detruites
    public void ressourceResume() {
        System.out.println(String.format("|Dans cette guerre, %d bombes et %d bases sont creees.\n %d bombes et %d bases sont detruites.|",
         nbBombeCreees, nbBaseCreees, nbBombeDetruites, nbBaseDetruites));
    }

    // separateur de chaque affichage
    public void afficherSeparateur(){
        for(int i = 0; i < 3; i++){
            System.out.println("##########");
        }
        System.out.println("\n");
    }
    
}
