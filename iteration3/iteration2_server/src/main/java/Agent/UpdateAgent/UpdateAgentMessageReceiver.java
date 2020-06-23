package Agent.UpdateAgent;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.SocketException;
import java.util.concurrent.LinkedBlockingQueue;

public class UpdateAgentMessageReceiver implements Runnable{

    private UpdateAgentRunnable updateAgentRunnable;
    private LinkedBlockingQueue<String> messages;
    private BufferedReader br;

    public UpdateAgentMessageReceiver(UpdateAgentRunnable updateAgentRunnable, LinkedBlockingQueue<String> messages, BufferedReader br) {
        this.updateAgentRunnable = updateAgentRunnable;
        this.messages = messages;
        this.br = br;
    }

    @Override
    public void run() {
        String received;
        while (!updateAgentRunnable.isStopped()) {
            try {
                received = this.br.readLine();
                if (received != null) {
                    this.messages.put(received);
                }
            } catch (SocketException e) {
                if (e.toString().contains("Socket closed") || e.toString().contains("Connection reset") || e.toString().contains("Broken pipe")) {
                    System.out.println("Socket closed|Connection reset|Broken pipe: " + this.updateAgentRunnable.getConnectionSocket());
                } else {
                    System.out.println("Socket exception: " + this.updateAgentRunnable.getConnectionSocket() + "\n" + e.toString());
                }
                if (!updateAgentRunnable.isStopped()) this.updateAgentRunnable.stop();
            } catch (IOException | InterruptedException e) {
                if (!updateAgentRunnable.isStopped()) this.updateAgentRunnable.stop();
                e.printStackTrace();
            }
        }
    }
}
