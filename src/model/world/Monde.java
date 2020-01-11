package model.world;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import model.agents.Agent;
import model.agents.PointPositif;
import model.agents.Sexe;
import model.agents.animaux.AbeilleDomestique;
import model.agents.animaux.AbeilleSolitaire;
import model.agents.animaux.FrelonAsiatique;
import model.agents.animaux.FrelonEuropeen;
import model.agents.animaux.Varroa;
import model.agents.vegetaux.Arbre;
import model.agents.vegetaux.Fleur;
import model.decor.Ruche;

public class Monde {
	/**
	 * population d'agents dans le monde
	 */
	private Set<Agent>agents;
	/**
	 * map de probabilité pour trouver un agent
	 */
	private static final Map<Integer,Agent> proba= Monde.probaAgent();
	/**
	 * constante: largeur du monde
	 */
	private static int LARGEUR = 30;
	/**
	 * constante: longueur du monde
	 */
	private static int LONGUEUR = 20;
	
	/**
	 * 
	 * @param nbAgents
	 */
	
	public Monde(int nbAgents) {
		agents=generateAgents(nbAgents);
	}
	
	/**
	 * Méthode utilitaire statistique pour produire la table de proba
	 * d'apparition d'un agent
	 * @return
	 */
	private static Map<Integer, Agent> probaAgent() {
		Ruche r1 =new Ruche(new Point(10,50));
		Ruche r2 =new Ruche(new Point(100,20));
		Map<Integer,Agent> myMap = new LinkedHashMap<Integer,Agent>();
	    myMap.put(20,new AbeilleDomestique(Sexe.Assexue,new Point(0,0),r1));
	    myMap.put(40,new AbeilleDomestique(Sexe.Assexue,new Point(0,0),r2));
	    myMap.put(50,new AbeilleSolitaire(Sexe.Assexue,new Point(0,0)));
	    myMap.put(55,new FrelonEuropeen(Sexe.Assexue,new Point(0,0)));
	    myMap.put(60,new FrelonAsiatique(Sexe.Assexue,new Point(0,0)));
	    myMap.put(70,new Varroa(Sexe.Assexue,new Point(0,0)));
	    myMap.put(80,new Arbre(new Point(0,0),1.0));
	    myMap.put(85,new Arbre(new Point(0,0),2.0));
	    myMap.put(100,new Fleur(new Point(0,0)));
	    return myMap;
	}
	
	/**
	 * fabrication aléatoire d'un Agent par tirage dans la Map
	 * et positionnement aléatoire
	 * @param alea
	 * @return
	 */
	private static Agent tirage(int alea) {
		/*
		 * NE PAS TOUCHER!
		 */
		Agent agent=null;
		if(alea<100 && alea>=0) {
			boolean trouve = false;
			Iterator<Integer> it = proba.keySet().iterator();
			while(!trouve && it.hasNext()) {
				Integer clef = it.next();
				if(clef>=alea) {
					agent = proba.get(clef);
					trouve=true;
				}
			}
		}
		else {
			agent = new Fleur(new Point(0,0));
		}
		//positionnement aléatoire entre Longueur et Largeur
		int aleaX = (int)(Math.random()*LONGUEUR);
		int aleaY = (int)(Math.random()*LONGUEUR);
		agent.setCoord(aleaX, aleaY);
		return agent;
	}

	private TreeSet<Agent> generateAgents(int nbAgents) {
			/*
			 * NE PAS TOUCHER!
			 */
		TreeSet<Agent> ts = new TreeSet<Agent>();
		for(int i=0;i<nbAgents;i++) {
			int alea = (int)(Math.random()*100);
			ts.add((Agent)tirage(alea).clone());
		}
		return ts;
	}

	public String toString() {
		String ret="";
		ret+="******************************\n";
		ret+="Le monde contient "+agents.size()+" agents:\n";
		
		Set<Agent> coordSet = new TreeSet<Agent>(new CoordComparator());
		coordSet.addAll(agents);
	
		for(Agent a:agents) {
			ret+="\t"+a+"\n";
		}
		return ret;
	}

	/**
	 * génère un cycle de vie dans le monde
	 */
	public void cycle() {
		/*
		 * TODO appeler la méthode cycle sur tous les agents		
		 */
	}
	
	
	

}
