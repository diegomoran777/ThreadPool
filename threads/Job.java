package challenge.threads;

public class Job implements Runnable{
	
	private int time;
	private String jobProcess;
	
	public Job(IJob job, int time) {
		this.jobProcess = job.processJob();
		this.time = time;
	}
	
	private void waitingProcess(int time) {
		
		try {
			Thread.sleep(time * 1000);
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
	}

	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName() + " (Start) " + jobProcess);  
		
		waitingProcess(time);  
        
		System.out.println(Thread.currentThread().getName() + " (End) " + jobProcess);
		
	}
}
