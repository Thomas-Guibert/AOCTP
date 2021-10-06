package aoc.strategy;

import java.util.Random;

import aoc.observer.Capteur;

public class DiffusionEpoque implements AlgoDiffusion{

	/*
	 * Tout les Afficheur ne recoivent pas les meme valeur
	 * [Random a deux valeur]
	 */
	
	private Capteur capt;
	
	@Override
	public void configure(Capteur c) {
		this.capt=c;
	}

	@Override
	public void execute(int cap) {
		// TODO Auto-generated method stub
		if(getRandom()) {
			
		}
	}
	
	public boolean getRandom() {
		Random random = new Random();
		int nb = 0+random.nextInt(1-0);
		if(nb%2==0)
			return false;
		else
			return true;
	}
}
