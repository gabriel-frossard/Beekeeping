package model.agents.animaux;

import java.awt.Point;

import model.decor.Ruche;
import model.agents.Sexe;

public class AbeilleDomestique extends Abeille {

	private Ruche ruche;
	
	public AbeilleDomestique(Sexe s, Point p, Ruche r) {
		super(s,p);
		
		if(r.accueillir(this)) {
			this.hebergeur = r;
		}
		
	}
	
	@Override
	public Object clone() {
		return new AbeilleDomestique(getSexe(), new Point(getCoord().getX(),getCoord().getY()), (Ruche)hebergeur);
	}
	

}
