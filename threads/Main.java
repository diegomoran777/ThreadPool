package challenge.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
	
	static final int TRHEADS = 3;
	static final int JOBS_AMOUNT = 10;

	public static void main(String[] args) {
		
		ExecutorService pool = Executors.newFixedThreadPool(TRHEADS);
		
		IntStream.range(1, JOBS_AMOUNT).forEach(t -> {
				Runnable job = new Job(() -> "Procesando job: " + t, t);
				pool.execute(job);
		}); 
		
		pool.shutdown();  
        
		while (!pool.isTerminated()) {   }  
  
        System.out.println("Finished all threads");  
		
	}

}
