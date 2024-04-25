import java.io.*;
import java.util.*;
import java.net.*;
public class TCPEchoClient {
    
    private static InetAddress host;
    private static final int PORT = 3000;
        
    public TCPEchoClient() {
    }
	public static void main(String[] args) {
        try
		{
				host = InetAddress.getLocalHost();
		}
		catch(UnknownHostException e)
		{
				System.out.println("Host ID not found!");
				System.exit(1);
		}
		accessServer();
		}
		private static void accessServer()
		{
		Socket link = null;				//Step 1.
		try
		{
			link = new Socket(host,PORT);		//Step 1.
			Scanner input = new Scanner(link.getInputStream());//Step 2.
			PrintWriter out = new PrintWriter(link.getOutputStream(),true);	 //Step 2.
			//Set up stream for keyboard entry...
			Scanner userEntry = new Scanner(System.in);
			String message, response;
			do
			{
				System.out.print("Enter message: ");
				message =  userEntry.nextLine();
				out.println(message); 		//Step 3.
				response = input.nextLine();		//Step 3.
				System.out.println("\nSERVER> " + response);
			} while (!message.equals("***CLOSE***"));
			userEntry.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				System.out.println("\n* Closing connection... *");
				link.close();				//Step 4.
			}
			catch(IOException e)
			{
				System.out.println("Unable to disconnect!");
			System.exit(1);
			}
		}
    }
}
