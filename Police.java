public class Police extends Agent {

    protected static double taux_de_production = 0.15; // le pourcentage pour creer des ressources
    protected static int capacite_de_production = 1; // le nombre de ressource a creer si possible
    protected static int capacite_de_tirer = 2; // le nombre de ressource a destruire si y en a
    protected static final String production_type = "base"; // le type de ressource que la classe peut produire
    protected static final String tirer_type = "bombe"; // le type de ressource que la classe peut detruire

    public Police(int x, int y) {
        super(x, y);
    }

    // les 5 methodes ci-dessous ne servent que d'afficher des informations
    @Override
    public void augmenterRessource() {
        System.out.println("Une nouvelle base est construite!\n");
    }
    
    @Override
    public void produireRessource() {
        System.out.println("Une base de police est construite!\n");
    }
    
    @Override
    public void tirerRessource() {
        System.out.println("Nous avons desactivés des bombees.\n");
    }

    @Override
    public void effacerRessource() {
        System.out.println("Les bombees sont désactivées, zone sérurisé.\n");
    }

    @Override
    public void seBattre() {
        System.out.println("Police : Un combat a lieu quelque part! Nous avons besoin de soutien!\n");
    }

    // les methodes ci-dessous ne servent que d'obtenir des valeurs
    @Override
    public int getCapacite_de_production() {
        return capacite_de_production;
    }

    @Override
    public int getCapacite_de_tirer() {
        return capacite_de_tirer;
    }

    @Override
    public String getProduction_type() {
        return production_type;
    }

    @Override
    public double getTaux_de_production() {
        return taux_de_production;
    }

    @Override
    public String getTirer_type() {
        return tirer_type;
    }
}
