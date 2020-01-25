import java.util.Random;

public class Agent implements Runnable {
	Random rand = new Random();
	private Table table;
	
	public Agent(Table tab) {
		 table = tab;
	}
	
	
	
	public void run() {

			boolean[] newIngr;
			
			// Set the table twenty times
			for (int i = 0; i < 20; i++) {
				newIngr = new boolean[3];

				// generate random integer between 0 (inclusive) and 3 (exclusive)
				int num = rand.nextInt(3);

				switch (num) {
				case 0:
					newIngr[0] = true;  // PUT bread on the table
					newIngr[1] = true;  // PUT peanut butter on the table
					newIngr[2] = false; // DON'T PUT jam on the table
					break;
				case 1:
					newIngr[0] = true;  // PUT bread on the table
					newIngr[1] = false; // DON'T PUT peanut butter on the table
					newIngr[2] = true;  // PUT jam on the table
					break;
				case 2:
					newIngr[0] = false; // DON'T PUT bread on the table
					newIngr[1] = true;  // PUT peanut butter on the table
					newIngr[2] = true;  // PUT jam on the table
					break;
				}

				table.set(newIngr);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
			}
		}
	}
