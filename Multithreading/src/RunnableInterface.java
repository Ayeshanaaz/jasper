
class ThreadTask implements Runnable {

   @Override
   public void run( ) {	   	  
		for(int i=1;i<=10000;i++) {
			System.out.println("My thread");
		}
   }        
}

public class RunnableInterface {
	
	public static void main(String[  ] args) {
	        
		ThreadTask task = new ThreadTask();		
		
	    Thread myThread = new Thread(task);	    
	    myThread.start(); 
	    
	    for(int i=1;i<=10000;i++) {
			System.out.println("main thread");
		}
	}				
}
