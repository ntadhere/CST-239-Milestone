package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class AdminService
{
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	/**
	 * Connect to the remote Server on the specified IP Address and Port
	 *
	 * @param ip Remote IP Address to connect to
	 * @param port Remote Port to connect to 
	 * 
	 * @throws UnknownHostException Thrown if network resolution exception.
	 * @throws IOException Thrown if anything bad happens from any of the networking classes
	 */
	public void start(String ip, int port) throws UnknownHostException, IOException
	{
		// Connect to the Remote Server on the specified IP Address and Port
		clientSocket = new Socket(ip, port);
		
		// Create some input and output network buffers to communicate back
		// and forth with the Server
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}
	
	/**
	 * Send a Message to the Server
	 * 
	 * @param msg Message to send.
	 * @return Response back from the Server.
	 * @throws IOException Thrown if anything bad happens from any of the networking classes.
	 */
	public String sendMessage(String msg) throws IOException
	{
		//Send/Print a Message to Server with a terminating line feed
		out.println(msg);
		// Return the response from the Server
		return in.readLine();
	}
	
	/**
	 * Cleanup logic to close all the network connections
	 * 
	 * @throws IOException Thrown if anything bad happens from the networking classes
	 */
	public void cleanup() throws IOException
	{
		// Close all input and output network buffers and sockets
		in.close();
		out.close();
		clientSocket.close();
	}
	
	public String getMessage(String msg) throws IOException
	{
		return msg;
		
	}
}
