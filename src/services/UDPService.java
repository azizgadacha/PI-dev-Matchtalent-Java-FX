/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author acer
 */
public class UDPService {
     private final DatagramSocket socket;
    private final InetAddress address;
    private final int port;

    public UDPService(String host, int port) throws IOException {
        this.address = InetAddress.getByName(host);
        this.port = port;
        this.socket = new DatagramSocket();
    }

    public void envoyerMessage(String message) throws IOException {
        byte[] buffer = message.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("localhost" ), 55555);
    socket.send(packet);
    }

    public String receiveMessage() throws IOException {
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        return new String(packet.getData(), 0, packet.getLength());
    }
    

    public void close() {
        socket.close();
    }

  
}
