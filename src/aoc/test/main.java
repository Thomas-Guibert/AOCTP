package aoc.test;

import aoc.observer.Afficheur;
import aoc.observer.CapteurImpl;

public class main {

	public static void main(String[] args) {
		CapteurImpl capteur = new CapteurImpl();
		capteur.setStrategy(capteur.sDiff("E"));
		Afficheur affiche1 = new Afficheur("Afficheur");
		capteur.attach(affiche1);
		for(int i=0;i<10;i++) {
			capteur.tick();
			capteur.getValue();
		}

	}

}
