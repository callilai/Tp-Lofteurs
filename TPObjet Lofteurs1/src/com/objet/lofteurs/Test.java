package com.objet.lofteurs;

import java.util.Set;

public class Test {

	public static int nombreLofteurs = 4;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Test().primeTime();
	}
	
	public void primeTime() {
		ZoneGraphique zone = new ZoneGraphique("Mon premier loft");
		Loft loft = new Loft(40,40,zone);
		zone.ajouterObjet(loft);
		
		loft.initialiser();
		
		while (loft.vieloft != 0){
			
			for (int i=0;i<loft.Neuneus.size();i++){
				loft.Neuneus.get(i).agir();
				
			}
			loft.vieloft-=1;
			
		}

				}
}


