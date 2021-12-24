package aoc.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import aoc.activeobject.u.ObserverDeCapteurAsync;
import aoc.observer.CapteurImpl;

public interface AlgoDiffusion {
	public void configure(CapteurImpl c, ArrayList<ObserverDeCapteurAsync> listObservAsync);
	public void execute() throws InterruptedException, ExecutionException;
	
}
 