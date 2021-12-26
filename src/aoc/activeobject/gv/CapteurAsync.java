package aoc.activeobject.gv;

import java.util.concurrent.Future;

import aoc.activeobject.u.ObserverDeCapteurAsync;

public interface CapteurAsync {
	public Future<Integer> getValue(ObserverDeCapteurAsync obs);
}
 