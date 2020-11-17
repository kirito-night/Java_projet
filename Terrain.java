
public class Terrain {
	private final int nbColonnes;
	private static final int NBCOLONNESMAX;
	private final  int nbLigne;
	private static final int NBLIGNEMAX;
	protected Ressource[][] tab = new Ressource[nbLigne][nbColonnes];

	
	public Terrain(int nbColonnes, int nbLigne) {
		super();
		this.nbColonnes = nbColonnes;
		this.nbLigne = nbLigne;
		if(nbColonnes<NBCOLONNESMAX || nbLigne <NBLIGNEMAX || nbColonnes> 1 || nbLigne >1 ) {
			this.nbLigne = 1;
			this.nbColonnes =1;
		}
		for(int i = 0 ; i < nbLigne;i++) {
			for(int j = 0 ; j < nbColonnes ; j++) {
				tab[i][j]= " ";
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
			System.out.println(String.format("| %s |",tab[i][j]));
			}
		}
		for (int i =0 ; i< nbColonnes;i++) {
			System.out.println(":-----");
		}
	}
	
	
	public boolean caseEstVide)(int lig,int col){
			return tab[lig][col] == " ";
				
	}
	
	public Ressource getCase(int lig, int col){
		return tab[lig][col];
	}

	public boolean setCase(int lig, int col, Ressource ress){
		tab[lig][col] = ress;
		return caseEstVide(lig,col);

	}
	public Resssource videCase (ing lig, int col){
		if(caseEstVide(lig,col)){
			return null;
		}
		else{
			tab[lig][col] = " ";
			return tab[lig][col];
		}
	}


	
	
	public boolean sontValides(int lig, int col) {
		return nbColonnes<NBCOLONNESMAX || nbLigne <NBLIGNEMAX || nbColonnes> 1 || nbLigne >1;
	}

	

	
	





}

