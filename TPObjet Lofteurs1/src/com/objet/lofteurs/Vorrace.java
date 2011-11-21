package com.objet.lofteurs;

public class Cannibale extends Vorace {

	public Cannibale(int e, int ab, int or, Loft lo) {
		super(e,ab,or,lo);
		type = "cannibale";
	}

	public void sedeplacer(){

		vientDeSeReproduire ++;
		this.l.energiepas--;


		if (energie < l.energiemax/4.) { //mange un autre cannibale si son Žnergie est faible
		for (Neuneu n : l.Neuneus) {
		if ( Math.abs(n.abscisse-abscisse)+Math.abs(n.ordonnee-ordonnee)==1) {
		l.demographie--;
		l.Cimetiere.add(n);
		l.Neuneus.remove(n);
		l.plateau_neuneus[abscisse][ordonnee]--;
		return;

		// on sort de la boucle for
		// energie (il va manger l'autre)...
		}

		}

		super.sedeplacer();
		}
		}
}
