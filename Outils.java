public class Outils {
    public static int nbBombeCreees = 0;
    public static int nbBombeDetruites = 0;
    public static int nbBaseCreees = 0;
    public static int nbBaseDetruites = 0;

        // une methode pour definir un evenement se passe ou non
        public static boolean avoirLieu(double seuil){
            return (Math.random()<seuil);
    
        }
    
        /**
         * 
         * @param ress la ressource specifique qui fait l'objet
         * @param plusOuMoins 0 si on va diminuer sa quantite, 1 pour l'augmenter
        */
        public static void ressourceRecord(Ressource ress, int plusOuMoins) {
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
        public static void ressourceResume() {
            System.out.println(String.format("Dans cette guerre, %d bombes et %d bases sont creees.\n %d bombes et %d bases sont detruites.\n",
             nbBombeCreees, nbBaseCreees, nbBombeDetruites, nbBaseDetruites));
        }
    
        // separateur de chaque affichage
        public static void afficherSeparateur(){
            for(int i = 0; i < 3; i++){
                System.out.println("##########");
            }
            System.out.println("\n");
        }
}
