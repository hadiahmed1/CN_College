import java.io.*; 
import java.net.*; 
public class Server {
    public static void main(String[] args) throws SocketException, IOException{
        DatagramSocket servSocket=new DatagramSocket(9876);
        while(true) {
            byte[] sendbuffer=new  byte[1024];
            byte[] recievebuffer=new byte[1024];
            DatagramPacket recvdpkt=new DatagramPacket(recievebuffer,recievebuffer.length);
            servSocket.receive(recvdpkt);
            InetAddress IP=recvdpkt.getAddress();
            int portno=recvdpkt.getPort();
            String clientData= new String(recvdpkt.getData());
            System.out.println("Client:"+clientData);
            System.out.println("\nServer : ");
            BufferedReader serverRead=new BufferedReader(new InputStreamReader(System.in));
            String serverdata =serverRead.readLine();
            sendbuffer=serverdata.getBytes();
            DatagramPacket sendPacket=new DatagramPacket(sendbuffer,sendbuffer.length,IP,portno);
            servSocket.send(sendPacket);
            if(serverdata.equalsIgnoreCase("bye")){
                System.out.println("Conection ended by Server");
                break;
            }
        }
        servSocket.close();
    }
}
