package aoc.observer;

public interface Capteur {
	public void attach(ObserverDeCapteur o);
	public int getValue();
	public void tick();
}
