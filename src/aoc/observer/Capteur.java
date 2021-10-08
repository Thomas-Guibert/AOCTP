package aoc.observer;

public interface Capteur {
	public void attach(ObserverDeCapteur o);
	public void detach(ObserverDeCapteur o);
	public int getValue();
	public void tick();
}
