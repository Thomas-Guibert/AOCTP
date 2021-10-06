package aoc.strategy;

import aoc.observer.Capteur;

public class DiffusionAtomique implements AlgoDiffusion {

	/*
	 * Tout les valeur sont prise dans la diffusion Atomique
	 * [Toutes les valeur]
	 */
	
	private Capteur capt;
	
	@Override
	public void configure(Capteur c) {
		this.capt = c;
		
	}

	@Override
	public void execute(int cap) {
		// TODO Auto-generated method stub
		
	}

}
