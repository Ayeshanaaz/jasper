
// Join method is used to make current running thread wait till other threads are done completely. 

class SomeThread implements Runnable {

	public void run( ) {

		for(int i=1;i<=25;i++) {
			System.out.println(Thread.currentThread().getName()+" is running");			
		}
		
		System.out.println(Thread.currentThread().getName()+"is done with its task");
	}
}

public class ThreadJoinMethod {
		
	public static void main(String[  ] args) {
				
		SomeThread x = new SomeThread( );
		Thread thread1 = new Thread(x);
		Thread thread2 = new Thread(x);
		thread1.setName("Thread1");
		thread2.setName("Thread2");
		thread1.start(); 
		thread2.start();

   
		try {
			thread1.join();
			thread2.join();			
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		} 
		System.out.println("Thread1 is alive "+thread1.isAlive());
		System.out.println("Thread2 is alive "+thread2.isAlive());
		System.out.println("Back in main thread");
	}
}
