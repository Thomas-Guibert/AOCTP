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
	 * parametre du Capteur
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

	/**
	 * attache un ObserverDeCapteur à ce capteur
	 */
	@Override
	public void attach(ObserverDeCapteur o) {
		listObserv.add(o);
	}

	/**
	 * detach un ObserverDeCapteur à ce capteur
	 */
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
	}

	/**
	 * Fonction qui permet au pattern stategy de recupere la valeur et de faire un choix en fonction de celle-ci
	 * @return Retourne la prochaine valeur que le capteur va transmettre
	 */
	public int verificationValue() {
		return value;
	}

	/**
	 * Fait passer la value du capteur a la valeur suivante
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
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
	/**
	 * Permet de bloquer l'ajoute de la valeur a l'afficheur
	 * @param setBloquage boolean : true pour blockage activer et inversement false pour desactiver le blockage
	 */
	public void setBlokageAlgo(boolean setBloquage) {
		algoBloque=setBloquage;
	}

	/**
	 * retourne la liste des afficheur
	 * @return liste des afficheurs
	 */
	public ArrayList<Afficheur> getAff(){
		return listAff; 
	}

	/**
	 * @return la strategy selectionner
	 */
	public AlgoDiffusion getStrategy() {
		return strategy;
	}

	/**
	 * configure la strategy
	 * @param stra la stategy choisi
	 */
	public void setStrategy(AlgoDiffusion stra) {
		this.strategy = stra ;
		this.strategy.configure(this, getObserver());
	}

	/**
	 * @return la liste des ObserverAsync
	 */
	public ArrayList<ObserverDeCapteurAsync> getObserver() {
		return (ArrayList<ObserverDeCapteurAsync>) listObservAsync;
	}

	/**
	 * Permet de choisi la strategy grace a la premiere lettre de celui-ci 
	 * -A pour atomique, S pour sequentielle et E pour epoque
	 * L'algo par default est Atomique
	 * @param s la lettre choisi par l'utilisateur
	 * @return la stategy de diffusion assosier a la lettre
	 */
	public AlgoDiffusion sDiff(String s) {
		switch(s) {
		case "A" :
			return new DiffusionAtomique();
		case "S" :
			return new DiffusionSequentielle();
		case "E" :
			return new DiffusionEpoque();
		default :
			return new DiffusionAtomique();
		}
	}

}
