package NetCentric;


import java.io.*;
import java.net.*;

public class Server {

    static int PORT = 17;
    static String MESSAGE = "To be or not to be";

    public static void main(String[] argv) throws Exception {
        //
        // 1. Open UDP socket at well-known port
        //
        DatagramSocket socket = null;
        socket = new DatagramSocket(PORT);
        while (true) {
            //
            // 2. Listen for UDP request from client
            //
            byte[] buf = new byte[512];
            DatagramPacket request = new DatagramPacket(buf, buf.length);
            socket.receive(request);

            /* Process the request */
            String requestContent = new String(buf);
            System.out.println("Received request: " + requestContent);

            InetAddress clientAddress = request.getAddress();

            int clientPort = request.getPort();

            //
            // 3. Send UDP reply to client
            //
            String replyMsg = MESSAGE;
            byte[] replyBuf = replyMsg.getBytes("UTF-8");
            System.out.println("Reply content: " + replyMsg);

            DatagramPacket reply = new DatagramPacket(replyBuf, replyBuf.length, clientAddress, clientPort);
            System.out.println("Sending reply...");
            socket.send(reply);
            System.out.println("Reply sent");
        }
    }

}

