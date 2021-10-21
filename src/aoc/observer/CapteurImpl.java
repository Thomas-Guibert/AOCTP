package aoc.observer;

import java.util.ArrayList;
import java.util.List;

import aoc.strategy.AlgoDiffusion;
import aoc.strategy.DiffusionAtomique;
import aoc.strategy.DiffusionEpoque;
import aoc.strategy.DiffusionSequentielle;

public class CapteurImpl implements Capteur{
	/**
	 * Valeur du Capteur
	 */
	private int value;

	private boolean lock;
	
	private AlgoDiffusion strategy;
	


	/**
	 * List des Observer de Capteur qui observe ce Capteur
	 */
	private List<ObserverDeCapteur> listObserv;

	private ArrayList<Afficheur> listAff;
	//public void attach(ObserverDeCapteur o) 
	//listObserv.add(o);
	//}
	
	public CapteurImpl () {
		listAff = new ArrayList<Afficheur>();
	}
	
	
	@Override
	public void attach(Afficheur o) {
		listAff.add(o);
	}

	/**
	 * Retourne la valeur du Capteur
	 */
	@Override
	public int getValue() {
		return value;
		//return alg.execute(value);
	}

	/**
	 * Fait passer la value du capteur a la valeur suivante
	 */
	//TODO : Appartir de la liste observer, verifier qu'il sont tous isDone avant de tick
	@Override
	public void tick() {
		value++;
		strategy.execute();
		//if(!lock) {
			
			//lock =!lock;
		//}
	}

	@Override
	public void detach(ObserverDeCapteur o) {
		listObserv.remove(o);
	}
	
	public ArrayList<Afficheur> getAff(){
		return listAff; 
	}
	
	/////////////////////////////////////////////////////////////////
	///////////////////////////  Lock //////////////////////////
	/////////////////////////////////////////////////////////////////
	
	public boolean isLock() {
		if(lock) return true; else return false;
	}
	
	public void locked() { lock=true;}
	
	public void unlocked() { lock=false;}
	
	
	/////////////////////////////////////////////////////////////////
	///////////////////////////  Strategy  //////////////////////////
	/////////////////////////////////////////////////////////////////
	
	public AlgoDiffusion getStrategy() {
		return strategy;
	}
	
	public void setStrategy(AlgoDiffusion stra) {
		this.strategy = stra ;
		this.strategy.configure(this);
	}

	
	public AlgoDiffusion sDiff(String s) {
		switch(s) {
		case "A" :
			return new DiffusionAtomique();
		case "S" :
			return new DiffusionSequentielle();
		case "E" :
			return new DiffusionEpoque();
		}
		return null;
	}

}
