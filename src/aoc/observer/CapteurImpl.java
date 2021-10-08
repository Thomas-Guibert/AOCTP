package aoc.observer;

import java.util.List;

import aoc.strategy.AlgoDiffusion;
import aoc.strategy.DiffusionAtomique;
import aoc.strategy.DiffusionEpoque;
import aoc.strategy.DiffusionSequentielle;

public class CapteurImpl implements Capteur{
	/**
	 * Valeur du Capteur
	 */
	private int value;

	private boolean lock;
	
	AlgoDiffusion alg;

	/**
	 * List des Observer de Capteur qui observe ce Capteur
	 */
	private List<ObserverDeCapteur> listObserv;


	@Override
	public void attach(ObserverDeCapteur o) {
		listObserv.add(o);
	}

	/**
	 * Retourne la valeur du Capteur
	 */
	@Override
	public int getValue() {
		return value;
		//return alg.execute(value);
	}

	/**
	 * Fait passer la value du capteur a la valeur suivante
	 */
	//TODO : Appartir de la liste observer, verifier qu'il sont tous isDone avant de tick
	@Override
	public void tick() {
		if(!lock) {
			value++;
			lock =!lock;
		}
	}

	@Override
	public void detach(ObserverDeCapteur o) {
		listObserv.remove(o);
	}
	
	public void selectDiffusion(String s) {
		switch(s) {
		case "Atom" :
			alg = new DiffusionAtomique();
			break;
		case "Seq" :
			alg = new DiffusionSequentielle();
			break;
		case "Epo" :
			alg = new DiffusionEpoque();
			break;
		}
	}

}
