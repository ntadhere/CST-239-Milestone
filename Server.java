package server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.CustomException;

/**
 * Server class for Activity 6_2
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
	
	public int getPort()
	{ 
		return clientSocket.getLocalPort();
	}
	public Socket connectionCheck(int port)throws IOException
	{

		serverSocket = new ServerSocket(port);
		return clientSocket = serverSocket.accept();
	}
	/**
	 * Start the Server and wait for connections on the specified part.
	 * @param port Port to listen on.
	 * @throws IOException Thrown in the networking classes if something bad happened.
	 * @throws CustomException 
	 */
	public Map<String, Object> start(Socket clientSocket) throws IOException, CustomException
	{
		// If you get here then a Client connected to this Server 
		// Create some input and output network buffers to communicate 
		// back and forth with the Client
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		Product item = null;
		// Wait for Command (string that is terminated by a line feed character)
		String inputLine = in.readLine();
		if (inputLine.equalsIgnoreCase("R"))
		{
			out.println(file.listToJson(file.useFile()));
		}
		else if (inputLine.split(" \\| ")[0].equalsIgnoreCase("U"))
		{
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
			out.println("OK");
			inputLine = inputLine.split(" \\ | ")[0];
		}
		Map<String, Object> map = new HashMap<>();
		map.put("data", inputLine);
		map.put("product", item);
		return map;
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

}
