package Agent.RepositoryAgent;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.SocketException;
import java.util.concurrent.LinkedBlockingQueue;

public class RepositoryAgentMessageReceiver implements Runnable{

    private RepositoryAgentRunnable repositoryAgentRunnable;
    private LinkedBlockingQueue<String> messages;
    private BufferedReader br;

    public RepositoryAgentMessageReceiver(RepositoryAgentRunnable repositoryAgentRunnable, LinkedBlockingQueue<String> messages, BufferedReader br) {
        this.repositoryAgentRunnable = repositoryAgentRunnable;
        this.messages = messages;
        this.br = br;
    }

    @Override
    public void run() {
        String received;
        while (!repositoryAgentRunnable.isStopped()) {
            try {
                received = this.br.readLine();
                if (received != null) {
                    this.messages.put(received);
                }
            } catch (SocketException e) {
                if (e.toString().contains("Socket closed") || e.toString().contains("Connection reset") || e.toString().contains("Broken pipe")) {
                    System.out.println("Socket closed|Connection reset|Broken pipe: " + this.repositoryAgentRunnable.getConnectionSocket());
                } else {
                    System.out.println("Socket exception: " + this.repositoryAgentRunnable.getConnectionSocket() + "\n" + e.toString());
                }
                if (!repositoryAgentRunnable.isStopped()) this.repositoryAgentRunnable.stop();
            } catch (IOException | InterruptedException e) {
                if (!repositoryAgentRunnable.isStopped()) this.repositoryAgentRunnable.stop();
                e.printStackTrace();
            }
        }
    }
}
