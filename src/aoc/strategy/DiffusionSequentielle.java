package aoc.strategy;

import aoc.observer.Capteur;

public class DiffusionSequentielle implements AlgoDiffusion{
	private Capteur capt;
	/*
	 * Certaine les valeur sont prise dans la diffusion Sequencielle mais tous on les meme
	 * [valeur impaire seulement]
	 */
	
	
	
	@Override
	public void configure(Capteur c) {
		// TODO Auto-generated method stub
		this.capt=c;
	}

	@Override
	public void execute(int cap) {
		if(cap%2 == 1) {
			//Update
		}
	}

}
