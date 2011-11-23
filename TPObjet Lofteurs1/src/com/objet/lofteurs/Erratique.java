package com.objet.lofteurs;

import java.awt.*;

public class Erratique extends Neuneu{
	
	
	/**
	 * constructeur d'un Erratique : définit par son énergie
	 * @param e
	 * 
	 */
	
	public Erratique(int e, int ab, int or, Loft lo){	
		//super(e,ab,or,lo);
		abscisse =ab;
		ordonnee=or;
		energie=e;
		l = lo;
		vientDeSeReproduire=lo.tempsReproduction;

		//this.l.zone.ajouterObjet(this);
		type ="Erratique";
	}

	public void dessinerObjet(Graphics g){
		
		g.setColor(Color.red);
		g.fillOval(this.abscisse*(600/this.l.nbCasesLargeur), this.ordonnee*(600/this.l.nbCasesHauteur), 600/this.l.nbCasesLargeur, 600/this.l.nbCasesHauteur);
		//g.drawImage(this.l.zone.image, this.abscisse*(600/this.l.nbCasesLargeur), this.ordonnee*(600/this.l.nbCasesHauteur), 600/this.l.nbCasesLargeur, 600/this.l.nbCasesLargeur, Color.white,this.l.zone);
	
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
					
					if (i> this.l.Neuneus.size()){ //cas qui ne doit jamais arriver sinon erreur dans le plateau de neuneus !!
						this.sedeplacer(a, b);
					} 
					
					else{System.out.println("rencontre neuneu");this.rencontreNeuneu(l.Neuneus.get(i), a,b);}
			 }
		
		
		if (this.l.plateau_nourriture[this.abscisse][this.ordonnee]!=null){
			
			this.manger(this.l.plateau_nourriture[this.abscisse][this.ordonnee]);
			System.out.println("J'ai mangé");
		}
		
	}
	

	}
	
	
	
	public void rencontreNeuneu(Neuneu n, int a, int b){
		 if (n.type=="Erratique"){
			System.out.println("Oh c'est une Erratique ! comme moi !!");
			if (n.energie-this.l.energiereproduction>=this.l.energiemin && this.energie-(this.l.energiereproduction+this.l.energiepas)>=this.l.energiemin){
				this.sedeplacer(a, b);
				System.out.println("Let's make a baby !");
				this.sereproduire(n);
				System.out.println ("A new Erratique is born !");}
			else{System.out.println("Je n'ai pas assez d'énergie pour me reproduire");}	
			}
		 else{System.out.println("Ce n'est pas un Erratique ! Je ne peux pas y aller");}
	}
		
	
	/**
	 * les erratiques errent au hasard
	 */
	
	public void jouer(){
		this.agir(this.deplacementHasard()[0], this.deplacementHasard()[1]);
	}
}






	

