package com.objet.lofteurs;

import java.awt.Color;
import java.awt.Graphics;


public class Lapin extends Neuneu {


	public Lapin(int e, int ab, int or, Loft lo) {
		abscisse =ab;
		ordonnee=or;
		energie=e;
		l = lo;
		vientDeSeReproduire=lo.tempsReproduction;
		type = "Lapin";
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
		 if (n.type=="Lapin"){
			System.out.println("Oh c'est une Lapin ! comme moi !!");
			if (n.energie-this.l.energiereproduction>=this.l.energiemin && this.energie-(this.l.energiereproduction+this.l.energiepas)>=this.l.energiemin){
				this.sedeplacer(a, b);
				System.out.println("Let's make a baby !");
				this.sereproduire(n);
				System.out.println ("A new Lapin is born !");}
			else{System.out.println("Je n'ai pas assez d'énergie pour me reproduire");}
		 }
		 else{System.out.println("Ce n'est pas un Lapin ! Je ne peux pas y aller");}
	}
	
	public int[] chercherNeuneu(){
		
		int [] direction= new int [3];
		direction[0]=0;
		direction[1]=0;
		direction[2]=0; //indice du Neuneu choisi comme partenaire

		for (int i =-1; i<=1; i=i+2) {
			for (int j=-1;j<=1;j=j+2){
					if (abscisse+i >=0 && abscisse+i < l.nbCasesLargeur && ordonnee+j >=0 && ordonnee+j < l.nbCasesHauteur) {
						
						if ( l.plateau[abscisse+i][ordonnee+j]==1){
							
							int m = 0;
							while ((this.l.Neuneus.get(m).abscisse != this.abscisse+i || this.l.Neuneus.get(m).ordonnee != this.ordonnee+j) && m>=this.l.Neuneus.size() ){
								m+=1;
							}
							if (l.Neuneus.get(m).type=="Lapin" && l.Neuneus.get(m).energie>this.l.energiereproduction){ 
									direction[0] =i;
									direction[1]=j;
									direction[2]=m;
							}
							
						}
						
					}
				}
			}
			
			return direction;
		}

	public void jouer(){
		int [] direction= new int [2];
		if (this.vientDeSeReproduire==0){
			direction=this.chercherNeuneu();
			if (direction[0]!=0 || direction[1]!=0){this.agir(direction[0],direction[1]);//this.rencontreNeuneu(this.l.Neuneus.get(direction[2]),direction[0],direction[1]); System.out.println("j'ai trouvé un autre Lapin !!!");
			}
			
			else { this.agir(this.deplacementHasard()[0],this.deplacementHasard()[1]);}
		}
		// déplacement aléatoire
		else { this.agir(this.deplacementHasard()[0],this.deplacementHasard()[1]);}
	}
	


	public void dessinerObjet(Graphics g){
		g.setColor(Color.black);
		g.fillOval(this.abscisse*(600/this.l.nbCasesLargeur), this.ordonnee*(600/this.l.nbCasesHauteur), 600/this.l.nbCasesLargeur, 600/this.l.nbCasesHauteur);
		}


	}


