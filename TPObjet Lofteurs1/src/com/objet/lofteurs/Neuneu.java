package com.objet.lofteurs;

/**
 * @author Charline
 * classe abstraite Neuneu définit les attributs communs à tous les Neuneus ainsi que les méthodes
 * essentielles à chaque lofteur
 */

public abstract class Neuneu implements ObjetDessinable{

	public int abscisse;
	public int ordonnee;
	public int energie;
	public String type;
	public Loft l;
	public int vientDeSeReproduire;

	


	/**Constructeur Neuneu
	 * @param e
	 * @param ab
	 * @param or
	 * @param lo
	 * @param vdsr
	 */
	/*public Neuneu (int e, int ab, int or, Loft lo) {
		abscisse =ab;
		ordonnee=or;
		energie=e;
		l = lo;
		vientDeSeReproduire=lo.tempsReproduction;

		this.l.zone.ajouterObjet(this);
	}*/
	
	

	/**
	 * La fonction sedeplacer change de case un Neuneu et décrémente son énergie. 
	 * Si le Neuneu à la suite de son déplacement se voit avoir une énergie nulle: 
	 * on appelle la fonction mourir()
	 * On décrémente également son compteur vientDeSeReproduire si celui ci est positif.
	 * 
	 * @param directionX
	 * @param directionY
	 */
	public void sedeplacer(int directionX, int directionY){
		this.l.plateau[this.abscisse][this.ordonnee]-=1;
		
		this.abscisse+=directionX;
		this.ordonnee+=directionY;
	
		this.energie-=this.l.energiepas;
		this.l.plateau[this.abscisse][this.ordonnee]+=1;
	
		if (this.energie<this.l.energiemin){ this.mourir();}
	
		if (this.vientDeSeReproduire>0) this.vientDeSeReproduire-= 1;
		
	}
	
	/**La méthode manger incrémente l'énergie d'un Neuneu par le nombre de calorie d'un aliment.
	 * si l'énergie finale est supérieure à l'energiemax du loft alors elle est égale à energiemax et 
	 * il reste de la nourriture. Sinon il n'y a plus de nourriture. (elle est entièrement consommée)
	 * @param N
	 */
	public void manger(Nourriture N){
		System.out.println("Mon energie avant de manger : "+ this.energie);
		this.energie+= N.calorie;
		
		if (this.energie> this.l.energiemax){
			N.calorie= this.energie-this.l.energiemax;
			this.energie=this.l.energiemax;	
		}
		
		else if (this.energie <= this.l.energiemax){
			this.l.plateau_nourriture[N.abscisse][N.ordonnee]=null;
			this.l.zone.enleverObjet(this.l.plateau_nourriture[this.abscisse][this.ordonnee]);
			this.l.zone.repaint();
			
		}
		
		System.out.println("Ma nouvelle energie: "+this.energie);
	}

	/**
	 * la fonction sereproduire enlève aux deux partenaires l'énergie de reproduction
	 * leur incrémente le compteur vientdesereproduire et créé un nouveau Neuneu
	 * On vérifie ensuite que l'énergie de chaque partenaire n'est pas nulle
	 * si nulle on appelle la fonction mourir
	 * @param n
	 */
	public void sereproduire(Neuneu n){
	
		this.energie=this.energie - this.l.energiereproduction;
		n.energie=n.energie-this.l.energiereproduction;
	
		this.vientDeSeReproduire+= 5;
		n.vientDeSeReproduire+= 5;
		
		this.l.adderratique(this.abscisse, this.ordonnee);
		
		if (this.energie<this.l.energiemin){ this.mourir();}
		if (n.energie<this.l.energiemin){n.mourir();}
		
	}

	/*public void sereproduire(){
		// choisir l'Žnergie du bŽbŽ

		if (l.plateau_neuneus[abscisse][ordonnee] > 1 && vientDeSeReproduire > 5) { // alors il y en a au moins 2

		if (type == "lapin") {
		Lapin nouveau_lapin = new Lapin (energie, abscisse, ordonnee,l, 0);
		nouveau_lapin.vientDeSeReproduire=0;
		l.Neuneus.add(nouveau_lapin);
		l.demographie++;
		l.plateau_neuneus[abscisse][ordonnee]++;
		this.vientDeSeReproduire=0;
		}
		else if (type == "erratique") {
		Erratique nouveau_erratique = new Erratique (energie, abscisse, ordonnee,l);
		nouveau_erratique.vientDeSeReproduire=0;
		l.Neuneus.add(nouveau_erratique);
		l.demographie++;
		l.plateau_neuneus[abscisse][ordonnee]++;
		this.vientDeSeReproduire=0;
		}
		else if (type == "vorace") {
		Vorace nouveau_vorace = new Vorace (energie, abscisse, ordonnee,l);
		nouveau_vorace.vientDeSeReproduire=0;
		l.Neuneus.add(nouveau_vorace);
		l.demographie++;
		l.plateau_neuneus[abscisse][ordonnee]++;
		this.vientDeSeReproduire=0;
		}
		else if (type == "cannibale") {
		Cannibale nouveau_cannibale = new Cannibale (energie, abscisse, ordonnee,l);
		nouveau_cannibale.vientDeSeReproduire=0;
		l.Neuneus.add(nouveau_cannibale);
		l.demographie++;
		l.plateau_neuneus[abscisse][ordonnee]++;
		this.vientDeSeReproduire=0;
		}

		for (Neuneu n : l.Neuneus) {
		if (n.abscisse == abscisse && n.ordonnee == ordonnee) {
		n.vientDeSeReproduire=0; // je mets tous ceux qui sont sur la mme case comme venant de se reproduire
		}
		}
		}


		}*/
	/**
	 * La méthode mourir enlève un Neuneu de la liste de neuneus du loft, l'ajoute dans la liste du cimetière
	 * et décrémente la population du loft
	 */
	public void mourir(){
		
		this.l.demographie-=1;
		this.l.Cimetiere.add(this);
		this.l.Neuneus.remove(this);
		this.l.zone.enleverObjet(this);
		this.l.zone.repaint();
		System.out.println("Un Erratique est mort");
		System.out.println("Demographie : "+ this.l.demographie);
		System.out.println("le cimetière "+this.l.Cimetiere);
		System.out.println("les neuneus restants "+this.l.Neuneus);
	}
	/**
	 * @param a
	 * @return
	 */
	public int [] chercherdirection (int abs, int ord){
		
		int [] vecteur = new int [2];
		int distancex = abs-this.abscisse;
		int distancey = ord - this.ordonnee;
		
		vecteur[0]= distancex;
		vecteur[1]= distancey;
		
		return vecteur ;
		
	}
	
}
