package launchers;

import java.awt.Point;

import model.agents.Sexe;
import model.agents.animaux.AbeilleDomestique;
import model.agents.animaux.FrelonAsiatique;
import model.decor.Ruche;
import model.world.Monde;

public class LauncherTP3 {

	public static void main(String[] args) {
		Monde m = new Monde(50);
		System.out.println(m);
		m.cycle();
		System.out.println(m);
		
		Ruche a = new Ruche(new Point(0,0));
		AbeilleDomestique b = new AbeilleDomestique(Sexe.Femelle,new Point(0,0),a);
		AbeilleDomestique c = new AbeilleDomestique(Sexe.Femelle,new Point(0,0),a);
		AbeilleDomestique d = new AbeilleDomestique(Sexe.Femelle,new Point(0,0),a);
		
		a.accueillir(b);
		a.accueillir(c);
		a.accueillir(d);
		System.out.println(a.toString());
	}

}
