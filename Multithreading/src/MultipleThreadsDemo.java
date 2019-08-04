
class Thread1Task extends Thread {
	
	@Override
	public void run( ) {
		
		for(int i=1;i<=1000;i++) {
			System.out.println("Thread1:"+i);
		}
	}	
}

class Thread2Task implements Runnable {

	@Override
	public void run() {
		for(int i=1;i<=1000;i++) {
			System.out.println("Thread2:"+i);
		}		
	}	
}

public class MultipleThreadsDemo {
		
	public static void main(String[  ] args) {
									
		Thread t2 = new Thread(new Thread2Task( ));
		t2.start();
		
		Thread t1 = new Thread(new Thread1Task( ));
		t1.start();
		System.out.println("Main thread completed");
	}
}
