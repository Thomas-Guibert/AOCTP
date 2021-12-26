package aoc.strategy;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import aoc.activeobject.u.ObserverDeCapteurAsync;
import aoc.observer.Capteur;
import aoc.observer.CapteurImpl;

/**
 * Diffusion sementique : Seulement une partie des valeur sont prise dans la diffusion Sementique, dans notre cas ce sont les valeur impaires
 * @author thomas
 */
public class DiffusionSequentielle implements AlgoDiffusion{

	private CapteurImpl capt;
	private ArrayList<ObserverDeCapteurAsync> obsAsync;


	@Override
	public void configure(CapteurImpl c, ArrayList<ObserverDeCapteurAsync> obsAsync) {
		this.capt = c;
		this.obsAsync = obsAsync;
	}

	/**
	 * Blockage de la valeur pour que seul les valeur impaire soit prise par l'afficheur
	 */
	@Override
	public void execute() throws InterruptedException, ExecutionException {
		if(capt.verificationValue()%2==0) {
			capt.setBlokageAlgo(true);
		}else {
			capt.setBlokageAlgo(false);
		}
	}

}
