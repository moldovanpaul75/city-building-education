package Agent.BugReportAgent;
import Model.Repository.FileRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;

public class BugReportAgentRunnable implements Runnable{

    private BugReportAgent bugReportAgent;
    private final Socket socket;
    private BufferedReader br;
    private Gson gson;
    private boolean isStopped;
    private FileRepository fileRepository;
    private LinkedBlockingQueue<String> messages;


    public BugReportAgentRunnable(BugReportAgent bugReportAgent, Socket socket, GsonBuilder builder, BufferedReader br) {
        this.bugReportAgent = bugReportAgent;
        this.socket = socket;
        this.br = br;
        this.gson = builder.create();
        this.fileRepository = new FileRepository();
        this.isStopped = false;
        this.messages = new LinkedBlockingQueue<String>();

        new Thread(new BugReportAgentMessageReceiver(this, this.messages, this.br)).start();
    }


    @Override
    public void run() {
        String received, json;
        while(!isStopped()){
            try{
                received = this.messages.take();
                if (received.startsWith("-")) {
                    if (received.contains("exit")) {
                        System.out.println("Main server sends exit...");
                        this.stop();
                    }
                    if(received.contains("report")){
                        json = messages.take();
                        this.fileRepository.fileWriter("bugs.txt", json);
                    }
                }else{
                    System.out.println(received);
                }
            } catch (InterruptedException e) {
                if (!isStopped()) this.stop();
                e.printStackTrace();
            }
        }
    }


    public synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop() {
        this.isStopped = true;
        try {
            this.socket.close();
            this.br.close();
            System.out.println("Connection closed: " + this.socket);
        } catch (IOException e) {
            throw new RuntimeException("Error closing socket", e);
        }
    }

    public Socket getConnectionSocket(){
        return this.socket;
    }
}