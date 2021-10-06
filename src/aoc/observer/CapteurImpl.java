package aoc.observer;

import java.util.List;

public class CapteurImpl implements Capteur{
	/**
	 * Valeur du Capteur
	 */
	private int value;
	
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
	}

	/**
	 * Fait passer la value du capteur a la valeur suivante
	 */
	//TODO : Appartir de la liste observer, verifier qu'il sont tous isDone avant de tick
	@Override
	public void tick() {
		value++;
	}

}
