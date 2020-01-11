package model.decor;

import java.awt.Point;

import model.agents.PointPositif;

public abstract class Decor{
	/**
	 * coordonnées de l'élément de décor
	 */
	private PointPositif coord;

	public Decor(Point p) {
		coord = new PointPositif(p);
	}
	
	public PointPositif getCoord() {
		return (PointPositif)coord.clone();
	}

}
