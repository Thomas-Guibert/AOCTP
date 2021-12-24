package aoc.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

import aoc.activeobject.u.ObserverDeCapteurAsync;
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

	private boolean algoBloque;


	/**
	 * List des Observer de Capteur qui observe ce Capteur
	 */
	private List<ObserverDeCapteur> listObserv;

	private List<ObserverDeCapteurAsync> listObservAsync;

	private ArrayList<Afficheur> listAff;


	public CapteurImpl (String algo) {
		value = 0;
		algoBloque=false;
		//listAff = new ArrayList<Afficheur>();
		listObserv = new ArrayList<ObserverDeCapteur>();
		listObservAsync = new ArrayList<ObserverDeCapteurAsync>();
		setStrategy(sDiff(algo));
	}


	@Override
	public void attach(ObserverDeCapteur o) {
		listObserv.add(o);
	}

	@Override
	public void detach(ObserverDeCapteur o) {
		listObserv.remove(o);
	}

	/**
	 * Retourne la valeur du Capteur
	 */
	@Override
	public int getValue(ObserverDeCapteurAsync obs) {
		listObservAsync.remove(obs);
		return value;
		//return alg.execute(value);
	}

	public int verificationValue() {
		return value;
	}

	/**
	 * Fait passer la value du capteur a la valeur suivante
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	//TODO : Appartir de la liste observer, verifier qu'il sont tous isDone avant de tick
	@Override
	public void tick() throws InterruptedException, ExecutionException {
		value++;
		for(int i = 0; i<listObserv.size();i++) {
			strategy.execute();
			if(!algoBloque) {
				listObserv.get(i).update(this);
			}
			
		}
	}

	public void setBlokageAlgo(boolean setBloquage) {
		algoBloque=setBloquage;
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
		this.strategy.configure(this, getObserver());
	}

	public ArrayList<ObserverDeCapteurAsync> getObserver() {
		return (ArrayList<ObserverDeCapteurAsync>) listObservAsync;
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
