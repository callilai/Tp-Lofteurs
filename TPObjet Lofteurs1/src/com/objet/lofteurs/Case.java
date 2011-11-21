package com.objet.lofteurs;

import java.awt.Color;
import java.awt.Graphics;



/**
 * @author Charline
 *
 */
public class Case implements ObjetDessinable {

	private int abscisse;
	private int ordonnee;
	private Nourriture anourriture;
	private Neuneu aneuneu;
	protected int nbneuneu;
	private Loft l;


	/**
	 * 
	 */
	public Case(){
	
	}
	/**
	 * @param abs
	 * @param ord
	 */
	public Case(int abs, int ord,Loft l){
		this.abscisse=abs;
		this.ordonnee=ord;
		this.anourriture= new Nourriture();
		this.aneuneu=new Erratique();
		this.nbneuneu=0;
		this.l=l;

	}

	/**
	 * @return
	 */
	public int getOrdonnee() {
		return ordonnee;
	}

	/**
	 * @param ordonnee
	 */
	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
	}

	/**
	 * @return
	 */
	public Nourriture getAnourriture() {
		return anourriture;
	}

	/**
	 * @param anourriture
	 */
	public void setAnourriture(Nourriture anourriture) {
		this.anourriture = anourriture;
	}

	/**
	 * @return
	 */
	public Neuneu getAneuneu() {
		return aneuneu;
	}

	/**
	 * @param aneuneu
	 */
	public void setAneuneu(Neuneu aneuneu) {
		this.aneuneu = aneuneu;
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
	public int getAbscisse() {
		return abscisse;
	}

	/**
	 * @param abscisse
	 */
	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}

	/**
	 * @return
	 */
	public int getNbneuneu() {
		return nbneuneu;
	}

	/**
	 * @param nbneuneu
	 */
	public void setNbneuneu(int nbneuneu) {
		this.nbneuneu = nbneuneu;
	}
	@Override
	public void dessinerObjet(Graphics g) {
		//g.setColor(Color.blue);
		//g.fillRect(abscisse*600/(this.getL().nbCasesLargeur), ordonnee*600/(this.getL().nbCasesHauteur), 600/(this.getL().nbCasesLargeur),600/(this.getL().nbCasesHauteur));
		
	}
	
}
	
