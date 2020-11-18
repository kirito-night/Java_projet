public class Police extends Agent {

    protected static double taux_de_production = 0.15;
    protected static int capacite_de_production = 1;
    protected static int capacite_de_tirer = 2;
    protected static final String production_type = "base";
    protected static final String tirer_type = "bomb";

    public Police(int x, int y) {
        super(x, y);
    }

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
        System.out.println("Nous avons desactivés des bombes.\n");
    }

    @Override
    public void effacerRessource() {
        System.out.println("Les bombes sont désactivées, zone sérurisé.\n");
    }

    @Override
    public void seBattre() {
        System.out.println("Un combat a lieu ! La police a besoin de soutien!\n");
    }

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
