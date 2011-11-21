package com.objet.lofteurs;
import java.awt.Color;
import java.awt.Graphics;


/**
 * @author Charline
 *
 */
public class Erratique extends Neuneu {
	
	
	/**
	 * constructeur d'un Erratique : dŽfinit par son Žnergie
	 * @param e
	 * 
	 */
	

	public Erratique(int abs, int ord, int energie, Loft lf){	
	
		this.energie=energie;
		this.x=abs;
		this.y=ord;
		this.l=lf;
		this.type=new String("Erratique");
		this.vientDeSeReproduire=0;
		this.indiceListeNeuneu=0;
		
		this.l.zone.ajouterObjet(this);
	}
	
	
	
	public Erratique() {
		// TODO Auto-generated constructor stub
	}



	public void dessinerObjet(Graphics g){
		g.setColor(Color.red);
		//g.drawOval(this.getC().getAbscisse()*(600/this.getL().nbCasesLargeur), this.getC().getOrdonnee()*(600/this.getL().nbCasesHauteur), 10, 10);
		//g.drawString("X", 25, 25);
		g.fillOval(this.x*(600/this.getL().nbCasesLargeur), this.y*(600/this.getL().nbCasesHauteur), 600/this.getL().nbCasesLargeur, 600/this.getL().nbCasesHauteur);
	}
	

	/**
	 * les erratiques errent au hasard
	 */
	public void agir(){ 
		
		int a=(int)Math.random()*(2);
		int b=(int)Math.random()*(2);
		
		int x= this.x;
		int y= this.y;
		
		Case but = new Case();
		but= this.getL().plateau[x+a][y+b];
		
		if (this.getEnergie()>getL().energiepas){
			
			//switch (but.getNbneuneu()) {
			//case 0 : 
				this.sedeplacer(a,b);
			//	break;
				
			/*case 1 :
				if (but.getAneuneu().getType()=="Erratique"){
					if (but.getAneuneu().getEnergie()-this.getL().energiereproduction>=this.getL().energiemin && this.getEnergie()-(this.getL().energiereproduction+this.getL().energiepas)>=this.getL().energiemin){
						this.sedeplacer(a, b);
						this.sereproduire(but.getAneuneu());
					}
				}
			break; 
			
			}
			
			if (this.getC().getAnourriture()!=null){
				this.manger(this.getC().getAnourriture());
			}*/
			
		//}
	}	
}
}	
	

