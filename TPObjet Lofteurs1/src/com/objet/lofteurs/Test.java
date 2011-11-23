package com.objet.lofteurs;

import java.util.Set;

public class Test {

	public static int nombreLofteurs = 4;

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		new Test().primeTime();
	}
	
	public void primeTime() throws InterruptedException {
		ZoneGraphique zone = new ZoneGraphique("Mon premier loft");
		Loft loft = new Loft(20,20,zone);
		zone.ajouterObjet(loft);
		
		loft.initialiser();
		System.out.println(loft.Neuneus);
		
		while (loft.vieloft != 0){
			
			for (int i=0;i<loft.Neuneus.size();i++){
				loft.Neuneus.get(i).jouer();
				
				Thread.sleep(1000);
				zone.repaint();
				System.out.println("demo: "+loft.demographie);
				System.out.println(loft.Neuneus.size());
			}
			loft.vieloft-=1;
			

			
		}
		System.out.println("Partie finie!");

				}
}


