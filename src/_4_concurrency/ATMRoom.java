package _4_concurrency;

import java.util.concurrent.Semaphore;

public class ATMRoom {

	public ATMRoom() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String []args) {
        // assume that only two ATM machines are available in the ATM room
        Semaphore machines = new Semaphore(2);
     
        // list of people waiting to access the machine
        new Person(machines, "Hugo");
        new Person(machines, "Paco");
        new Person(machines, "Luis");
	}

}

//Each Person is an independent thread; but their access to the common resource
//(two ATM machines in the ATM machine room in this case) needs to be synchronized.
class Person extends Thread {
     private Semaphore machines;
     public Person(Semaphore machines, String name) {
             this.machines = machines;
             this.setName(name);
             this.start();
     }
     public void run() {
             try {
                     System.out.println(getName() + " waiting to access an ATM machine");
                     machines.acquire();
                     System.out.println(getName() + " is accessing an ATM machine");
                     Thread.sleep(1000); // simulate the time required for withdrawing amount
                     System.out.println(getName() + " is done using the ATM machine");
                     machines.release();
             } catch(InterruptedException ie) {
                     System.err.println(ie);
             }
     }
}

