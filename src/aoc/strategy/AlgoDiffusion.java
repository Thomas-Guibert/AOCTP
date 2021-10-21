package aoc.strategy;

import aoc.observer.Capteur;
import aoc.observer.CapteurImpl;

public interface AlgoDiffusion {
	public void configure(CapteurImpl c);
	public void execute();
	
}
 