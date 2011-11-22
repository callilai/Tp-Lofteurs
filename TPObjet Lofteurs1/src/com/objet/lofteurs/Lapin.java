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


