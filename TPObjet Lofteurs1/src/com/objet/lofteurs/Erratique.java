package com.objet.lofteurs;
import java.awt.Color;
import java.awt.Graphics;

public class Erratique extends Neuneu {
	
	
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

		this.l.zone.ajouterObjet(this);
		type ="Erratique";
	}

	public void dessinerObjet(Graphics g){
		g.setColor(Color.red);
		//g.drawOval(this.getC().getAbscisse()*(600/this.getL().nbCasesLargeur), this.getC().getOrdonnee()*(600/this.getL().nbCasesHauteur), 10, 10);
		//g.drawString("X", 25, 25);
		g.fillOval(this.abscisse*(600/this.l.nbCasesLargeur), this.ordonnee*(600/this.l.nbCasesHauteur), 600/this.l.nbCasesLargeur, 600/this.l.nbCasesHauteur);
	}
	
	/*public void sedeplacer(){
		vientDeSeReproduire ++;
		this.l.energiepas--;
		for (Neuneu n : l.Neuneus) { // si il a un voisin de la mme espce que lui
			if (Math.abs(n.abscisse-abscisse)+Math.abs(n.ordonnee-ordonnee)==1 && n.type=="Erratique") {
			l.plateau[abscisse][ordonnee]--;
			abscisse = n.abscisse;
			ordonnee = n.ordonnee;
			return;
			}
			}

		int compt = 0; // nombre de cases voisines accessibles, vaut entre 0 et 4
		for (int i = -1; i <=1; i=i+2) {
			if (abscisse+i >=0 && abscisse+i < l.largeur && l.plateau_neuneus[abscisse+i][ordonnee]==0)
				compt++;
		}
		for (int j=-1; j<=1; j=j+2) {
			if ( ordonnee+j >=0 && ordonnee +j < l.hauteur && l.plateau_neuneus[abscisse][ordonnee+j]==0)
				compt++;
		}
		if (compt==0) {
			// je ne peux pas me dŽplacer
		}
		else {
			int random_direction = (int) Math.random()*(compt-1)+1; // nombre au hasard entre 1 et compt
			compt=0;
			for (int i = -1; i <=1; i=i+2) {
				if (abscisse+i >=0 && abscisse+i < l.largeur && l.plateau_neuneus[abscisse+i][ordonnee]==0) {
					compt++;
					if (compt==random_direction) {
						l.plateau_neuneus[abscisse][ordonnee]--;
						abscisse = abscisse+i;
						l.plateau_neuneus[abscisse][ordonnee]++;
					}

				}
			}
			for (int j=-1; j<=1; j=j+2) {
				if ( ordonnee+j >=0 && ordonnee +j < l.hauteur && l.plateau_neuneus[abscisse][ordonnee+j]==0) {
					compt++;
					if (compt==random_direction) {
						l.plateau_neuneus[abscisse][ordonnee]--;
						ordonnee = ordonnee+j;
						l.plateau_neuneus[abscisse][ordonnee]++;
					}

				}
			}

		}

	}
}*/

	/**
	 * les erratiques errent au hasard
	 */
	public void agir(){ 
		
		int a=(int) (Math.random()*(4)-2);
		int b=(int) (Math.random()*(4)-2);
		
		if ((a==0 && b==0) || a==-2 ||b==-2){
			while ((a==0 && b==0) || a==-2 ||b==-2 ){
		
			 a=(int)(Math.random()*(4)-2);
			 b=(int)(Math.random()*(4)-2);}
			 }
		
		//System.out.println("valeurs random a: "+ a);
		int x= this.abscisse;
		int y= this.ordonnee;
		//System.out.println("avant d'avancer "+this.abscisse);
		
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
					
					if (i>= this.l.Neuneus.size()){
						this.sedeplacer(a, b);
					}
					else if (this.l.Neuneus.get(i).type=="Erratique"){
						System.out.println("Oh c'est une Erratique ! comme moi !!");
						if (this.l.Neuneus.get(i).energie-this.l.energiereproduction>=this.l.energiemin && this.energie-(this.l.energiereproduction+this.l.energiepas)>=this.l.energiemin){
							this.sedeplacer(a, b);
							System.out.println("Let's make a baby !");
							this.sereproduire(this.l.Neuneus.get(i));
							System.out.println ("A new Erratique is born !");}
						}
					System.out.println("Je suis trop fatigué pour me reproduire");
				}
			}
		
		
		if (this.l.plateau_nourriture[this.abscisse][this.ordonnee]!=null){
			
			this.manger(this.l.plateau_nourriture[this.abscisse][this.ordonnee]);
			System.out.println("J'ai mangé");
		}
		
	}
	

}





	

