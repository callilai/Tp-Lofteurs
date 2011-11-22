package com.objet.lofteurs;
import java.awt.Color;
import java.awt.Graphics;


	public class Vorace extends Erratique {


		public Vorace (int e, int ab, int or, Loft lo){	
			super(e,ab,or,lo);
			type ="Vorace";
		}
		
		public int[] chercherNourriture(){
			
			int [] direction= new int [2];
			direction[0]=0;
			direction[1]=0;

			int cal_max =0;
			for (int i =-1; i<=1; i=i+2) {
				for (int j=-1;j<=1;j=j+2){
					if (abscisse+i >=0 && abscisse+i < l.nbCasesLargeur && ordonnee+j >=0 && ordonnee+j < l.nbCasesHauteur) {
						if(l.plateau[abscisse+i][ordonnee+j]==0){
						if (l.plateau_nourriture[this.abscisse+i][this.ordonnee+j]!=null){;
						Nourriture n= l.plateau_nourriture[this.abscisse+i][this.ordonnee+j];
						System.out.println(n);
						int cal_courant = n.calorie;
						if (cal_courant > cal_max) {
								cal_max = cal_courant;
								direction[0] = +i;
								direction[1]=j;}
				
						}
					}
					}
				}
			}
			
			return direction;
		}
		
		public void rencontreNeuneu(Neuneu n, int a, int b){
			 if (n.type=="Vorace"){
				System.out.println("Oh c'est une Vorace ! comme moi !!");
				if (n.energie-this.l.energiereproduction>=this.l.energiemin && this.energie-(this.l.energiereproduction+this.l.energiepas)>=this.l.energiemin){
					this.sedeplacer(a, b);
					System.out.println("Let's make a baby !");
					this.sereproduire(n);
					System.out.println ("A new Vorace is born !");}
				else{System.out.println("Je n'ai pas assez d'énergie pour me reproduire");}
			 }
			 else{System.out.println("Ce n'est pas un Vorace ! Je ne peux pas y aller");}
		}
			
		
		public void jouer(){
			int [] direction= new int [2];
			direction=this.chercherNourriture();
			
			if (direction[0]!=0 || direction[1]!=0){
				
				this.agir(direction[0],direction[1]);}
			
			else { // déplacement aléatoire
		
				this.agir(this.deplacementHasard()[0],this.deplacementHasard()[1]);}
		}
	

		public void dessinerObjet(Graphics g){
			g.setColor(Color.green);
			g.fillOval(this.abscisse*(600/this.l.nbCasesLargeur), this.ordonnee*(600/this.l.nbCasesHauteur), 600/this.l.nbCasesLargeur, 600/this.l.nbCasesHauteur);
			}



		}
