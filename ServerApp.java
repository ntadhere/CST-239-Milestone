/**
 * Truong Anh Dao Nguyen
 * CST-239
 * 12/10/2023
 * This is my own work
 */
package server;

/**
 * ServerApp class for Milestone 6
 */
public class ServerApp
{

	/**
	 * Main method
	 * @param args (unnecessary)
	 * @throws InterruptedException thrown if the thread is interrupted
	 */
	public static void main(String[] args) throws InterruptedException
	{
		// Start message
		System.out.println("Runnning Server App");
		
		// Create a server thread instance and start it
		ServerThread thread = new ServerThread();
		
		// Loop while thread is running by printing a dot (.) to the console and sleep for 1 second
		// This is to show that the server is running in the background
		while(thread.isAlive())
		{
			// Print a dot to be console and then put this thread to sleep for 1 second
			System.out.println(".");
			Thread.sleep(1000);
		}
	}

}
