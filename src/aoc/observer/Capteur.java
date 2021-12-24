package aoc.observer;

import java.util.concurrent.ExecutionException;

import aoc.activeobject.u.ObserverDeCapteurAsync;

public interface Capteur {
	public void attach(ObserverDeCapteur o);
	public void detach(ObserverDeCapteur o);
	public int getValue(ObserverDeCapteurAsync obs);
	public void tick() throws InterruptedException, ExecutionException;
}
