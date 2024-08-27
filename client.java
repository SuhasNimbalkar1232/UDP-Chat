import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class client{
        public static void main(String[] args) throws Exception{
                Scanner sc = new Scanner(System.in);
                
                int RECEIVER_PORT = 9998;
                int SERVER_PORT = 9999;
                
                DatagramSocket datagramSocket = new DatagramSocket(RECEIVER_PORT);
                InetAddress receiverAddress = InetAddress.getLocalHost();
                
                byte[] buffer;
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String str1 = "" , str2 = "";
                
                while(!str1.equals("stop")){
                        str1 = br.readLine();
                        buffer = str1.getBytes();
                        DatagramPacket packet = new DatagramPacket(buffer,buffer.length,receiverAddress,SERVER_PORT);
                        datagramSocket.send(packet);
                        
                        byte[] buffer1 = new byte[100];
                        DatagramPacket packet1 = new DatagramPacket(buffer1,buffer1.length);
                        datagramSocket.receive(packet1);
                        buffer1 = packet1.getData();
                        String str3 = new String(buffer1, StandardCharsets.UTF_8);
                        System.out.println("Server Says: "+str3);
                }
                
        }
}
