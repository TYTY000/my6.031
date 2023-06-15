package fridge;

interface FridgeRequest { // pure interface
	boolean shouldStop();

	public int drinksRequested();
}

class DrinkRequest implements FridgeRequest {
	// some fields and methods
	private int n;

	public DrinkRequest(int i) { // constructor
		// TODO Auto-generated constructor stub
		n = i;
	}

	public int drinksRequested() { // getter
		return n;
	}

	public boolean shouldStop() {  // getter
		return false; // do not stop
	}

	@Override
	public String toString() {
		return "DrinkRequest(" + n + ")";
	}
}

class StopRequest implements FridgeRequest {
	// some fields and methods
	public int drinksRequested() {
		return 0; // no drinks requested
	}

	public boolean shouldStop() {
		return true; // stop
	}
}
