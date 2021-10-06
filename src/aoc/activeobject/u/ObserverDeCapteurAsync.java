package aoc.activeobject.u;

import aoc.activeobject.midle.Future;
import aoc.observer.Capteur;

public interface ObserverDeCapteurAsync {
	public Future update(Capteur c);
}
