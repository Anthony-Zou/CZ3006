package NetCentric;

/**
 * @(#)UPDClient.java
 *
 * UPDClient application
 *
 * @author
 * @version 1.00 2021/3/18
 */

import java.io.*;
import java.net.*;

public class Client {

    static int PORT = 17;
    static String SERVER = "localhost";

    public static void main(String[] argv) throws IOException {
        //
        // 1. Open UDP socket
        //
        DatagramSocket socket = null;

        InetAddress serverAddress = InetAddress.getByName(SERVER);
        socket = new DatagramSocket();
        socket.connect(serverAddress, PORT);

        //
        // 2. Send UDP request to server
        //
        String message = "test, SSP2, " + InetAddress.getLocalHost().getHostAddress();
        byte[] buf = message.getBytes("UTF-8");
        DatagramPacket request = new DatagramPacket(buf, buf.length);

        System.out.println("Sending request...");
        socket.send(request);
        System.out.println("Request sent to server.");
        //
        // 3. Receive UDP reply from server
        //
        byte[] replyBuf = new byte[512];

        DatagramPacket reply = new DatagramPacket(replyBuf, replyBuf.length);;
        socket.receive(reply);

        /* Process the reply */
        String replyContent = new String(replyBuf);
        System.out.println("Received reply: " + replyContent);
        // Received reply: Just because something doesn't do what you planned it to do doesn't mean it's useless - Thomas A. Edison.
    }
}

