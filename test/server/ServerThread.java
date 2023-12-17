/**
 * Truong Anh Dao Nguyen
 * CST-239
 * 12/10/2023
 * This is my own work
 */
package server;

import java.io.IOException;

/**
 * ServerThread class for Milestone 6
 */
public class ServerThread extends Thread
{
	/**
	 * Run method to override the one in the Thread class
	 */
	@Override
	public void run()
	{
		// Create an instance of a Server
		// Start the Server on port 6666 (which will not return until the ShutdoWn Command is received)
		// and then on exit clean everything up which will exit this thread
		Server server = new Server();
		try
		{
			server.start(6666);
			server.cleanup();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}}
