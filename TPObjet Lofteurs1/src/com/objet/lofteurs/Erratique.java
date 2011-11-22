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






	

