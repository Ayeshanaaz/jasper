
class Demon extends Thread {
	
	public void run() {
		 
		while(true) {
			System.out.println("JVM will kill me after all user threads goes into death state, till that time i will be executing");
		}				
	}	
}

public class DemonThread implements Runnable {

	public static void main(String[ ] args) {
		
		Demon d = new Demon( );
		d.setDaemon(true);
		d.setPriority(Thread.MIN_PRIORITY);
		
		Runnable threads = new DemonThread( );
		Thread thread1 = new Thread(threads, "Alpha");
		Thread thread2 = new Thread(threads, "Beta");
		
		System.out.println("Is 'd' demon thread ? "+ d.isDaemon());
					
		thread1.start();
		thread2.start();  
		d.start();
	}
	
	public void run( ) {

		for(int i=1 ; i<=5; i++) {
            
			System.out.println(Thread.currentThread().getName()+" "+i);
			
		}
		System.out.println(Thread.currentThread().getName()+"completed its task");
	}	
}
