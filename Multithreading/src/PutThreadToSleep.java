
class OtherThread extends Thread {

	@Override
	public void run( ) {

		System.out.println("Other thread is running");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
			System.out.println("Other thread interrupted when sleeping");
		}
		System.out.println("Other thread completed its work");
	}		
}

public class PutThreadToSleep {
	
	public static void main(String[  ] args)  {
				
		OtherThread x = new OtherThread( );
		x.setName("other thread");
		x.start();					
		//x.interrupt();

		System.out.println("Main thread completed its work");
	}
}
