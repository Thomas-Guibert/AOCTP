package aoc.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import aoc.activeobject.midle.Canal;
import aoc.activeobject.u.ObserverDeCapteurAsync;

public class Afficheur implements ObserverDeCapteurAsync{

	private String name;
	private Canal canal;
	private ArrayList<Integer> listInt;
	
	public Afficheur(String name) {
		listInt = new ArrayList<Integer>();
		this.name=name;
	}
	@Override
	public Void update(Capteur s) {
		listInt.add(s.getValue());
		//Unlock Capteur
		show();
		return null;
	}
	
	public void show() {
		String res = name + " :";
        for(int i=0;i<listInt.size();i++) {
        	res += " " + listInt.get(i) + ",";
        }
        System.out.println(res);
	}
	
}
