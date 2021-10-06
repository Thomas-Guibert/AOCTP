package aoc.activeobject;

public interface Capteur {
	public void attach(ObserverDeCapteur o);
	public int getValue();
	public void tick();
}
