
public class Terrain {
	public final int nbColonnes;
	public static final int NBCOLONNESMAX = 20;
	public final  int nbLigne;
	public static final int NBLIGNEMAX= 20;
	public Ressource[][] tab;

	
	public Terrain(int nbColonnes, int nbLigne) {
		super();
		this.nbColonnes = nbColonnes;
		this.nbLigne = nbLigne;
		Ressource[][] tab = new Ressource[nbLigne][nbColonnes];
		if(nbColonnes<NBCOLONNESMAX || nbLigne <NBLIGNEMAX || nbColonnes> 1 || nbLigne >1 ) {
			for(int i = 0 ; i < 1;i++) {
				for(int j = 0 ; j < 1 ; j++) {
					tab[i][j]= null;
				}
			}
		}
		for(int i = 0 ; i < nbLigne;i++) {
			for(int j = 0 ; j < nbColonnes ; j++) {
				tab[i][j]= null;
			}
		}
	}
	
	public Terrain() {
		this(NBCOLONNESMAX,NBLIGNEMAX);
	}
	
	public void affiche() {
		for(int i = 0 ; i < nbLigne; i++) {
			for(int j = 0; j<nbColonnes;j++) {
			System.out.println(":-----");
			System.out.println(String.format("| %5s |",tab[i][j]));
			}
		}
		for (int i =0 ; i< nbColonnes;i++) {
			System.out.println(":-----");
		}
	}
	
	
	public boolean caseEstVide(int lig,int col){
			return tab[lig][col] == null;
				
	}
	
	public Ressource getCase(int lig, int col){
		return tab[lig][col];
	}

	public boolean setCase(int lig, int col, Ressource ress){
		tab[lig][col] = ress;
		return caseEstVide(lig,col);

	}
	public Resssource videCase (int lig, int col){
		if(caseEstVide(lig,col)){
			return null;
		}
		else{
			return tab[lig][col] = null;
	
		}
	}


	
	
	public boolean sontValides(int lig, int col) {
		return col<NBCOLONNESMAX || lig <NBLIGNEMAX || col> 1 || lig >1;
	}

    @Override
    public String toString() {
        return "Terrain [nbColonnes=" + nbColonnes + ", nbLigne=" + nbLigne + "]";
    }

	

	
	





}

