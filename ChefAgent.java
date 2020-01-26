
public class ChefAgent {

	public static int sandwiches;
	
	public static void main(String args[]) {
		Table table = new Table();
		Agent bond = new Agent(table);
		Chef chef1 = new Chef(table, 0);
		Chef chef2 = new Chef(table, 1);
		Chef chef3 = new Chef(table, 2);
		
		Thread chef1Thread, chef2Thread, chef3Thread, bondThread;
		chef1Thread = new Thread(chef1,"Chef 1");
		chef2Thread = new Thread(chef2,"Chef 2");
		chef3Thread = new Thread(chef3,"Chef 3");
		bondThread = new Thread(bond,"Agent Bond"); // Shaken, not stirred.
		
		chef1Thread.start();
		chef2Thread.start();
		chef3Thread.start();
		bondThread.start();
	}
}
