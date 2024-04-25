import java.net.*;
import java.io.*;
 
class FactorialClient {
    public static void main(String args[]) throws Exception {
        Socket s = new Socket("localhost", 3333);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter any number:");
        String str = br.readLine();
 
        dout.writeUTF(str);
        dout.flush();
 
        String str2 = din.readUTF();
        System.out.println("Factorial value received from server: " + str2);
 
        dout.close();
        din.close();
        s.close();
    }
}