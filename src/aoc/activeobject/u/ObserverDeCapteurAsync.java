package aoc.activeobject.u;

import java.util.concurrent.Future;

import aoc.observer.Capteur;

public interface ObserverDeCapteurAsync {
	public Void update(Capteur c);
}
