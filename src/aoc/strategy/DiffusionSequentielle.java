package aoc.strategy;

import aoc.observer.Capteur;
import aoc.observer.CapteurImpl;

public class DiffusionSequentielle implements AlgoDiffusion{
	
	private CapteurImpl capt;
	/*
	 * Certaine les valeur sont prise dans la diffusion Sequencielle mais tous on les meme
	 * [valeur impaire seulement]
	 */
	
	
	
	@Override
	public void configure(CapteurImpl c) {
		// TODO Auto-generated method stub
		this.capt=c;
	}

	@Override
	public void execute() {
		if(capt.getValue()%2 == 1) {
			capt.getAff().get(0).update(capt);
		}
	}

}
