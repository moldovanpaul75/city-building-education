package Server;

import Model.Repository;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {

    private int serverPort;
    private boolean isStopped;
    private ServerSocket serverSocket;
    private Thread runningThread;
    private ExecutorService threadPool;
    private Repository repository;

    private List<ServerRunnable> activeTasks = Collections.synchronizedList(new ArrayList<>());

    public Server(int port, Repository repository){
        this.serverPort = port;
        this.threadPool = Executors.newFixedThreadPool(30);
        this.isStopped = false;
        this.repository = repository;
    }

    @Override
    public void run() {
        synchronized(this){
            this.runningThread = Thread.currentThread();
        }
        openServerSocket();

        while(!isStopped()){
            Socket clientSocket;
            try {
                clientSocket = this.serverSocket.accept();

                BufferedReader br = new BufferedReader(new InputStreamReader(new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()))));
                PrintWriter pw = new PrintWriter(new DataOutputStream(clientSocket.getOutputStream()));
                GsonBuilder builder = new GsonBuilder();
                builder.excludeFieldsWithoutExposeAnnotation();

                ServerRunnable serverRunnable = new ServerRunnable(this, clientSocket, "CityBuilding Server", this.repository, builder, pw, br);
                this.activeTasks.add(serverRunnable);
                this.threadPool.execute(serverRunnable);
            } catch (IOException e) {
                if(isStopped()) {
                    System.out.println("Server stopping.") ;
                    break;
                }else{
                    this.stop();
                    throw new RuntimeException("Error accepting client connection", e);
                }
            }
        }
        this.threadPool.shutdown();
        System.out.println("Server stopped.") ;
    }


    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop(){
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
            System.out.println(this.serverSocket + " is up.");
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port", e);
        }
    }

    public synchronized void removeServerRunnable(ServerRunnable serverRunnable){
        this.activeTasks.remove(serverRunnable);
    }

    public synchronized void notifyChange(ServerRunnable serverRunnable, String json){
        for(ServerRunnable r : activeTasks){
            if(!r.equals(serverRunnable)){
                r.writeMessage("-updated_tiles", json);
            }
        }
    }
}
