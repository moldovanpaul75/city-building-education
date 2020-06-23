package Server;

import Model.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class ServerRunnable implements Runnable {

    private Server server;
    private final Socket clientSocket;
    private String serverText;
    private Repository repository;
    private Gson gson;
    private PrintWriter pw;
    private BufferedReader br;
    private boolean isStopped;
    private LinkedBlockingQueue<String> messages;
    private FileRepository fileRepository;

    public ServerRunnable(Server server, Socket clientSocket, String serverText, Repository repository, GsonBuilder builder, PrintWriter pw, BufferedReader br) {
        this.server = server;
        this.clientSocket = clientSocket;
        this.serverText = serverText;
        this.messages = new LinkedBlockingQueue<String>();
        this.pw = pw;
        this.br = br;
        this.repository = repository;
        this.gson = builder.create();
        this.isStopped = false;
        this.fileRepository = new FileRepository();

        new Thread(new MessageReceiver(this, this.messages, this.br)).start();
    }

    @Override
    public void run() {
        this.pw.println("WorkerRunnable: " + this.serverText);
        this.pw.flush();

        String received, json;
        while (!isStopped()) {
            try {
                received = messages.take();
                if (received.startsWith("-")) {
                    if (received.equals("-exit")) {
                        System.out.println("Client " + this.clientSocket + " sends exit...");
                        this.stop();
                    }
                    if (received.equals("-send_tiletypes")) {
                        List<TileType> tileTypeList = repository.findAll(TileType.class);
                        json = this.gson.toJson(tileTypeList);
                        this.pw.println(json);
                        this.pw.flush();
                    }
                    if (received.equals("-send_tiles")) {
                        List<Tile> tileList = repository.findAll(Tile.class);
                        json = this.gson.toJson(tileList);
                        this.pw.println(json);
                        this.pw.flush();
                    }
                    if (received.equals("-send_districts")) {
                        List<District> districtList = repository.findAll(District.class);
                        json = this.gson.toJson(districtList);
                        this.pw.println(json);
                        this.pw.flush();
                    }
                    if (received.equals("-update_tile")) {
                        json = messages.take();
                        Tile updatedTile = this.gson.fromJson(json, Tile.class);
                        this.repository.merge(updatedTile);
                        this.server.notifyChange(this, json);
                    }
                    if(received.equals("-updated_tiles")){
                        pw.println(received);
                        pw.flush();
                        json = messages.take();
                        pw.println(json);
                        pw.flush();
                    }
                    if(received.equals("-report_bug")){
                        json = messages.take();
                        this.fileRepository.fileWriter("bugs.txt", json);
                    }
                } else {
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
        this.server.removeServerRunnable(this);
        try {
            this.clientSocket.close();
            this.br.close();
            this.pw.close();
            System.out.println("Connection closed: " + this.clientSocket);
        } catch (IOException e) {
            throw new RuntimeException("Error closing client socket", e);
        }
    }

    public Socket getClientSocket(){
        return this.clientSocket;
    }

    public synchronized void writeMessage(String message, String json) {
        messages.add(message);
        messages.add(json);
    }
}
