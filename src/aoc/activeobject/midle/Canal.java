package aoc.activeobject.midle;

import java.util.concurrent.ScheduledExecutorService;

import aoc.activeobject.gv.CapteurAsync;
import aoc.activeobject.u.ObserverDeCapteurAsync;
import aoc.observer.Capteur;

public class Canal implements ObserverDeCapteurAsync , CapteurAsync{
	
	private ScheduledExecutorService s;
	
	//TODO
	@Override
	public Future update(Capteur c) {
		return null;
	}

	//TODO
	@Override
	public Future getValue() {
		return null;
	}
	
}
