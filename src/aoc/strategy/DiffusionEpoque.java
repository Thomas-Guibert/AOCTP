package aoc.strategy;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import aoc.activeobject.u.ObserverDeCapteurAsync;
import aoc.observer.Capteur;
import aoc.observer.CapteurImpl;

/**
 * Diffusion Epoque : Dans la diffusion par epoque les valeur sont selectionner aléatoirement et sont donc differente entre les Afficheurs
 * @author thomas
 */
public class DiffusionEpoque implements AlgoDiffusion{

	private CapteurImpl capt;
	private ArrayList<ObserverDeCapteurAsync> obsAsync;
	
	@Override
	public void configure(CapteurImpl c,ArrayList<ObserverDeCapteurAsync> obsAsync) {
		this.capt=c;
		this.obsAsync = obsAsync;
	}

	/**
	 * Block aléatoirement le capteur grace a la fonction Auxilaire
	 */
	@Override
	public void execute() throws InterruptedException, ExecutionException {
		capt.setBlokageAlgo(getRandom());

	}

	/**
	 * Fonction auxilaire pour generer un boolean aléatoirement
	 * @return
	 */
	public boolean getRandom() {
		Random random = new Random();
		int nb = 0+random.nextInt(2-0);
		if(nb%2==0)
			return false;
		else
			return true;
	}
}
