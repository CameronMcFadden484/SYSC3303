
public class Chef implements Runnable {

	private Table table;
	private int infIngr;
	private boolean[] ingr = new boolean[3];
	private static int eaten = 0;

	public Chef(Table tab, int inf) {
		infIngr = inf;
		table = tab;
	}

	public synchronized void run() {
		while (true) {
			ingr = table.get(infIngr);
			ingr[infIngr] = true;
			eaten++;
			System.out.println(
					Thread.currentThread().getName() + " made and ate a sandwich. Total sandwiches eaten: " + eaten);
			notifyAll();
		}
	}
}
