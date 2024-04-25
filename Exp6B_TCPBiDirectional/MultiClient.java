import java.io.*;
import java.net.*;

public class MultiClient {
    public static void main(String[] args) throws Exception {
        Socket sock=new Socket("127.0.0.1",4000);
        //READING FROM KB
        BufferedReader keyRead=new BufferedReader(new InputStreamReader(System.in));
        //SENDING TO SERVER
        OutputStream ostream=sock.getOutputStream();
        PrintWriter pwrite=new PrintWriter(ostream,true);
        //RECIEVING FROM SERVER
        InputStream iStream=sock.getInputStream();
        BufferedReader recievRead=new BufferedReader(new InputStreamReader(iStream));
        System.out.println("Start the Chat, type and press Enter");
        String recieveMessage,sendMessage;
        while(true){
            sendMessage=keyRead.readLine();
            pwrite.println(sendMessage);
            pwrite.flush();
            if((recieveMessage=recievRead.readLine())!=null)
                System.out.println(recieveMessage);
        }
    }
}
