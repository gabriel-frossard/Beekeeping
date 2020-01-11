package model.agents;

import java.awt.Point;

public class PointPositif implements Cloneable{
	private Point p;
	
	public PointPositif(Point p) {
		
		this.p = (Point) p.clone();
	}
	
	public int getX() {return (int)(p.getX());}
	
	public int getY() {return (int)(p.getY());}
	
	public boolean setX(int x) {
		boolean ret=true;
		if (x<0) {
			p.x = -x;
		}
		else {
			p.x = x;
		}
		return ret;
	}
	
	public boolean setY(int y) {
		
		boolean ret=true;
		if (y<0) {
			p.y = -y;
		}
		else {
			p.y = y;
		}
		return ret;
	}
	
	@Override
	public String toString() {
		//NomDeLaClasse n° id_animal(sexe, (position x; position y))
		return "("+ getX() + ";" + getY() + ")";
	}
	
	public Object clone() {
		return new PointPositif((Point)p.clone());		
	}
}
