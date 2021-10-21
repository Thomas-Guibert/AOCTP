package aoc.strategy;

import aoc.observer.Capteur;
import aoc.observer.CapteurImpl;

public class DiffusionAtomique implements AlgoDiffusion {

	/*
	 * Tout les valeur sont prise dans la diffusion Atomique
	 * [Toutes les valeur]
	 */
	
	private CapteurImpl capt;
	
	
	@Override
	public void configure(CapteurImpl c) {
		this.capt = c;
	}

	@Override
	public void execute() {
		//if()
		int val = capt.getValue();
		
		capt.getAff().get(0).update(capt);
		//Update
	}

}
