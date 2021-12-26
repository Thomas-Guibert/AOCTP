package aoc.strategy;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import aoc.activeobject.u.ObserverDeCapteurAsync;
import aoc.observer.Capteur;
import aoc.observer.CapteurImpl;

/**
 * Diffusion atomique : Tout les valeur sont prise dans la diffusion Atomique
 * @author thomas
 */
public class DiffusionAtomique implements AlgoDiffusion {

	private CapteurImpl capt;
	private ArrayList<ObserverDeCapteurAsync> obsAsync;

	@Override
	public void configure(CapteurImpl c, ArrayList<ObserverDeCapteurAsync> obsAsync) {
		this.capt = c;
		this.obsAsync = obsAsync;
	}

	/**
	 * Pas de blockage car tout les valeurs sont a prendre
	 */
	@Override
	public void execute() throws InterruptedException, ExecutionException {
		capt.setBlokageAlgo(false);
	}

}
