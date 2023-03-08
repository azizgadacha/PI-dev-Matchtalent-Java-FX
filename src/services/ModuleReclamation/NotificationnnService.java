/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


/**
 *
 * @author Hend
 */


public class NotificationnnService extends Service<String> {
    private static final int PORT = 9876;
    private DatagramSocket socket;
    private byte[] buffer = new byte[1024];

    public NotificationnnService() {
        setOnSucceeded(event -> {
            String message = (String) event.getSource().getValue();
            System.out.println("Received notification: " + message);
        });
    }

    @Override
    protected Task<String> createTask() {
        return new Task<String>() {
            @Override
            protected String call() throws Exception {
                socket = new DatagramSocket(PORT);
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String data = new String(packet.getData(), 0, packet.getLength());
                socket.close();
                return data;
            }
        };
    }
}
