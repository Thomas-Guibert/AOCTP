package aoc.strategy;

import java.util.Random;

import aoc.observer.Capteur;
import aoc.observer.CapteurImpl;

public class DiffusionEpoque implements AlgoDiffusion{

	/*
	 * Tout les Afficheur ne recoivent pas les meme valeur
	 * [Random a deux valeur]
	 */
	
	private CapteurImpl capt;
	
	@Override
	public void configure(CapteurImpl c) {
		this.capt=c;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if(getRandom()) {
			capt.getAff().get(0).update(capt);
		}
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
