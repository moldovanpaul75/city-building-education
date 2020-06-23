package Agent.RepositoryAgent;

import Model.Repository.Repository;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RepositoryAgent implements Runnable{

    private int agentPort;
    private boolean isStopped;
    private ServerSocket agentSocket;
    private Thread runningThread;
    private ExecutorService threadPool;
    private Repository repository;

    public RepositoryAgent(int port){
        this.agentPort = port;
        this.threadPool = Executors.newFixedThreadPool(30);
        this.isStopped = false;
    }

    @Override
    public void run() {
        synchronized(this){
            this.runningThread = Thread.currentThread();
        }
        openServerSocket();

        while(!isStopped()){
            Socket socket;
            try {
                socket = this.agentSocket.accept();

                BufferedReader br = new BufferedReader(new InputStreamReader(new DataInputStream(new BufferedInputStream(socket.getInputStream()))));
                PrintWriter pw = new PrintWriter(new DataOutputStream(socket.getOutputStream()));
                GsonBuilder builder = new GsonBuilder();
                builder.excludeFieldsWithoutExposeAnnotation();

                RepositoryAgentRunnable repositoryAgentRunnable = new RepositoryAgentRunnable(this, socket, builder, pw, br);
                this.threadPool.execute(repositoryAgentRunnable);
            } catch (IOException e) {
                if(isStopped()) {
                    System.out.println("Repository server stopping.") ;
                    break;
                }else{
                    this.stop();
                    throw new RuntimeException("Error accepting connection", e);
                }
            }
        }
        this.threadPool.shutdown();
        System.out.println("Repository server stopped.") ;
    }


    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop(){
        this.isStopped = true;
        try {
            this.agentSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing repository server", e);
        }
    }

    private void openServerSocket() {
        try {
            this.agentSocket = new ServerSocket(this.agentPort);
            System.out.println(this.agentSocket + " is up.");
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port", e);
        }
    }
}
