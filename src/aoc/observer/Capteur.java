package aoc.observer;

import aoc.activeobject.u.ObserverDeCapteurAsync;

public interface Capteur {
	public void attach(Afficheur o);
	public void detach(ObserverDeCapteur o);
	public int getValue();
	public void tick();
}
