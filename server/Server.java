/**
 * Truong Anh Dao Nguyen
 * CST-239
 * 12/10/2023
 * This is Main Server Class
 * This is my own work
 */

package server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Server class for Milestone 6
 */
public class Server
{
	// Class member variables
		private ServerSocket serverSocket;
		private Socket clientSocket;
		private PrintWriter out;
		private BufferedReader in;
		FileService file = new FileService();
		Inventory inventory;


		
		/**
		 * Start the Server and wait for connections on the specified part.
		 * @param port Port to listen on.
		 * @throws IOException Thrown in the networking classes if something bad happened.
		 */
		public void start(int port) throws IOException
		{
			// Wait for a Client connection
			serverSocket = new ServerSocket(port);
			clientSocket = serverSocket.accept();
			
			// If you get here then a Client connected to this Server 
			// Create some input and output network buffers to communicate 
			// back and forth with the Client
//			System.out.println("Received a Admin connection on port " + clientSocket.getLocalPort());
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			// Wait for Command (string that is terminated by a line feed character)
			String inputLine;
			while ((inputLine = in.readLine()) != null)
			{
				// If period command then shut the Server down
				if(inputLine.equalsIgnoreCase("Q"))
				{
//					System.out.println("Got a message to shut the Server down");
					out.println("QUIT");
					break;
				}
				else if (inputLine.equalsIgnoreCase("R"))
				{
					out.println(file.saveToFile("admin.json", file.readFromFile("out.json")));

					}
				else if (inputLine.split(" \\| ")[0].equalsIgnoreCase("U"))
				{
					Product item = null;
					// Store updated Salable product to a separate string
					String data = inputLine.split(" \\| ")[1];
					// Split the string store data by "," to define the property of the Salable product
					String[] property = data.split(",");
					//---------------------------------------------------------
					// CHECK THE TYPE OF SALABLE PRODUCT
					//---------------------------------------------------------
					if (property[0].equalsIgnoreCase("weapon"))
					{
						item = new Weapon(property[1].trim(),property[2].trim(),Double.parseDouble(property[3].trim()),Integer.parseInt(property[4].trim()));
					}
					else if (property[0].equalsIgnoreCase("armor"))
					{
						item = new Armor(property[1].trim(),property[2].trim(),Double.parseDouble(property[3].trim()),Integer.parseInt(property[4].trim()));
					}
					else if (property[0].equalsIgnoreCase("health"))
					{
						item = new Health(property[1].trim(),property[2].trim(),Double.parseDouble(property[3].trim()),Integer.parseInt(property[4].trim()));
					}
					//---------------------------------------------------------
					List<Product> inventoryList = new ArrayList<>(Arrays.asList(file.readFromFile("out.json")));
					inventoryList.add(item);
					file.saveToFile("out.json",inventoryList.toArray(new Product[0]));
					out.println("OK");
				}
			}
		}
		/**
		 * Cleanup logic to close all the network connections.
		 * 
		 * @throws IOException Thrown if anything bad happens from the networking classed
		 */
		public void cleanup() throws IOException
		{
			// Close all input and output network buffers and sockets
			in.close();
			out.close();
			clientSocket.close();
			serverSocket.close();
		}
		
		/**
		 * Entry method for the Server application (for testing only)
		 * 
		 * @param args
		 * @throws IOException
		 */
		public static void main(String[] args) throws IOException
		{
			// Create an instance of this Server
			// Start the Server on port 6666
			// which will not return until the Shutdown Command is received
			// and then on exit clean everything up
			Server server = new Server();
			server.start(6666);
			server.cleanup();
		}
}