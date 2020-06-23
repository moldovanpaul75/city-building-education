package Client;


import Controller.MainFrameController;
import Model.*;
import View.MainFrame;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class Client implements Runnable, Observer {

    private int port;
    private String address;
    private Socket clientSocket;
    private BufferedReader br;
    private PrintWriter pw;
    private Gson gson;
    private boolean isStopped;

    private List<Tile> tileList;
    private List<TileType> tileTypeList;
    private List<District> districtList;
    private MainFrame mainFrame;
    private MainFrameController mainFrameController;
    private OpenWeatherMap openWeatherMap;

    public Client(String address, int port) {
        this.address = address;
        this.port = port;
        this.isStopped = false;

        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        this.gson = builder.create();
        this.openWeatherMap = new OpenWeatherMap();
    }

    @Override
    public void run() {
        openClientSocket();
        this.pw.println("Client connected: " + this.clientSocket);
        this.pw.flush();

        String received;
        try {
            received = br.readLine();
            System.out.println(received);

            pw.println("-send_tiletypes");
            pw.flush();
            String json = br.readLine();
            this.tileTypeList = gson.fromJson(json, new TypeToken<List<TileType>>() {
            }.getType());
            System.out.println(json);   

            pw.println("-send_tiles");
            pw.flush();
            json = br.readLine();
            System.out.println(json);
            this.tileList = gson.fromJson(json, new TypeToken<List<Tile>>(){}.getType());

            pw.println("-send_districts");
            pw.flush();
            json = br.readLine();
            System.out.println(json);
            this.districtList = gson.fromJson(json, new TypeToken<List<District>>(){}.getType());


            this.initializeController();

            while (!isStopped()) {
                received = this.br.readLine();
                if(received.startsWith("-")){
                    if(received.equals("-updated_tiles")){
                        json = br.readLine();
                        System.out.println(json);
                        Tile updatedTile = this.gson.fromJson(json, Tile.class);
                        this.mainFrame.getTilePanel().updateTile(updatedTile);
                        this.mainFrame.getLoggerConsole().append("Updated tile: " + updatedTile);
                    }
                } else{
                    System.out.println(received);
                }
            }
        } catch (SocketException e) {
            if (e.toString().contains("Socket closed") || e.toString().contains("Connection reset") || e.toString().contains("Broken pipe")) {
                    System.out.println("ServerSocket closed|Connection reset|Broken pipe.");
            } else {
                System.out.println("ServerSocket exception: " + this.clientSocket + "\n" + e.toString());
            }
            if (!this.isStopped()) this.stop();
        } catch (Exception e) {
            e.printStackTrace();
            if (!this.isStopped()) this.stop();
        }
    }

    public synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop() {
        this.isStopped = true;
        try {
            System.out.println("Closing this connection: " + this.clientSocket);
            this.pw.println("-exit");
            this.pw.flush();
            this.clientSocket.close();
            this.br.close();
            this.pw.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing client socket", e);
        }
    }

    private void openClientSocket() {
        try {
            InetAddress ip = InetAddress.getByName(this.address);
            this.clientSocket = new Socket(ip, this.port);
            this.br = new BufferedReader(new InputStreamReader(new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()))));
            this.pw = new PrintWriter(new DataOutputStream(clientSocket.getOutputStream()));
        } catch (IOException e) {
            System.out.println("Server down.");
            throw new RuntimeException("Cannot open port", e);
        }
    }

    private void initializeController() {
        this.mainFrameController.setClient(this);
        this.mainFrameController.setMainFrame(this.mainFrame);
        this.mainFrameController.setTileList(this.tileList);
        this.mainFrameController.setTileTypeList(this.tileTypeList);
        this.mainFrameController.setDistrictList(this.districtList);
        this.mainFrameController.initializeMainFrame();
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void setMainFrameController(MainFrameController mainFrameController) {
        this.mainFrameController = mainFrameController;
    }

    public Socket getClientSocket(){
        return this.clientSocket;
    }

    public OpenWeatherMap getOpenWeatherMap() {
        return openWeatherMap;
    }

    public void reportBug(Bug bug){
        String json = gson.toJson((Bug) bug);
        this.pw.println("-report_bug");
        this.pw.flush();
        this.pw.println(json);
        this.pw.flush();
    }

    @Override
    public synchronized void update(Observable o, Object arg) {
        String json = gson.toJson((Tile) arg);
        this.pw.println("-update_tile");
        this.pw.flush();
        this.pw.println(json);
        this.pw.flush();
    }
}
