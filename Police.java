public class Police extends Agent{
    protected static double taux_de_production = 0.15;
    protected static int capacite_de_tirer = 2;

    public Police(int x, int y) {
        super(x, y);
    }

    @Override
    public Ressource produireRessource() {
        if(!avoirLieu(taux_de_production)){
            return null;
        }
        Ressource ress = terrain.getCase(x, y);
        if(ress == null){
            
        }

    }


}
