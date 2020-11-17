public class Police extends Agent {
    protected static double taux_de_production = 0.15;
    protected static int capacite_de_tirer = 2;
    protected final String production_type = "Base";
    protected final String tirer_type = "Bombe";

    public Police(int x, int y) {
        super(x, y);
    }

    public void Action(){
        Ressource ress = getCase();
        if(ress.getType() == tirer_type){
            tirerRessource();
        }else if(ress.getType() == production_type || ress == null){
            produireRessource();
        }else{
            System.err.println("Error from police Action()");
        }
    }

    @Override
    public Ressource tirerRessource() {
        Ressource ress = getCase();
        int quantite = ress.getQuantite();
        if(quantite >= 2){
            ress.setQuantite(quantite-2);
            return ress;
        }else{
            terrain.videCase(x, y);
            return null;
        }
    }

    @Override
    public Ressource produireRessource() {
        if (!avoirLieu(taux_de_production)) {
            return null;
        }
        Ressource ress = new Ressource(production_type, 1);
        ress.
    }

    @Override
    public Agent seBattre() {
        // TODO Auto-generated method stub
        return null;
    }




}
