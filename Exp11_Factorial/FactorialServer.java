import java.net.*;
import java.io.*;
 
class FactServer {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(3333);
        System.out.println("Server started. Waiting for client...");
 
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
 
        String str = din.readUTF();
        int n = Integer.parseInt(str);
        System.out.println("Received number from client: " + n);
 
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
 
        String result = "Factorial value is: " + f;
        dout.writeUTF(result);
        dout.flush();
 
        dout.close();
        din.close();
        s.close();
        ss.close();
    }
}
 