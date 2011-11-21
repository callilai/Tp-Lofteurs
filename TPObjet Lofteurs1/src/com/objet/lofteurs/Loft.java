package com.objet.lofteurs;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * @author Charline
 *
 */
public class Loft implements ObjetDessinable{
	
	public int nbCasesHauteur;
	public int nbCasesLargeur;
	public int energiemin;
	public int energiemax;
	public int energiereproduction;
	public int energiepas;
	public int vieloft; 
	public int quantite;
	public int demographie;
	public int demographieinit;
	public ArrayList<Neuneu> Cimetiere; 
	public ArrayList<Erratique> Neuneus;  
	public ZoneGraphique zone;
	public Case [][] plateau; 

	
	/**
	 * @param h
	 * @param l
	 * @param emin
	 * @param emax
	 * @param ereprod
	 * @param pas
	 * @param v
	 * @param q
	 * @param demo
	 */
	public Loft (int nombreCasesX,int nombreCasesY,ZoneGraphique zone) {
		
		this.nbCasesHauteur=nombreCasesY;
		this.nbCasesLargeur=nombreCasesX;
		
		this.energiemin=0;
		this.energiemax=10;
		this.energiereproduction=5;
		this.energiepas=1;
		this.vieloft=200;
		this.quantite=(int)(nombreCasesX*nombreCasesY)/4; //1/4 des cases possèdent de la nourriture
		//this.demographie=(int)(nombreCasesX*nombreCasesY)/8; //1/8 des cases possèdent des neuneus
		this.demographie=0;
		this.demographieinit=10;
		this.zone=zone;
		this.plateau=new Case [this.nbCasesLargeur][this.nbCasesHauteur];
		this.Neuneus=new ArrayList<Erratique>();
	}
		
	
	 
	  public void initialiser(){ 
		  
		  
		  for (int i=0; i<nbCasesHauteur;i++){
			  for (int j=0; j<nbCasesLargeur;j++){
				  
				  Case C= new Case(j,i,this);
				  this.plateau[i][j]=C;
			  }
		  }

		  //System.out.println("tableau charge");
		  //this.adderratique(this.plateau[2][1]);
		  //this.adderratique(this.plateau[1][1]);
		  //this.adderratique(this.plateau[0][2]);
		  
		  System.out.println(this.demographieinit);

		  for (int k=0;k<this.demographieinit;k++){ 
				int abs = (int)(Math.random()*(this.nbCasesLargeur-1)+1);
				int ord= (int)(Math.random() *(this.nbCasesHauteur-1)+1);
				  this.adderratique(abs,ord);
				  System.out.println("test");
				
		}
			  
	  }

	
	
	
	/**
	 * @param box
	 * Création d'un erratique "standard" placé dans une case box d'un loft loftencours.
	 */
	
	public void adderratique(int a, int o){ 		
		Erratique e = new Erratique(a,o, energiemax,this);
		e.getL().demographie++;
		System.out.println(this.Neuneus.size());
		this.Neuneus.add(e);
		System.out.println(this.Neuneus);
		this.zone.ajouterObjet(e);
	}
	public void addnourriture(Case box){
	    
	  }
	  
	public void exclureLoft(){
	    for (int i=0; i<demographie; i++) {
	    if (Neuneus.get(i).getEnergie()<energiemin)
	    Neuneus.remove(i);}
	    }
	 

	public void dessinerObjet(Graphics g) {
		this.drawTable(g);
		
	}
	
	public void drawTable(Graphics g){
		g.setColor(Color.white);
		for (int i=1; i<600;i++){
			g.drawLine(i*(600/nbCasesHauteur),0,i*(600/nbCasesHauteur), 600*(600/nbCasesHauteur));}
			
		for (int j=1; j<600;j++){
			g.drawLine(0, j*(600/nbCasesLargeur),600*(600/nbCasesLargeur), j*(600/nbCasesLargeur));
		}
		
	}
}



	
