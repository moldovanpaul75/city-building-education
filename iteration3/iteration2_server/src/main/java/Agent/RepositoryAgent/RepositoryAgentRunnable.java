package Agent.RepositoryAgent;

import Model.District;
import Model.Repository.Repository;
import Model.Tile;
import Model.TileType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class RepositoryAgentRunnable implements Runnable{

    private RepositoryAgent repositoryAgent;
    private final Socket socket;
    private Gson gson;
    private PrintWriter pw;
    private BufferedReader br;
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;
    private Repository repository;
    private boolean isStopped;

    private LinkedBlockingQueue<String> messages;

    public RepositoryAgentRunnable(RepositoryAgent repositoryAgent, Socket socket, GsonBuilder builder, PrintWriter pw, BufferedReader br) {
        this.repositoryAgent = repositoryAgent;
        this.socket = socket;
        this.pw = pw;
        this.br = br;
        this.gson = builder.create();
        this.isStopped = false;
        this.messages = new LinkedBlockingQueue<String>();

        this.entityManagerFactory = Persistence.createEntityManagerFactory("iteration3");
        this.entityManager = entityManagerFactory.createEntityManager();
        this.repository = new Repository(entityManager);

        new Thread(new RepositoryAgentMessageReceiver(this, this.messages, this.br)).start();
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
                    if (received.contains("tiletypes")) {
                        List<TileType> tileTypeList = repository.findAll(TileType.class);
                        json = this.gson.toJson(tileTypeList);
                        System.out.println(json);
                        this.pw.println(json);
                        this.pw.flush();
                    }
                    if (received.contains("tiles")) {
                        List<Tile> tileList = repository.findAll(Tile.class);
                        json = this.gson.toJson(tileList);
                        System.out.println(json);
                        this.pw.println(json);
                        this.pw.flush();
                    }
                    if (received.contains("districts")) {
                        List<District> districtList = repository.findAll(District.class);
                        json = this.gson.toJson(districtList);
                        System.out.println(json);
                        this.pw.println(json);
                        this.pw.flush();
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
            this.pw.close();
            this.entityManager.close();
            this.entityManagerFactory.close();
            System.out.println("Connection closed: " + this.socket);
        } catch (IOException e) {
            throw new RuntimeException("Error closing socket", e);
        }
    }

    public Socket getConnectionSocket(){
        return this.socket;
    }
}
