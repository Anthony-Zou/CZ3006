package NetCentric;
import java.io.*;
import java.net.*;

public class anotherClient {
    public static void main( String[] argv){
        int port = 17;
        InetAddress address;
        DatagramSocket socket;
        try{
            socket = new DatagramSocket();
            System.out.println("Client");
        }
        catch ( SocketException e){
            System.out.println("socket Extension");
            socket = null;
        }
        byte [] bytes = new byte[65536];
        byte [] msg = "Zou zeren, ssp2,localhost".getBytes();
        try{
            address = InetAddress.getByName("localhost");
        }
        catch(UnknownHostException e){
            address = null;
            System.out.println("Cannot find localhost");
        }
        try{
            DatagramPacket request = new DatagramPacket(msg, msg.length, address, port);
            socket.send(request);
            DatagramPacket reply = new DatagramPacket(bytes, bytes.length);
            socket.receive(reply);
            System.out.println(new String(reply.getData(),0,reply.getLength()));

        }catch(IOException e){
            System.out.println("ioException");
        }
    }
}
