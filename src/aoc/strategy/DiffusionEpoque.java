package aoc.strategy;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import aoc.activeobject.u.ObserverDeCapteurAsync;
import aoc.observer.Capteur;
import aoc.observer.CapteurImpl;

public class DiffusionEpoque implements AlgoDiffusion{

	/*
	 * Tout les Afficheur ne recoivent pas les meme valeur
	 * [Random a deux valeur]
	 */
	private CapteurImpl capt;

	private ArrayList<ObserverDeCapteurAsync> obsAsync;
	@Override
	public void configure(CapteurImpl c,ArrayList<ObserverDeCapteurAsync> obsAsync) {
		this.capt=c;
		this.obsAsync = obsAsync;
	}

	@Override
	public void execute() throws InterruptedException, ExecutionException {
		capt.setBlokageAlgo(getRandom());

	}

	public boolean getRandom() {
		Random random = new Random();
		int nb = 0+random.nextInt(2-0);
		if(nb%2==0)
			return false;
		else
			return true;
	}
}
