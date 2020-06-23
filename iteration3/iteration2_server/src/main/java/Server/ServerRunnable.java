package Server;

import Model.Repository.FileRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;

public class ServerRunnable implements Runnable {

    private Server server;
    private final Socket clientSocket;
    private String serverText;
    private Gson gson;
    private PrintWriter pw;
    private BufferedReader br;
    private boolean isStopped;
    private LinkedBlockingQueue<String> messages;
    private FileRepository fileRepository;

    public ServerRunnable(Server server, Socket clientSocket, String serverText, GsonBuilder builder, PrintWriter pw, BufferedReader br) {
        this.server = server;
        this.clientSocket = clientSocket;
        this.serverText = serverText;
        this.messages = new LinkedBlockingQueue<String>();
        this.pw = pw;
        this.br = br;
        this.gson = builder.create();
        this.isStopped = false;
        this.fileRepository = new FileRepository();

        new Thread(new MessageReceiver(this, this.messages, this.br)).start();
    }

    @Override
    public void run() {
        this.pw.println("ServerRunnable: " + this.serverText);
        this.pw.flush();

        String received, json;
        while (!isStopped()) {
            try {
                received = this.messages.take();
                if (received.startsWith("-")) {
                    if (received.equals("-exit")) {
                        System.out.println("Client " + this.clientSocket + " sends exit...");
                        this.stop();
                    }
                    if(received.contains("send")){
                        new Thread(new ServerAgent(received, null, "localhost", 9001, this.pw)).start();
                    }
                    if(received.contains("update")){
                        json = this.messages.take();
                        this.server.notifyChange(this, json);
                        new Thread(new ServerAgent(received, json, "localhost", 9002, this.pw)).start();
                    }
                    if(received.contains("report")){
                        json = this.messages.take();
                        new Thread(new ServerAgent(received, json,"localhost", 9003, this.pw)).start();
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
        this.pw.println(message);
        this.pw.flush();
        this.pw.println(json);
        this.pw.flush();
    }
}
