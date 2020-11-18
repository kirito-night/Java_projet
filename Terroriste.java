public class Terroriste extends Agent {
    protected static double taux_de_production = 0.3;
    protected static int capacite_de_production = 1;
    protected static int capacite_de_tirer = 1;
    protected static int detruit;
    protected static final String production_type = "bomb";
    protected static final String tirer_type = "base";

    public Terroriste(int x, int y) {
        super(x, y);

    }

    // public static Ressource produireRessource() {
    //     Ressource ress = getCase();
    //     if (terrain.caseEstVide(x, y)) {
    //             ress = new Ressource(production_type, capacite_de_production);
    //             ress.setPosition(x, y);
    //             terrain.setCase(x, y, r1);
            
    //     }else if(terrain.tab[x][y].getType() == production_type){
    //             /*terrain.tab[x][y].setQuantite(terrain.tab[x][y].quantite +1);*/
    //             ress.setQuantite(ress.getQuantite()+capacite_de_production);
    //         }
    //         return ress;
    // }

    // @Override
    // public static Ressource tirerRessource() {
    //     if(!terrain.caseEstVide(x, y)){
    //         Ressource ress = getCase();
    //         int quan = ress.quantite;

    //         if(quan > capacite_de_tirer){
    //             ress.setQuantite(quan - capacite_de_tirer);
                
    //         }
    //         return ress;
    //     }
    //     else{
    //         terrain.videCase(x, y);
    //         return null;
    //         }
    
    //     }


    // public void Action(){
    //     Ressource ress = getCase();
    //     if(ress.getType() == tirer_type){
    //         tirerRessource();
    //     }else if(ress.getType() == production_type || ress == null){
    //         produireRessource();
    //     }else{
    //         System.err.println("Error from Terrorist Action()");
    //     }
    // }

    @Override
    public void augmenterRessource() {
        System.out.println("A new bomb is set!");
    }
    
    @Override
    public void produireRessource() {
        System.out.println("A bomb is set in the zone!");
    }
    
    @Override
    public void tirerRessource() {
        System.out.println("A police's base is destroyed!");
    }

    @Override
    public void effacerRessource() {
        System.out.println("No police's base is around, zone cleared.");
    }

    @Override
    public void seBattre() {
        System.out.println("We've met the police! Call for support!");
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
