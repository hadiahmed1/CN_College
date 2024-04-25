import java.net.*;
import java.io.*;
public class MultiServer {
    public static void main(String[] args) throws Exception {
        ServerSocket sersock=new ServerSocket(4000);
        System.out.println("Server Ready!!!!!!");
        Socket sock=sersock.accept();
        BufferedReader keyRead=new BufferedReader(new InputStreamReader(System.in));
        OutputStream ostream=sock.getOutputStream();
        PrintWriter pwrite=new PrintWriter(ostream,true);
        InputStream iStream=sock.getInputStream();
        BufferedReader recievRead=new BufferedReader(new InputStreamReader(iStream));
        String recieveMessage,sendMessage;
        while(true){
            if((recieveMessage=recievRead.readLine())!=null){
                System.out.println(recieveMessage);   
                sendMessage=keyRead.readLine();
                pwrite.println(sendMessage);
                pwrite.flush(); 
            }     
        }
        
    }
}
