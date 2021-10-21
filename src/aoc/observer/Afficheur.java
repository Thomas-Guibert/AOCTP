package aoc.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import aoc.activeobject.midle.Canal;
import aoc.activeobject.u.ObserverDeCapteurAsync;

public class Afficheur implements ObserverDeCapteurAsync{

	private Canal canal;
	private ArrayList<Integer> listInt;
	
	@Override
	public Future<Void> update(Capteur s) {
		listInt.add(s.getValue());
		//Unlock Capteur
		return null;
	}
	
}
