
class A { }

class B { }

class ThreadOneTask implements Runnable {

	A a;
	B b;	

	ThreadOneTask(A a,B b) {
		this.a = a;
		this.b = b;
	}

	 public void run( ) {

		synchronized(a) 
		{

			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace(); 
			}

			synchronized(b) 
			{
				System.out.println("Thread1 task complete");
			}
		}

	}
}

class ThreadTwoTask implements Runnable {

	A a;
	B b;

	ThreadTwoTask(A a,B b) {
		this.a = a;
		this.b = b;
	}

	public void run( ) {

		synchronized(b) 
		{

			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace(); 
			}

			synchronized(a) 
			{
				System.out.println("Thread2 task complete");
			}
		}
	}
}

public class ThreadDeadLock {

	public static void main(String[  ] args) {

		A a = new A( );
		B b = new B( );

		ThreadOneTask x = new ThreadOneTask(a,b);
		ThreadTwoTask y = new ThreadTwoTask(a,b);

		Thread t1 = new Thread(x);
		Thread t2 = new Thread(y);

		t1.start();
		t2.start();

	}
}
