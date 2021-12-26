package aoc.test;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import aoc.activeobject.midle.Canal;
import aoc.activeobject.u.ObserverDeCapteurAsync;
import aoc.observer.Afficheur;
import aoc.observer.CapteurImpl;

/**
 * Class de test pour le TP d'AOC
 * Dans ce test, 4 canaux sont utiliser pour montrer le bon fonctionnement des patterns
 * @author thomas
 *
 */
public class main {

	public static void main(String[] args) {

		//##################################################################
		//Choix du test a effectuer
		//##################################################################
		/**Le choix de la stategy ce fait ici :
		- A : Diffusion Atomique
		- S : Diffusion Sequentielle
		- E : DIffusion par Epoque
		 */
		String diffusionChoisi = "A";


		//##################################################################
		//Mise en place du test
		//##################################################################
		/**
		 * Creation d'un Capteur avec la diffusion choisi
		 */
		CapteurImpl capteur = new CapteurImpl(diffusionChoisi);

		/**
		 * Initialisation d'un pool de thread, dans notre cas c'est un pool de 12 thread
		 */
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(12);

		/**
		 * Creation des 4 cannaux 
		 */
		Canal canal1 = new Canal(capteur,scheduledExecutorService );
		Canal canal2 = new Canal(capteur,scheduledExecutorService );
		Canal canal3 = new Canal(capteur,scheduledExecutorService );
		Canal canal4 = new Canal(capteur,scheduledExecutorService );

		/**
		 * Creation des 4 Afficheur
		 */
		Afficheur affiche1 = new Afficheur(canal1, "Afficheur 1");
		Afficheur affiche2 = new Afficheur(canal2, "Afficheur 2");
		Afficheur affiche3 = new Afficheur(canal3, "Afficheur 3");
		Afficheur affiche4 = new Afficheur(canal4, "Afficheur 4");

		/**
		 * Attache les quatre cannaux au capteur
		 */
		capteur.attach(canal1);
		capteur.attach(canal2);
		capteur.attach(canal3);
		capteur.attach(canal4);
		
		/**
		 * Attache les 4 canaux a leurs afficheur
		 */
		canal1.setAfficheur(affiche1);
		canal2.setAfficheur(affiche2);
		canal3.setAfficheur(affiche3);
		canal4.setAfficheur(affiche4);

		/**
		 * Execution du Scheduler
		 */
		scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
			public void run() {
				try {
					capteur.tick();
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
