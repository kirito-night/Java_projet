public class Terroriste extends Agent {
    protected static double taux_de_production = 0.3;
    protected static int capacite_de_production = 1;
    protected static int capacite_de_tirer = 1;
    protected static final String production_type = "bombe";
    protected static final String tirer_type = "base";

    public Terroriste(int x, int y) {
        super(x, y);
    }

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
