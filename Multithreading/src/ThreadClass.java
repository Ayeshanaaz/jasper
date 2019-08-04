
class ThreadWork extends Thread {

	@Override //run method defines the task for the thread
	public void run( ) {								
		for(int i=1;i<=1000;i++) {
			System.out.println("My thread");
		}
	}	
}

public class ThreadClass {

	public static void main(String[ ] args) {

		ThreadWork myThread = new ThreadWork( );
		myThread.setName("myThread");
		myThread.start();
								
		for(int i=1;i<=1000;i++) {
			System.out.println("main thread");
		}
	}			
}
