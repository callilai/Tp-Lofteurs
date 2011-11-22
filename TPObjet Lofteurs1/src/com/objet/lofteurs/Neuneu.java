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

	

	public int[] deplacementHasard(){
		int[] deplacement =new int[2];
		

		int a=(int) (Math.random()*(4)-2);
		int b=(int) (Math.random()*(4)-2);
		
		if ((a==0 && b==0) || a==-2 ||b==-2){
			while ((a==0 && b==0) || a==-2 ||b==-2 ){
		
			 a=(int)(Math.random()*(4)-2);
			 b=(int)(Math.random()*(4)-2);}
			 }
		
		deplacement[0]=a;
		deplacement[1]=b;
		return deplacement;

	}
	
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
			//this.l.zone.enleverObjet(this.l.plateau_nourriture[this.abscisse][this.ordonnee]);
			//this.l.zone.repaint();
			
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
	
		this.vientDeSeReproduire+= 2;
		n.vientDeSeReproduire+= 2;
		
		this.l.ajouterNeuneu(this.abscisse, this.ordonnee, this.type);
		
		if (this.energie<this.l.energiemin){ this.mourir();}
		if (n.energie<this.l.energiemin){n.mourir();}
		
	}

	/**
	 * La méthode mourir enlève un Neuneu de la liste de neuneus du loft, l'ajoute dans la liste du cimetière
	 * et décrémente la population du loft
	 */
	public void mourir(){
		
		this.l.demographie-=1;
		this.l.Cimetiere.add(this);
		this.l.Neuneus.remove(this);
		//this.l.zone.enleverObjet(this);
		//this.l.zone.repaint();
		System.out.println("Un Neuneu est mort");
		System.out.println("Demographie : "+ this.l.demographie);
		System.out.println("le cimetière "+this.l.Cimetiere);
		System.out.println("les neuneus restants "+this.l.Neuneus);
	}
	
public void agir(int a, int b){ 
		
		int x= this.abscisse;
		int y= this.ordonnee;
		
		if ((0<=(x+a) && (x+a)<this.l.nbCasesLargeur)&&( 0<=(y+b) && (y+b)<this.l.nbCasesHauteur)){
				
			int but= this.l.plateau[x+a][y+b];
				switch (but) {
				case 0 : 
					this.sedeplacer(a,b);
					System.out.println("Je me suis déplacé");
				break;
				
				case 1 :
					
					int i=0;
				   // System.out.println(this.l.Neuneus.get(i));		    
					while ((this.l.Neuneus.get(i).abscisse != this.abscisse+a || this.l.Neuneus.get(i).ordonnee != this.ordonnee+b) && i>=this.l.Neuneus.size() ){
						i+=1;
						System.out.println("Il y a quelqu'un dans la case où je veux aller. Qui est-ce ?");
					}
					
					if (i>= this.l.Neuneus.size()){ //cas qui ne doit jamais arriver sinon erreur dans le plateau de neuneus !!
						this.sedeplacer(a, b);
					} 
					
					this.rencontreNeuneu(l.Neuneus.get(i), a,b);
			 }
		
		
		if (this.l.plateau_nourriture[this.abscisse][this.ordonnee]!=null){
			
			this.manger(this.l.plateau_nourriture[this.abscisse][this.ordonnee]);
			System.out.println("J'ai mangé");
		}
		
	}
	

	}
	
	private void rencontreNeuneu(Neuneu neuneu, int a, int b) {
	// TODO Auto-generated method stub
	
}

	public void jouer() {
		// TODO Auto-generated method stub
		
	}
	
}
