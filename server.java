import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class server{
        public static void main(String[] args)throws Exception{
                Scanner sc = new Scanner(System.in);
                
                int RECEIVER_PORT = 9998;
                int SERVER_PORT = 9999;
                
                DatagramSocket datagramSocket = new DatagramSocket(SERVER_PORT);
                InetAddress receiverAddress = InetAddress.getLocalHost();
                
                byte[] buffer;
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String str1 = "" , str2 = "";
                
                while(!str1.equals("stop")){
                        byte[] buffer1 = new byte[100];
                        DatagramPacket packet1 = new DatagramPacket(buffer1,buffer1.length);
                        datagramSocket.receive(packet1);
                        buffer1 = packet1.getData();
                        String str3 = new String(buffer1, StandardCharsets.UTF_8);
                        System.out.println("Client Says: "+str3);
                        
                        str2 = br.readLine();
                        buffer = str2.getBytes();
                        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, receiverAddress, RECEIVER_PORT);
                        datagramSocket.send(packet);
                }
        
        }
}
