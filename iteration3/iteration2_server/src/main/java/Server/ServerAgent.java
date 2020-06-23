package Server;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

public class ServerAgent implements Runnable{

    private PrintWriter mainServerPw;
    private PrintWriter agentPw;
    private BufferedReader agentBr;
    private int port;
    private String address;
    private Socket agentSocket;
    private String message;
    private String json;

    public ServerAgent(String message, String json, String address, int port, PrintWriter pw){
        this.message = message;
        this.address = address;
        this.port = port;
        this.mainServerPw = pw;
        this.json = json;
    }

    @Override
    public void run() {
        this.openAgentSocket();

        this.agentPw.println(message);
        this.agentPw.flush();

        if(json!=null) {
            this.agentPw.println(json);
            this.agentPw.flush();
        }

        String receive;
        try {
            receive = agentBr.readLine();
            if(receive!=null){
                System.out.println(receive);
                this.mainServerPw.println(receive);
                this.mainServerPw.flush();
            }
        } catch (SocketException e) {
            if (e.toString().contains("Socket closed") || e.toString().contains("Connection reset") || e.toString().contains("Broken pipe")) {
                System.out.println("ServerSocket closed|Connection reset|Broken pipe.");
            } else {
                System.out.println("ServerSocket exception: " + this.agentSocket + "\n" + e.toString());
            }
            this.closeAgentSocket();
        } catch (IOException e) {
            e.printStackTrace();
            this.closeAgentSocket();
        }
        this.closeAgentSocket();
    }

    private void openAgentSocket() {
        try {
            InetAddress ip = InetAddress.getByName(this.address);
            this.agentSocket = new Socket(ip, this.port);
            this.agentBr = new BufferedReader(new InputStreamReader(new DataInputStream(new BufferedInputStream(agentSocket.getInputStream()))));
            this.agentPw = new PrintWriter(new DataOutputStream(agentSocket.getOutputStream()));
        } catch (IOException e) {
            System.out.println("Server down.");
            throw new RuntimeException("Cannot open port", e);
        }
    }

    public synchronized void closeAgentSocket() {
        try {
            System.out.println("Closing agent socket: " + this.agentSocket);
            this.agentPw.println("-exit");
            this.agentPw.flush();
            this.agentSocket.close();
            this.agentBr.close();
            this.agentPw.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing agent socket", e);
        }
    }
}
