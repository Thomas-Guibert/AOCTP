package aoc.activeobject.midle;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import aoc.activeobject.gv.CapteurAsync;
import aoc.activeobject.u.ObserverDeCapteurAsync;
import aoc.observer.Afficheur;
import aoc.observer.Capteur;

public class Canal implements ObserverDeCapteurAsync , CapteurAsync{
	
	Capteur capteur;
	Afficheur afficheur;
	ObserverDeCapteurAsync obsCapteur;
	ScheduledExecutorService execService;
	
	Canal(Capteur capteur, ScheduledExecutorService execService){
		this.capteur = capteur;
		this.execService = execService;
	}
	
	@Override
	public Future<Void> update(Capteur c) {
		execService.schedule(new Callable<Void> () {
		//MethodInvocation fonction for Update
		public Future<Void> call() throws InterruptedException, ExecutionException {
			return afficheur.update(c);
		}
	}, 50, TimeUnit.MILLISECONDS);
    return null;
}

	@SuppressWarnings("unchecked")
	@Override
	public Future<Integer> getValue() {
		return (Future<Integer>) execService.schedule(new Callable<Integer>() {
            public Integer call(){
                return capteur.getValue();
            }
        }, 50, TimeUnit.MILLISECONDS);
    }
	
}
