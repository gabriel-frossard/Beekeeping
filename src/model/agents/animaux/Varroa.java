package model.agents.animaux;

import model.agents.animaux.Abeille;

import java.awt.Point;

import model.agents.Sexe;
import model.agents.Agent;
import model.agents.Animal;
/**
 * 
 * @author bruno
 *
 */
public class Varroa extends Animal {
	
	public Varroa(Sexe s, Point p) {
		super(s,p);
	}
		
	@Override
	public void rencontrer(Agent a) {
		if(a instanceof Abeille) {
			Abeille candidateAuParasitage = (Abeille) a;
			this.sInstaller(candidateAuParasitage);
		}
	}

	@Override
	protected void maj() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void seNourrir() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * si le Varroa a un hébergeur, il se déplace avec l'abeille
	 */
	public void seDeplacer() {
		if(hebergeur!=null) {
			Abeille abeille = (Abeille)hebergeur;
			coord = abeille.getCoord();
		}
		else {super.seDeplacer();}
	}

	@Override
	public Object clone() {
		return new Varroa(getSexe(), new Point(getCoord().getX(),getCoord().getY()));
	}
}
