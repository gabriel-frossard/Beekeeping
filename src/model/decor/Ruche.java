package model.decor;

import java.awt.Point;
import java.util.HashSet;
import java.util.Iterator;

import model.agents.Animal;
import model.agents.Sexe;
import model.agents.animaux.AbeilleDomestique;
import model.comportements.Hebergeur;

public class Ruche extends Decor implements Hebergeur{
	
	/**
	 * Liste des abeilles de la ruche 
	 */
	private HashSet<AbeilleDomestique> population;
	/**
	 * constante taille maximale de la ruche
	 */
	private static int populationMax = 1000;
	
	public Ruche(Point p) {
		super(p);
		population = new HashSet<AbeilleDomestique>();
	}

	@Override
	public boolean peutAccueillir(Animal a) {
		if(this.population.size() <= populationMax && !(population.contains(a))) {
			return a instanceof AbeilleDomestique;
		}
		else {	
			return false;
		}
	}

	@Override
	public boolean accueillir(Animal a) {
		boolean ret = false;
		if(peutAccueillir(a)) {
			/* Ne pas faire ça ici: c'est à l'animal de mettre à jour ses attributs
			 * a.setHebergeur(this);
			 */
			ret=true;
			population.add((AbeilleDomestique)a);
		}
		return ret;
	}
	
	public String toString() {
		String ret = "Ruche "+ this.getCoord() + ": population " +this.population.size()+ " abeille(s)\n";
		for(AbeilleDomestique a:population) 
			ret += a.toString() + "\n";
		/*
		 * "\t" code une tabulation dans une chaine de caractères
		 * "\n" un saut de ligne 
		 */
		return ret;
	}
	
	
	public static void main(String[] a) {
		
		Ruche r = new Ruche(new Point(0,0));
		new AbeilleDomestique(Sexe.Assexue, new Point(10,20),r);
		System.out.println(r);
		new AbeilleDomestique(Sexe.Assexue, new Point(10,20),r);
		System.out.println(r);
		new AbeilleDomestique(Sexe.Femelle, new Point(5,10),r);
		System.out.println(r);
		
	}
	
}
