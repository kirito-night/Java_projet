public class Police extends Agent {
    protected static double taux_de_production = 0.15;
    protected static int capacite_de_production = 1;
    protected static int capacite_de_tirer = 2;
    protected static final String production_type = "base";
    protected static final String tirer_type = "bomb";

    public Police(int x, int y) {
        super(x, y);
    }

    public void Action_Police() {
        Ressource ress = getCase();
        if (ress == null || ress.getType() == Police.production_type) {
            if (avoirLieu(taux_de_production)) {
                produireRessource();
            }
        } else {
            tirerRessource();
        }
    }

    @Override
    public static Ressource tirerRessource() {
        Ressource ress = getCase();
        int quantite = ress.getQuantite();
        if (quantite > capacite_de_tirer) {
            ress.setQuantite(quantite - capacite_de_tirer);
        } else {
            ress.initialisePosition();
            terrain.videCase(x, y);
        }
        morale++;
        return ress;
    }

    @Override
    public static Ressource produireRessource() {
        Ressource ress = getCase();
        if(ress == null){
            ress = new Ressource(production_type, capacite_de_production);
            ress.setPosition(x, y);
            terrain.setCase(x, y, ress);
        }else{
            ress.setQuantite(ress.getQuantite()+capacite_de_production);
        }
        return ress;
    }

    @Override
    public void seBattre() {
        System.out.println("Un combat a lieu ! La police a besoin de soutien !");
    }

   






}
