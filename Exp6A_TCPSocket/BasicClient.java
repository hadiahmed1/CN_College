import java.net.*;
class BasicClient{
    public static void main(String[] args) {
        try{
            Socket clisc=new Socket("localhost", 3000);
            System.out.println("****Find Server******");
            clisc.close();
        }
        catch(Exception e){
            System.out.println("Server not found");
            return;
        }
    }
}