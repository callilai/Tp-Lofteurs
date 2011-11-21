package com.objet.lofteurs;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Charline
 *
 */
public class Loft implements ObjetDessinable{
	

	public Nourriture n;//claire
	public int tempsReproduction;
	
	public int nbCasesHauteur; //public int hauteur;
	public int nbCasesLargeur;//public int largeur;
	public int energiemin;
	public int energiemax;
	public int energiereproduction;
	public int energiepas;
	public int vieloft; 
	public int quantite;
	public int demographie;
	public int demographieinit;
	public ArrayList<Neuneu> Cimetiere; 
	public ArrayList<Erratique> Neuneus;  
	public ZoneGraphique zone;
	public int [][] plateau=new int[nbCasesHauteur][nbCasesLargeur]; //nb Neuneus dans chaque case
	public Nourriture [][] plateau_nourriture=new Nourriture [nbCasesHauteur][nbCasesLargeur];  // contient la nourriture dans les cases
	
	/**
	 * @param h
	 * @param l
	 * @param emin
	 * @param emax
	 * @param ereprod
	 * @param pas
	 * @param v
	 * @param q
	 * @param demo
	 */
	public Loft (int nombreCasesX,int nombreCasesY,ZoneGraphique zone) {
		
		this.nbCasesHauteur=nombreCasesY;
		this.nbCasesLargeur=nombreCasesX;
		this.tempsReproduction=0;
		this.energiemin=0;
		this.energiemax=10;
		this.energiereproduction=5;
		this.energiepas=3;
		this.vieloft=10;
		this.quantite=(int)(nombreCasesX*nombreCasesY)/50; //1/4 des cases possèdent de la nourriture
		//this.demographie= //1/8 des cases possèdent des neuneus
		this.demographie=0;
		this.demographieinit=(int)(nombreCasesX*nombreCasesY)/50;
		this.zone=zone;
		this.plateau=new int [this.nbCasesLargeur][this.nbCasesHauteur];
		this.plateau_nourriture=new Nourriture [this.nbCasesLargeur][this.nbCasesHauteur];
				
		this.Neuneus=new ArrayList<Erratique>();
		this.Cimetiere=new ArrayList<Neuneu>();
		
	}
		
	
	 
	  public void initialiser(){ 
		  
		  this.initialiser_erratique(demographieinit);
		  this.generernourriture(quantite);


		  /*for (int k=0;k<this.demographieinit;k++){ 
				int abs = (int)(Math.random()*(this.nbCasesLargeur-1)+1);
				int ord= (int)(Math.random() *(this.nbCasesHauteur-1)+1);
				  this.adderratique(abs,ord);*/
				  
				
		//}
			  
	  }

	
	
	  
	  public void ajouterNeuneu(int a, int o, String type){
		 
		  if (type=="Erratique") this.adderratique(a,o);
		  //if (type=="Vorace") this.addvorace(a,o);
	      //if (type=="Cannibale") this.addcannibale(a,o);
		  //if (type=="Lapin") this.addlapin (a,o);  
		 
	  }
	  
	
	/**
	 * @param box
	 * Création d'un erratique "standard" placé dans une case box d'un loft loftencours.
	 */
	
	public void adderratique(int a, int o){ 		
		Erratique e = new Erratique(energiemax,a,o,this);
		e.l.demographie++;
		//System.out.println(this.Neuneus.size());
		this.Neuneus.add(e);
		this.plateau[a][o]+=1;
		//System.out.println(this.Neuneus);
		this.zone.ajouterObjet(e);
	}
	
	public void exclureLoft(){
		for (int i=0; i<demographie; i++) {
		if (Neuneus.get(i).energie<energiemin){
		Cimetiere.add(Neuneus.get(i));
		Neuneus.remove(i);
		demographie--;}
		}
		}


	public void dessinerObjet(Graphics g) {
		this.drawTable(g);
		this.drawCadre(g);
		
	}
	
	public void drawTable(Graphics g){
		g.setColor(Color.white);
		for (int i=1; i<600;i++){
			g.drawLine(i*(600/nbCasesHauteur),0,i*(600/nbCasesHauteur), 600*(600/nbCasesHauteur));}
		
		
			
		for (int j=1; j<600;j++){
			g.drawLine(0, j*(600/nbCasesLargeur),600*(600/nbCasesLargeur), j*(600/nbCasesLargeur));
		}
		
		
	}
	
	public void drawCadre(Graphics g){
		g.setColor(Color.green);
		g.drawLine(600,0, 600, 600);
		g.drawLine(0, 600, 600, 600);
	}
	
	public void generernourriture(int quantite){ //nombre *moyen* de nourritures dans le jeu ˆ l'initialisation
		double moy = ((double) quantite)/((double) nbCasesLargeur*nbCasesHauteur);
		for (int i=0;i<nbCasesLargeur;i++){ //ajout de nourritures dans le jeu
			for (int j =0; j<nbCasesHauteur; j++) {
				double rand = Math.random();
				if (rand < moy) {
					Nourriture n = new Nourriture (10,i,j,this);
					
					//System.out.println(n);
					plateau_nourriture[i][j]=n;
					this.zone.ajouterObjet(n);

					
				}
			}
		}
	}

		public void initialiser_erratique(int population_erratique){ //nombre *moyen* d'erratiques dans le jeu ˆ l'initialisation
			double moy = ((double) population_erratique)/((double) nbCasesLargeur*nbCasesHauteur);
			for (int i=0;i<nbCasesLargeur;i++){ //ajout des erratiques dans le jeu
				for (int j =0; j<nbCasesHauteur; j++) {
					double rand = Math.random();
					if (rand < moy) {
						this.adderratique(i,j);
						
					}
				}
			}
		}

		/*public void initialiser_lapin(int population_lapin){ //nombre *moyen* d'erratiques dans le jeu ˆ l'initialisation
			double moy = ((double) population_lapin)/((double) nbCasesLargeur*nbCasesHauteur);
			for (int i=0;i<nbCasesLargeur;i++){ //ajout des erratiques dans le jeu
				for (int j =0; j<nbCasesHauteur; j++) {
					double rand = Math.random();
					if (rand < moy) {
						Lapin la = new Lapin (10,i,j,this);
						Neuneus.add(la);
						plateau[i][j] ++;
						demographie++;
					}
				}
			}
		}*/

		/*public void initialiser_vorace(int population_vorace){ //nombre *moyen* d'erratiques dans le jeu ˆ l'initialisation
			double moy = ((double) population_vorace)/((double) nbCasesLargeur*nbCasesHauteur);
			for (int i=0;i<nbCasesLargeur;i++){ //ajout des erratiques dans le jeu
				for (int j =0; j<nbCasesHauteur; j++) {
					double rand = Math.random();
					if (rand < moy) {
						Vorace v = new Vorace (10,i,j,this);
						Neuneus.add(v);
						plateau[i][j] ++;
						demographie++;
					}
				}
			}
		}*/


	/*	public void initialiser_cannibale(int population_cannibale){ //nombre *moyen* d'erratiques dans le jeu ˆ l'initialisation
			double moy = ((double) population_cannibale)/((double) nbCasesLargeur*nbCasesHauteur);
			for (int i=0;i<nbCasesLargeur;i++){ //ajout des erratiques dans le jeu
				for (int j =0; j<nbCasesHauteur; j++) {
					double rand = Math.random();
					if (rand < moy) {
						Cannibale ca = new Cannibale (10,i,j,this);
						Neuneus.add(v);
						plateau[i][j] ++;
						demographie++;
					}
				}
			}
		}*/
	

		
	
}



	
