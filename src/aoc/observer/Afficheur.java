package aoc.observer;

import java.util.List;

public class Afficheur implements ObserverDeCapteur{

	private List<Integer> listInt;
	
	@Override
	public void update(Capteur s) {
		listInt.add(s.getValue());
		//Unlock Capteur
	}
	
}
