package aoc.observer;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import aoc.activeobject.midle.Canal;
import aoc.activeobject.u.ObserverDeCapteurAsync;

public class Afficheur implements ObserverDeCapteurAsync{

	private String name;
	private Canal canal;
	private ArrayList<Integer> listInt;

	public Afficheur(Canal canal, String name) {
		listInt = new ArrayList<Integer>();
		this.name=name;
		this.canal = canal;
	}

	/**
	 * Fonction de mise a joue de l'afficheur, ajoute la valeur du capteur dans la liste 
	 */
	@Override
	public Void update(Capteur s) throws InterruptedException, ExecutionException {
		listInt.add(this.canal.getValue(this).get());
		return null;
	}

	/**
	 * Fonction d'affichage de l'afficheur 
	 * @return String le contenu de l'afficheur 
	 */
	public String show() {
		String res = name + " :";
		if(!listInt.isEmpty()) {
			res += " " + listInt.get(0);
			for(int i=1;i<listInt.size();i++) {
				res += ", " + listInt.get(i);
			}
		}
		return res;
	}

}
