
public class Table {
	private static boolean[] ingr = new boolean[3]; // Represents ingredients currently on the table
	private int missingIngr = -1;
	
	public synchronized boolean[] get(int infIngr) {
		while (infIngr != missingIngr) { // If the chef checking is not the chef with the missing ingredient, wait.
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		
		
		clear(); // Take ingredients off the table and return so the chef can make a sandwich
		missingIngr = -1;
		return ingr;
	}
	
	public synchronized void set(boolean[] newIngr) {
		while (missingIngr != -1) { // While ingredients are still on the table, wait.
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		
		for (int i = 0; i < 3; i++) { // Find what ingredient is missing
			if(newIngr[i] == false) {
				missingIngr = i;
			}
		}
		
		ingr = newIngr;
		System.out.println("Table has been set with BREAD: " + ingr[0] + " PEANUTBUTTER: " + ingr[1] + " JAM: " + ingr[2]);
		notifyAll();
	}
	
	public void clear() {
		ingr[0] = false;
		ingr[1] = false;
		ingr[2] = false;
	}
}
