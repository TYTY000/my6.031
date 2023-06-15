package fridge;

import java.io.IOException;
import java.util.concurrent.*;

public class lesson23 {
//    private static final int QUEUE_SIZE = 100;
//    private static final FridgeRequest N = new DrinkRequest(100);
//    
//    /**  Send N thirsty people to the DrinksFridge. */
    public static void main(String[] args) throws IOException {
        // make request and reply queues big enough to hold QUEUE_SIZE messages each
        BlockingQueue<FridgeRequest> requests = new LinkedBlockingQueue<>();
        BlockingQueue<FridgeResult> replies = new LinkedBlockingQueue<>();
        
        DrinksFridge fridge = new DrinksFridge(requests, replies);
        fridge.start();
//		DrinksFridge fridge2 = new DrinksFridge(requests, replies);
//		fridge2.start(); // race condition
        try {
//			// deliver some drinks to the fridge
//			requests.put(new DrinkRequest(-2));
//			// maybe do something concurrently...
//
//			// read the reply
//			System.out.println(replies.take());
			
            // put enough drinks in the fridge to start
            requests.put(new DrinkRequest(-2));
            System.out.println(replies.take());
            
            // send the requests
            for (int x = 1; x <= 3; ++x) {
                requests.put(new DrinkRequest(1)); // give me 1 drink!
                System.out.println("person #" + x + " is looking for a drink");
            }
            // collect the replies
            for (int x = 1; x <= 3; ++x) {
                System.out.println("person #" + x + ": " + replies.take());
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println("done");
        System.exit(0); // ends the program, including DrinksFridge thread
    }
}
