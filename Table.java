
public class Table {
	private static boolean[] ingr = new boolean[3]; // Represents ingredients currently on the table

	public synchronized boolean[] get() {
		while (ingr[0] == false && ingr[1] == false && ingr[2] == false) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		return ingr;
	}
	
	public synchronized void set(boolean[] newIngr) {
		while (ingr[0] == true || ingr[1] == true || ingr[2] == true) {
			try {
				wait();
			} catch (InterruptedException e) {}
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
