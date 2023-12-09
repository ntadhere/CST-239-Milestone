package server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

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
	public String start(Socket clientSocket) throws IOException, CustomException
	{
		// If you get here then a Client connected to this Server 
		// Create some input and output network buffers to communicate 
		// back and forth with the Client
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		// Wait for Command (string that is terminated by a line feed character)
		String inputLine;
		if ((inputLine = in.readLine()) != null)
		{
				out.println(file.convertToString());
		}
		return inputLine;
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
