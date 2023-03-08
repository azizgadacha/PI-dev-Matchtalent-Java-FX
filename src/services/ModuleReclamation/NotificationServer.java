/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.notification;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Hend
 */
/*public class NotificationServer {
    private static final int PORT = 9876;

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        byte[] buffer = "Hello, world!".getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), PORT);
        socket.send(packet);
        socket.close();
    }
}*/
public class NotificationServer {
    private static final int PORT = 9876;

    public static void main(String[] args) throws Exception {
        NotificationService service = new NotificationService();
        DatagramSocket socket = new DatagramSocket(PORT);
        byte[] buffer = new byte[1024];

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received: " + received);

            // Create notification object and store it in the database
            notification notif = new notification(1, received, null); //Replace 1 with the actual user ID
            service.ajouter(notif);
        }
    }
}

