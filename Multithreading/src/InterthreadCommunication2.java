
class Number {

	int limit = 20;	
	boolean isOddFirst = false;

	synchronized void produceEven( ) {

		if(isOddFirst == false) {
			try {
				wait( );
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}

		for(int i=2;i<=limit;i = i+2) { 
			System.out.println("Even:" + i);
			notify( );
			try {				
				wait(3000); 				
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}		
	}

	synchronized void produceOdd( )  {
		
		isOddFirst = true;
		
		for(int i=1;i<=limit;i = i+2) { 
			System.out.println("Odd: "+ i);
			notify( );
			try {							
				wait(3000);				
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}	
	}
}

class ProduceEven implements Runnable {

	Number number;

	ProduceEven(Number n) {

		number = n;
	}

	public void run( ) {
		number.produceEven();		
	}
}

class ProduceOdd implements Runnable {

	Number number;

	ProduceOdd(Number n) {

		number = n;
	}

	public void run( ) {

		number.produceOdd();
	}
}

public class InterthreadCommunication2 {

	public static void main(String[ ] args) {

		Number number = new Number( );
		Thread produceEven = new Thread(new ProduceEven(number));
		Thread produceOdd = new Thread(new ProduceOdd(number));

		produceEven.start();
		produceOdd.start();
	}
}
