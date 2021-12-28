package aoc.activeobject.midle;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import aoc.activeobject.gv.CapteurAsync;
import aoc.activeobject.u.ObserverDeCapteurAsync;
import aoc.observer.Afficheur;
import aoc.observer.Capteur;
import aoc.observer.ObserverDeCapteur;

/**
 * Canal 
 * @author thomas
 *
 */
public class Canal implements ObserverDeCapteur, CapteurAsync{

	Capteur capteur;
	Afficheur afficheur;
	ObserverDeCapteurAsync obsCapteur;
	ScheduledExecutorService execService;

	public Canal(Capteur capteur, ScheduledExecutorService execService){
		this.capteur = capteur;
		this.execService = execService;
	}

	/**
	 * Implementation de update de l'interface ObserverDeCapteur qui mette a jour l'afficheur
	 */
	@Override
	public Void update(Capteur c) {
		execService.schedule(new Callable<Void> () {
			public Void call() throws InterruptedException, ExecutionException {
				return afficheur.update(c);
			}
		}, 50, TimeUnit.MILLISECONDS);
		return null;
	}

	/**
	 * Implementation de getValue de l'interface CapteurAsync qui retourne la valeur du capteur
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Future<Integer> getValue(ObserverDeCapteurAsync obs) {
		return this.execService.schedule(new Callable<Integer>() {
			public Integer call(){
				return capteur.getValue(obs);
			}
		}, 50, TimeUnit.MILLISECONDS);
	}

	/**
	 * 
	 * @param aff : L'afficheur a associer au canal
	 */
	public void setAfficheur(Afficheur aff) {
		this.afficheur = aff;
	}

	/**
	 * Affiche dans un print l'afficheur
	 */
	public void showAfficheur() {
		System.out.println(afficheur.show());
	}

	/**
	 * Retour l'afficheur sous forme d'un string
	 * @return la valeur de l'afficheur
	 */
	public String getAfficheur() {
		return afficheur.show().substring(afficheur.show().indexOf(":")+1, afficheur.show().length());
	}
}
