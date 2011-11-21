package com.objet.lofteurs;


/**
 * @author Charline
 * classe abstraite Neuneu d�finit les attributs communs � tous les Neuneus ainsi que les m�thodes
 * essentielles � chaque lofteur
 */

public abstract class Neuneu implements ObjetDessinable{

	public Case c;
	public int energie;
	public String type;
	public Loft l;
	public int vientDeSeReproduire;
	
	public int indiceListeNeuneu;
	
	public int getIndiceListeNeuneu() {
		return indiceListeNeuneu;
	}

	public void setIndiceListeNeuneu(int indiceListeNeuneu) {
		this.indiceListeNeuneu = indiceListeNeuneu;
	}

	/**
	 * La fonction sedeplacer change de case un Neuneu et d�cr�mente son �nergie. 
	 * Si le Neuneu � la suite de son d�placement se voit avoir une �nergie nulle: 
	 * on appelle la fonction mourir()
	 * On d�cr�mente �galement son compteur vientDeSeReproduire si celui ci est positif.
	 * 
	 * @param directionX
	 * @param directionY
	 */
	public void sedeplacer(int directionX, int directionY){
		
		this.c.setNbneuneu(-1);
		
		this.c.setAbscisse(directionX);
		this.c.setOrdonnee(directionY);
	
		this.setEnergie(this.getEnergie() - getL().energiepas);
	
		if (this.getEnergie()<this.getL().energiemin){ this.mourir();}
	
		if (getVientDeSeReproduire()>0) setVientDeSeReproduire(getVientDeSeReproduire() - 1);
		this.c.setNbneuneu(+1);
		
	}
	
	/**La m�thode manger incr�mente l'�nergie d'un Neuneu par le nombre de calorie d'un aliment.
	 * si l'�nergie finale est sup�rieure � l'energiemax du loft alors elle est �gale � energiemax et 
	 * il reste de la nourriture. Sinon il n'y a plus de nourriture. (elle est enti�rement consomm�e)
	 * @param N
	 */
	public void manger(Nourriture N){
		
		this.setEnergie(+ N.calorie);
		
		if (this.getEnergie()> this.getL().energiemax){
			N.calorie= this.getEnergie()-this.getL().energiemax;
			this.setEnergie(this.getL().energiemax);	
		}
		
		else if (this.getEnergie()<= this.getL().energiemax){
			N=null;
		}
	}

	/**
	 * la fonction sereproduire enl�ve aux deux partenaires l'�nergie de reproduction
	 * leur incr�mente le compteur vientdesereproduire et cr�� un nouveau Neuneu
	 * On v�rifie ensuite que l'�nergie de chaque partenaire n'est pas nulle
	 * si nulle on appelle la fonction mourir
	 * @param n
	 */
	public void sereproduire(Neuneu n){
	
		this.setEnergie(this.getEnergie() - getL().energiereproduction);
		n.setEnergie(n.getEnergie()-getL().energiereproduction);
	
		this.setVientDeSeReproduire(this.getVientDeSeReproduire() + 5);
		n.setVientDeSeReproduire(n.getVientDeSeReproduire() + 5); 
	
		//getL().adderratique(this.getC());
		
		if (this.getEnergie()<this.getL().energiemin){ this.mourir();}
		if (n.getEnergie()<this.getL().energiemin){n.mourir();}
		this.c.setNbneuneu(+1);
	}


	/**
	 * La m�thode mourir enl�ve un Neuneu de la liste de neuneus du loft, l'ajoute dans la liste du cimeti�re
	 * et d�cr�mente la population du loft
	 */
	public void mourir(){
		
		this.getL().demographie-=1;
		this.getL().Cimetiere.add(this);
		this.getL().Neuneus.set(indiceListeNeuneu, null);
		
	}
	/**
	 * @param a
	 * @return
	 */
	public int [] chercherdirection (Case a){
		
		int [] vecteur = new int [2];
		int distancex = a.getAbscisse()-getC().getAbscisse();
		int distancey = a.getOrdonnee() - getC().getOrdonnee();
		
		vecteur[0]= distancex;
		vecteur[1]= distancey;
		
		return vecteur ;
		
	}

	/**
	 * @return
	 */
	public int getEnergie() {
		return energie;
	}

	/**
	 * @param energie
	 */
	public void setEnergie(int energie) {
		this.energie = energie;
	}

	/**
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return
	 */
	public Loft getL() {
		return l;
	}

	/**
	 * @param l
	 */
	public void setL(Loft l) {
		this.l = l;
	}

	/**
	 * @return
	 */
	public int getVientDeSeReproduire() {
		return vientDeSeReproduire;
	}

	/**
	 * @param vientDeSeReproduire
	 */
	public void setVientDeSeReproduire(int vientDeSeReproduire) {
		this.vientDeSeReproduire = vientDeSeReproduire;
	}

	/**
	 * @return
	 */
	public Case getC() {
		return c;
	}

	/**
	 * @param c
	 */
	public void setC(Case c) {
		this.c = c;
	}
	
}
