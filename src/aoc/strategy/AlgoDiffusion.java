package aoc.strategy;

import aoc.observer.Capteur;

public interface AlgoDiffusion {
	public void configure(Capteur c);
	public void execute(int cap);
}
