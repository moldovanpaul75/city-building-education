package Server;

import java.util.Scanner;

public class ServerMain {
    public static void main(String[] args){
        Server server = new Server(9000);
        new Thread(server).start();

        Scanner in = new Scanner(System.in);
        while(true) {
            if (in.nextLine().equals("-stop")) {
                server.stop();
                break;
            }
        }
        in.close();
    }
}
