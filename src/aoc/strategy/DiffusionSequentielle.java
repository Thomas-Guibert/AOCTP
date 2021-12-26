package aoc.strategy;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import aoc.activeobject.u.ObserverDeCapteurAsync;
import aoc.observer.Capteur;
import aoc.observer.CapteurImpl;

public class DiffusionSequentielle implements AlgoDiffusion{


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
		if(capt.verificationValue()%2==0) {
			capt.setBlokageAlgo(true);
		}else {
			capt.setBlokageAlgo(false);
		}
	}

}
