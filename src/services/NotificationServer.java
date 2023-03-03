/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Hend
 */
public class NotificationServer {
    private static final int PORT = 9876;

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        byte[] buffer = "Hello, world!".getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), PORT);
        socket.send(packet);
        socket.close();
    }
}

