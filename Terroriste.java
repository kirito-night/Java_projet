public class Terroriste extends Agent {
    protected static double taux_de_production = 0.3;
    protected static int capacite_de_tirer = 1;
    protected static int detruit;
    protected final String production_type = "bomb";
    protected  final String tirer_type = "base"

    public Terroriste(int x, int y) {
        super(x, y);

    }

    public Ressource produireRessource() {
        if (avoirLieu(taux_de_production)) {
            if (terrain.caseEstVide(x, y)) {
                Ressource r1 = new Ressource(production_type, 1);
                r1.setPosition(x, y);
                terrain.setCase(x, y, r1);
            }
        } else {
            return null;
        }
    }

    @Override
    public Ressource tirerRessource() {
        // TODO Auto-generated method stub
        Ressource ress = getCase();
        int quan = ress.quantite;
        if(quan > capacite_de_tirer){
            ress.setQuantite(quan - capacite_de_tirer);
            return ress;
        }
        else{
            terrain.videCase(x, y);
            return null;
        }
        
    }

    public void Action(){
        Ressource ress = getCase();
        if(ress.getType() == tirer_type){
            tirerRessource();
        }else if(ress.getType() == production_type || ress == null){
            produireRessource();
        }else{
            System.err.println("Error from Terrorist Action()");
        }
    }

    @Override
    public Agent seBattre() {
        // TODO Auto-generated method stub
        return null;
    }
    


        

    }
    

  
    



    
}
