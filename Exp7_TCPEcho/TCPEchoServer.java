import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPEchoServer {
   
    private static ServerSocket servSock;
    private static final int PORT = 3000;
    

    public TCPEchoServer() {
    }

    public static void main(String[] args) {
        System.out.println("Opening port...\n");
        try
        {
            servSock = new ServerSocket(PORT);      //Step 1.
        }
        catch (IOException e)
        {
            System.out.println("Unable to attach to port!");
            System.exit(1);
        }
        do
        {
            run();
        } while(true);
    }
    
    private static void run()
    {
        Socket link = null;                        //Step 2.
        try
        {
            link = servSock.accept();               //Step 2.

            Scanner input = new Scanner(link.getInputStream() );   //Step 3.
            PrintWriter output=new PrintWriter(link.getOutputStream());//Step 3.
            int numMessages = 0;
            String message = input.nextLine();         //Step 4.
            while (!message.equals("***CLOSE***"))
            {
                System.out.println("Message received.");
                numMessages++;
                System.out.println("Message " + numMessages
                                    + ": " + message);     //Step 4.
                message = input.nextLine();
            }
            output.println(numMessages + " messages received.");	//Step 4.
	}
	catch (IOException e)
	{
            e.printStackTrace();
	}
	finally
        {
            try
            {
                System.out.println("\n* Closing connection... *");
                link.close();				    //Step 5.
            }
            catch(IOException e)
            {
                System.out.println("Unable to disconnect!");
                System.exit(1);
            }
        }
    }
}
