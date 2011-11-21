package com.objet.lofteurs;
import java.awt.Color;
import java.awt.Graphics;

public class Nourriture implements ObjetDessinable {
	
	public int abscisse;
	public int ordonnee;
	public Loft l;
	public int calorie;
	public String typenourriture;


public Nourriture(int cal,int a, int o, Loft l) {
	calorie=cal;
	abscisse=a;
	ordonnee=o;
	this.l=l;
	
	}

public void dessinerObjet(Graphics g){
		g.setColor(Color.blue);
		//g.drawOval(this.getC().getAbscisse()*(600/this.getL().nbCasesLargeur), this.getC().getOrdonnee()*(600/this.getL().nbCasesHauteur), 10, 10);
		//g.drawString("X", 25, 25);
		g.fillRect(this.abscisse*(600/this.l.nbCasesLargeur)+600/this.l.nbCasesLargeur/4, this.ordonnee*(600/this.l.nbCasesHauteur)+600/this.l.nbCasesLargeur/4, 600/this.l.nbCasesLargeur/2, 600/this.l.nbCasesHauteur/2);
	}

}