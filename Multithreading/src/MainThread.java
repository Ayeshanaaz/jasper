
public class MainThread {
	
	public static void main(String[  ] args) {
  
		Thread t = Thread.currentThread();
		//t.setName("main thread");
		
		System.out.println("Main thread name: "+ t.getName());
		System.out.println("Is Alive "+t.isAlive());		
	}
}

//A thread is a light weight sub process that has a separate path of execution.