package fridge;

import java.util.concurrent.BlockingQueue;

/**
 * A mutable type representing a refrigerator containing drinks.
 */
public class DrinksFridge {

	private int drinksInFridge;
	private final BlockingQueue<FridgeRequest> in;
	private final BlockingQueue<FridgeResult> out;

	// Abstraction function:
	// AF(drinksInFridge, in, out) = a refrigerator containing `drinksInFridge`
	// drinks
	// that takes requests from `in` and sends replies to `out`
	// Rep invariant:
	// drinksInFridge >= 0
	private void checkRep() {
		assert drinksInFridge >= 0;
		assert in != null;
		assert out != null;
	}

	/**
	 * Make a DrinksFridge that will listen for requests and generate replies.
	 * constructor.
	 * 
	 * @param requests queue to receive requests from
	 * @param replies  queue to send replies to
	 */
	public DrinksFridge(BlockingQueue<FridgeRequest> requests, BlockingQueue<FridgeResult> replies) {
		this.drinksInFridge = 0;
		this.in = requests;
		this.out = replies;
		checkRep();
	}

	/**
	 * Start handling drink requests.
	 */
	public void start() {
		new Thread(new Runnable() {
			public void run() {
				// handle requests until we are interrupted
				while (!Thread.interrupted()) {
					try {
						// block until a request arrives
						FridgeRequest n = in.take();
						FridgeResult result = handleDrinkRequest(n);
						out.put(result);
					} catch (InterruptedException ie) {
						// stop
						break;
					}
				}
			}
		}).start();
	}

	/**
	 * Take (or add) drinks from the fridge.
	 * 
	 * @param n if >= 0, removes up to n drinks from the fridge; if < 0, adds -n
	 *          drinks to the fridge.
	 * @return FridgeResult reporting how many drinks were actually added or removed
	 *         and how many drinks are left in the fridge.
	 */
	private FridgeResult handleDrinkRequest(FridgeRequest n) {  // politely
		// adjust request to reflect actual drinks available
//		if (n.drinksRequested() < 0) {
			int change = Math.min(n.drinksRequested(), drinksInFridge);
			drinksInFridge -= change;
			checkRep();
			return new FridgeResult(change, drinksInFridge);
//		}
//		if (drinksInFridge > 1) {
//			drinksInFridge--;
//			checkRep();
//			return new FridgeResult(1, drinksInFridge);
//		}
//		return new FridgeResult(0, drinksInFridge);
	}
}