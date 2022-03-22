package NetCentric;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

//public class Rfc865UdpClient {
public class Client_lab3 {

    /*
     * Name: Neo Rui Xuan Berlynn
     * Group: TS8
     * IP Address: 172.21.148.31
     */

    public static void main(String[] argv) throws UnknownHostException {
        //
        // 1. Open UDP socket
        //
        System.out.println("Client running");
        DatagramSocket socket;
        InetAddress address = InetAddress.getByName("localhost");

        try {
            socket = new DatagramSocket();
        }
        catch (SocketException e) {
            e.printStackTrace();
            return;
        }

        try {
            //
            // 2. Send UDP request to server
            //
            String message = new String("ZOU ZEREN, TS8, 172.21.148.31");
            byte[] buf = message.getBytes();
            DatagramPacket request = new DatagramPacket(buf, buf.length, address, 17);
            socket.send(request);

            //
            // 3. Receive UDP reply from server
            //
            byte[] newbuf = new byte[1024];
            DatagramPacket reply = new DatagramPacket(newbuf, newbuf.length);
            socket.receive(reply);

            String received = new String(reply.getData(), 0, reply.getLength());
            System.out.println(received);
            System.out.println("end");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        socket.close();
    }
}