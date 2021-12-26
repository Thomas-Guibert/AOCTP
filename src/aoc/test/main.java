package aoc.test;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import aoc.activeobject.midle.Canal;
import aoc.activeobject.u.ObserverDeCapteurAsync;
import aoc.observer.Afficheur;
import aoc.observer.CapteurImpl;

public class main {

	public static void main(String[] args) {

		//Capteur & Strategy
		CapteurImpl capteur = new CapteurImpl("E");
		

		//ThreadService
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(12);

		//Canal
		Canal canal1 = new Canal(capteur,scheduledExecutorService );
		Canal canal2 = new Canal(capteur,scheduledExecutorService );
		Canal canal3 = new Canal(capteur,scheduledExecutorService );
		Canal canal4 = new Canal(capteur,scheduledExecutorService );


		//Afficheurs
		Afficheur affiche1 = new Afficheur(canal1, "Afficheur 1");
		Afficheur affiche2 = new Afficheur(canal2, "Afficheur 2");
		Afficheur affiche3 = new Afficheur(canal3, "Afficheur 3");
		Afficheur affiche4 = new Afficheur(canal4, "Afficheur 4");

		
		//Observer
		ArrayList<ObserverDeCapteurAsync> listObsAsync = new ArrayList<ObserverDeCapteurAsync>();
		listObsAsync.add(affiche1);
		listObsAsync.add(affiche2);
		listObsAsync.add(affiche3);
		listObsAsync.add(affiche4);
		
		//Attache les canaux au capteur
		capteur.attach(canal1);
		capteur.attach(canal2);
		capteur.attach(canal3);
		capteur.attach(canal4);
		canal1.setAfficheur(affiche1);
		canal2.setAfficheur(affiche2);
		canal3.setAfficheur(affiche3);
		canal4.setAfficheur(affiche4);
		
	
		scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
			public void run() {
				try {
					capteur.tick();
					System.out.println(canal1.getAfficheur().equals(canal2.getAfficheur()));
					canal1.showAfficheur();
					canal2.showAfficheur();
					canal3.showAfficheur();
					canal4.showAfficheur();
					System.out.println("");
				} catch (Exception e) {
					System.out.println("ERROR");
					e.printStackTrace();
				}
			}
		}, 160, 260, TimeUnit.MILLISECONDS);

	}

}
