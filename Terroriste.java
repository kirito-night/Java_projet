public class Terroriste extends Agent {
    private static double taux_de_production = 0.3; // le pourcentage pour creer des ressources
    private static int capacite_de_production = 1; // le nombre de ressource a creer si possible
    private static int capacite_de_tirer = 1; // le nombre de ressource a destruire si y en a
    private static final String production_type = "bombe"; // le type de ressource que la classe peut produire
    private static final String tirer_type = "base"; // le type de ressource que la classe peut detruire

    public Terroriste(int x, int y) {
        super(x, y);
    }

    public Terroriste(Terroriste t1){
        super(t1.x, t1.y);
    }

    // les 5 methodes ci-dessous ne servent que d'afficher des informations
    @Override
    public void augmenterRessource() {
        System.out.println("A new bombe is set!\n");
    }
    
    @Override
    public void produireRessource() {
        System.out.println("A bombe is set in the zone!\n");
    }
    
    @Override
    public void tirerRessource() {
        System.out.println("A police's base is destroyed!\n");
    }

    @Override
    public void effacerRessource() {
        System.out.println("No police's base is around, zone cleared.\n");
    }

    @Override
    public void seBattre() {
        System.out.println("Terroriste : We've met the police somewhere! Call for support!\n");
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
