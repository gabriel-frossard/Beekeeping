package model.agents.animaux;

import java.awt.Point;

import model.agents.Sexe;

public class FrelonEuropeen extends Frelon {
	
	public FrelonEuropeen(Sexe s, Point p) {
		super(s,p);
	}

	/* inutile avec la liste de proies à partir du TP3
	@Override
	public void rencontrer(Agent a) {
		//penser à réutiliser l'existant
		super.rencontrer(a);
		
		if(a instanceof FrelonAsiatique) {
			Animal b = (Animal)a;
			gestionProie(b);
		}

	}
	*/

	@Override
	public Object clone() {
		return new FrelonEuropeen(getSexe(), new Point(getCoord().getX(),getCoord().getY()));
	}
}
