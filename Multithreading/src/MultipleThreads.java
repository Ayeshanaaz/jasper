
public class MultipleThreads implements Runnable {
	
	public static void main(String[ ] args) {
        
		Runnable threads = new MultipleThreads( );
		Thread thread1 = new Thread(threads);
		Thread thread2 = new Thread(threads);
		
		thread1.setName("Alpha");
		thread2.setName("Beta");
		
		thread1.start();
		thread2.start();         
	}

	public void run( ) {

		for(int i=1 ; i<=500; i++) {            
			System.out.println(Thread.currentThread().getName()+" thread is running");			
		}
	}
}
