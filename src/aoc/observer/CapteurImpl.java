package aoc.observer;

public class CapteurImpl implements Capteur{
	/**
	 * Valeur du Capteur
	 */
	private int value;
	
	@Override
	public void attach(ObserverDeCapteur o) {
		
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
	@Override
	public void tick() {
		value++;
	}

}
