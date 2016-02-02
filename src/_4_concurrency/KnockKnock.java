package _4_concurrency;

import java.util.concurrent.Exchanger;

public class KnockKnock {

	public KnockKnock() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Exchanger<String> sillyTalk = new Exchanger<String>();
        new CoffeeShopThread(sillyTalk).start();
        new DukeThread(sillyTalk).start();
	}
}

//The DukeThread class runs as an independent thread. It talks to the CoffeeShopThread that
//also runs independently. The chat is achieved by exchanging messages through a common
//Exchanger<String> object that synchronizes the chat between them.
//Note that the message printed are the "responses" received from CoffeeShopThread
class DukeThread extends Thread {
     private Exchanger<String> sillyTalk;
     
     public DukeThread(Exchanger<String> args) {
             sillyTalk = args;
     }
     public void run() {
             String reply = null;
             try {
                     // start the conversation with CoffeeShopThread
                     reply = sillyTalk.exchange("Knock knock!");
                     // Now, print the response received from CoffeeShopThread
                     System.out.println("CoffeeShop: " + reply);
                 
                     // exchange another set of messages
                     reply = sillyTalk.exchange("Duke");
                     // Now, print the response received from CoffeeShopThread
                     System.out.println("CoffeeShop: " + reply);

                     // an exchange could happen only when both send and receive happens
                     // since this is the last sentence to speak, we close the chat by
                     // ignoring the "dummy" reply
                     reply = sillyTalk.exchange("The one who was born in this coffee shop!");
                     // talk over, so ignore the reply!
             } catch(InterruptedException ie) {
                     System.err.println("Got interrupted during my silly talk");
             }
     }
}

class CoffeeShopThread extends Thread {
     private Exchanger<String> sillyTalk;
   
     public CoffeeShopThread(Exchanger<String> args) {
             sillyTalk = args;
     }
     public void run() {
             String reply = null;
             try {
                     // exchange the first messages
                     reply = sillyTalk.exchange("Who's there?");
                     // print what Duke said
                     System.out.println("Duke: " + reply);
                     // exchange second message
                     reply = sillyTalk.exchange("Duke who?");
                     // print what Duke said
                     System.out.println("Duke: " + reply);
                 
                     // there is no message to send, but to get a message from Duke thread,
                     // both ends should send a message; so send a "dummy" string
                     reply = sillyTalk.exchange("");
                     System.out.println("Duke: " + reply);
             } catch(InterruptedException ie) {
                     System.err.println("Got interrupted during my silly talk");
             }
     }
}

//The comments inside the program explain how the program works. The main concept to understand with this
//example is that Exchanger helps coordinate (i.e., synchronize) exchanging messages between two threads. Both the
//threads wait for each other and use the exchange() method to exchange messages.
