package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageReceiver implements Runnable {

    private ServerRunnable serverRunnable;
    private LinkedBlockingQueue<String> messages;
    private BufferedReader br;

    public MessageReceiver(ServerRunnable serverRunnable, LinkedBlockingQueue<String> messages, BufferedReader br) {
        this.serverRunnable = serverRunnable;
        this.messages = messages;
        this.br = br;
    }

    @Override
    public void run() {
        String received;
        while (!serverRunnable.isStopped()) {
            try {
                received = this.br.readLine();
                if (received != null) {
                    this.messages.put(received);
                }
            } catch (SocketException e) {
                if (e.toString().contains("Socket closed") || e.toString().contains("Connection reset") || e.toString().contains("Broken pipe")) {
                    System.out.println("Socket closed|Connection reset|Broken pipe: " + this.serverRunnable.getClientSocket());
                } else {
                    System.out.println("Socket exception: " + this.serverRunnable.getClientSocket() + "\n" + e.toString());
                }
                if (!serverRunnable.isStopped()) this.serverRunnable.stop();
            } catch (IOException | InterruptedException e) {
                if (!serverRunnable.isStopped()) this.serverRunnable.stop();
                e.printStackTrace();
            }
        }
    }
}
