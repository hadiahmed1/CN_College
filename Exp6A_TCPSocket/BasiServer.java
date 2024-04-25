import java.net.ServerSocket;
import java.net.Socket;

public class BasiServer {
    public static void main(String[] args) {
        try{
            System.out.println("Waiting for Client....");
            ServerSocket server = new ServerSocket(3000);
            Socket sc=server.accept();
            server.close();
            sc.close();
        }
        catch(Exception e){
        }
    }
}
