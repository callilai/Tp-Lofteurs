package com.objet.lofteurs;

import java.awt.Color;
import java.awt.Graphics;


public class Cannibale extends Vorace {

	public Cannibale(int e, int ab, int or, Loft lo) {
		super(e,ab,or,lo);
		type = "Cannibale";
	}

	public int[] chercherNeuneuRepas(){
			
		int [] direction= new int [3];
		direction[0]=0;
		direction[1]=0;
		direction[2]=0; //indice du Neuneu a manger

		int cal_max =0;
		for (int i =-1; i<=1; i=i+2) {
			for (int j=-1;j<=1;j=j+2){
					if (abscisse+i >=0 && abscisse+i < l.nbCasesLargeur && ordonnee+j >=0 && ordonnee+j < l.nbCasesHauteur) {
						
						if ( l.plateau[abscisse+i][ordonnee+j]==1){
							int m = 0;
							while ((this.l.Neuneus.get(m).abscisse != this.abscisse+i || this.l.Neuneus.get(m).ordonnee != this.ordonnee+j) && m>=this.l.Neuneus.size() ){
								m+=1;
							}
							if (l.Neuneus.get(m).type=="Cannibale" && l.Neuneus.get(m).energie>cal_max){ //on ne peut manger un autre cannibale que si son energie est inférieure à la notre
								if (l.Neuneus.get(m).energie<this.energie){
									cal_max = l.Neuneus.get(m).energie;
									direction[0] = +i;
									direction[1]=j;
									direction[2]=m;
								}
								
							}
							else{
								
							int cal_courant = l.Neuneus.get(m).energie;
							if (cal_courant > cal_max) {
								cal_max = cal_courant;
								direction[0] = +i;
								direction[1]=j;
								direction[2]=m;}
							}
						}
						
						if (l.plateau_nourriture[this.abscisse+i][this.ordonnee+j]!=null){;
						Nourriture n= l.plateau_nourriture[this.abscisse+i][this.ordonnee+j];
						System.out.println(n);
						
				
						}
					}
				}
			}
			
			return direction;
		}
	public void rencontreNeuneu(Neuneu n, int a, int b){
		 if (n.type=="Cannibale"){
			System.out.println("Oh c'est une Cannibale ! comme moi !!");
			if (n.energie-this.l.energiereproduction>=this.l.energiemin && this.energie-(this.l.energiereproduction+this.l.energiepas)>=this.l.energiemin){
				this.sedeplacer(a, b);
				System.out.println("Let's make a baby !");
				this.sereproduire(n);
				System.out.println ("A new Cannibale is born !");}
			else{System.out.println("Je n'ai pas assez d'énergie pour me reproduire");}
		 }
		 else{System.out.println("Ce n'est pas un Cannibale ! Je ne peux pas y aller");}
	}
	

	public void jouer(){
	int [] direction= new int [3];
	direction=this.chercherNourriture();
	
	if (direction[0]!=0 || direction[1]!=0){
		
		this.agir(direction[0],direction[1]);}
	//si pas de nourriture on cherche un Neuneu pour le manger
	else{
		direction=this.chercherNeuneuRepas();
		if (direction[0]!=0 || direction[1]!=0){
			this.agir(direction[0],direction[1]);
			this.energie+=this.l.Neuneus.get(direction[2]).energie;
			System.out.println("Un Neuneu a été mangé par un Cannibale");
			this.l.Neuneus.get(direction[2]).mourir();}
		
		//en dernier recours on se déplace aléatoirement
		else { this.agir(this.deplacementHasard()[0],this.deplacementHasard()[1]);}
	}
	}



	public void dessinerObjet(Graphics g){
		g.setColor(Color.yellow);
		g.fillOval(this.abscisse*(600/this.l.nbCasesLargeur), this.ordonnee*(600/this.l.nbCasesHauteur), 600/this.l.nbCasesLargeur, 600/this.l.nbCasesHauteur);
		}
}

