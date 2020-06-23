package Agent.BugReportAgent;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.SocketException;
import java.util.concurrent.LinkedBlockingQueue;

public class BugReportAgentMessageReceiver implements Runnable{

    private BugReportAgentRunnable bugReportAgentRunnable;
    private LinkedBlockingQueue<String> messages;
    private BufferedReader br;

    public BugReportAgentMessageReceiver(BugReportAgentRunnable bugReportAgentRunnable, LinkedBlockingQueue<String> messages, BufferedReader br) {
        this.bugReportAgentRunnable = bugReportAgentRunnable;
        this.messages = messages;
        this.br = br;
    }

    @Override
    public void run() {
        String received;
        while (!bugReportAgentRunnable.isStopped()) {
            try {
                received = this.br.readLine();
                if (received != null) {
                    this.messages.put(received);
                }
            } catch (SocketException e) {
                if (e.toString().contains("Socket closed") || e.toString().contains("Connection reset") || e.toString().contains("Broken pipe")) {
                    System.out.println("Socket closed|Connection reset|Broken pipe: " + this.bugReportAgentRunnable.getConnectionSocket());
                } else {
                    System.out.println("Socket exception: " + this.bugReportAgentRunnable.getConnectionSocket() + "\n" + e.toString());
                }
                if (!bugReportAgentRunnable.isStopped()) this.bugReportAgentRunnable.stop();
            } catch (IOException | InterruptedException e) {
                if (!bugReportAgentRunnable.isStopped()) this.bugReportAgentRunnable.stop();
                e.printStackTrace();
            }
        }
    }
}