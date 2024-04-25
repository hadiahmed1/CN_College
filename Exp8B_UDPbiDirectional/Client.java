import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws SocketException, IOException{
        BufferedReader clientReade=new  BufferedReader(new InputStreamReader(System.in));
        InetAddress IP=Inet4Address.getByName("127.0.0.1");//
        DatagramSocket clientSocket=new DatagramSocket();
        while(true){
            byte[] sendbuffer=new  byte[1024];
            byte[] recievebuffer=new byte[1024];
            System.out.println("Client:");
            String clientData=clientReade.readLine();
            sendbuffer=clientData.getBytes();
            DatagramPacket senPacket=new DatagramPacket(sendbuffer,sendbuffer.length, IP,9876);
            clientSocket.send(senPacket);
            if(clientData.equalsIgnoreCase("bye")){
                System.out.println("Connection ended by client");
                break;
            }
            DatagramPacket recievePacket=new DatagramPacket(recievebuffer,recievebuffer.length);
            clientSocket.receive(recievePacket);
            String serverData= new String(recievePacket.getData());
            System.out.println("Server:"+serverData);
        }
        clientSocket.close();
    }
}

