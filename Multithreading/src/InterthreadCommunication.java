
class Factory {

	private int stock;
	boolean produceStock = true;

	synchronized void produce( ) {

		while(produceStock) {

			if(stock == 0) {			
				stock = stock + 2000;
				System.out.println("Stock produced");
			    notify();				
			}
			else {
				try {
					wait( );					
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			}					
		}
	}

	synchronized void consume( ) {

		while(produceStock) {

			if(stock > 0) {				
				stock = stock - 2000;
				System.out.println("Stock consumed");			
				notify();
				//InterthreadCommunication.producer.interrupt( );
			}
			else {
				try {
					wait();					
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			}	
		}
	}
}

class Producer implements Runnable {

	Factory factory;

	Producer(Factory f) {

		factory = f;
	}

	public void run( ) {

		factory.produce();

	}
}

class Consumer implements Runnable {

	Factory factory;

	Consumer(Factory f) {

		factory = f;
	}

	public void run( ) {

		factory.consume();

	}
}

public class InterthreadCommunication {
	
	static Thread producer;
	static Thread consumer;
		
	public static void main(String[ ] args) {

		Factory factory = new Factory( );
		producer = new Thread(new Producer(factory));
		consumer = new Thread(new Consumer(factory));

		producer.start();
		consumer.start();
		
		//Give some time to produce and consume the stock.  
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Now stop production and consumption by terminating both the threads. Don't use 'stop' method its deprecated. 
        factory.produceStock = false;
	}
}
