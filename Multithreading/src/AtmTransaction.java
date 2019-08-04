
/*These rules are very important. If you don't understand them you may not understand this program.  

1. If more than 1 thread modify the same object simultaneously there are chances that data can be corrupted.

2. Every object has only 1 lock and key.

3. If a thread wants to execute a synchronized method it has to lock the currently executing object and put the 
key with him, to prevent other threads from accessing the synchronized method till it finishes the work (Keep 
in mind that other threads can still access the synchronized method by using objects which are not locked and 
this does not create any problem because two threads are modifying different objects. The problem arises only 
when 2 threads modify the same object).

4. If an object is already locked by some thread, other threads cannot access a synchronized method with that 
locked object till the lock and key is released by the thread which locked the object. 
 */

class BankAccount {

	private float balance = 10_000F;	

	public float getBalance() {
		return balance;
	}
		
	synchronized void withDraw(float amount) {
				
		//Check balance is available or not
		if(getBalance()>=amount) {

			//Give some time for atm to count and dispense the cash   
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
						
			//Debit the account after giving the cash
			balance = balance - amount;				
			System.out.println(Thread.currentThread().getName()+ " with drawn "+amount+" rupees"+" and current balance in account is "+ getBalance());
		}
		else {
			System.out.println("Insufficient funds "+Thread.currentThread().getName()+" cannot with draw");
		}				
	}
}

public class AtmTransaction implements Runnable {

	BankAccount account = new BankAccount( );

	public static void main(String[ ] args) {

		AtmTransaction x = new AtmTransaction( );

		Thread person1 = new Thread(x);
		person1.setName("person1");
		Thread person2 = new Thread(x);
		person2.setName("person2");

		person1.start();		
		person2.start();
	}

	public void run( ) {

		account.withDraw(10_000);
		
		if(account.getBalance()<0) {
			System.out.println("Account overdrawn! balance went to negative");			
		}						
	}	 
}
