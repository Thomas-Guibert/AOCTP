package aoc.activeobject.gv;

import java.util.concurrent.Future;

import aoc.activeobject.u.ObserverDeCapteurAsync;

/**
 * CapteurAsync du pattern active object, retourne la valeur de que contient l'observer de capteur lui aussi asynchrone sous la forme de Future
 * @author thomas
 *
 */
public interface CapteurAsync {
	public Future<Integer> getValue(ObserverDeCapteurAsync obs);
}
 