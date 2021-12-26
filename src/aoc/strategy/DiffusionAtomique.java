package aoc.strategy;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import aoc.activeobject.u.ObserverDeCapteurAsync;
import aoc.observer.Capteur;
import aoc.observer.CapteurImpl;

public class DiffusionAtomique implements AlgoDiffusion {

	/*
	 * Tout les valeur sont prise dans la diffusion Atomique
	 * [Toutes les valeur]
	 */
	private CapteurImpl capt;

	private ArrayList<ObserverDeCapteurAsync> obsAsync;


	@Override
	public void configure(CapteurImpl c, ArrayList<ObserverDeCapteurAsync> obsAsync) {
		this.capt = c;
		this.obsAsync = obsAsync;
	}

	@Override
	public void execute() throws InterruptedException, ExecutionException {
		capt.setBlokageAlgo(false);
	}

}
