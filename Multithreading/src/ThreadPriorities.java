 /*
Note: Don't rely on thread priorities when designing your multithreaded 
application. Because thread-scheduling priority behavior is not guaranteed, 
use thread priorities as a way to improve the efficiency of your program, 
but just be sure your program doesn't depend on that behavior for correctness.
*/

class Task implements Runnable {
			
	@Override
	public void run() {
											
		for(long count =1; count<=100000L; count++) { 			
			System.out.println(Thread.currentThread().getName()+" count is: "+count);
		}
		
		System.out.println("Completed thread: "+Thread.currentThread().getName()+" its priority is "+Thread.currentThread().getPriority());				
	}	
}

public class ThreadPriorities {

	public static void main(String[  ] args) {
		
        Task task = new Task( );
        Thread t1 = new Thread(task,"Thread1");        
        Thread t2 = new Thread(task, "Thread2");
        Thread t3 = new Thread(task, "Thread3");
                        
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(5);        
        t3.setPriority(Thread.MAX_PRIORITY);      
                            
        t1.start();
        t2.start();
        t3.start();
        
        System.out.println("main completed");
	}
}
